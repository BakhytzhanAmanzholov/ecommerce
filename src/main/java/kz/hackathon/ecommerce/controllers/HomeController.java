package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.mappers.AccountMapper;
import kz.hackathon.ecommerce.dto.mappers.RequestProductMapper;
import kz.hackathon.ecommerce.dto.mappers.RequestSellerMapper;
import kz.hackathon.ecommerce.dto.mappers.SurveyMapper;
import kz.hackathon.ecommerce.dto.request.IdsDto;
import kz.hackathon.ecommerce.dto.request.RegistrationDto;
import kz.hackathon.ecommerce.dto.request.RequestProductDto;
import kz.hackathon.ecommerce.dto.request.RequestSellerDto;
import kz.hackathon.ecommerce.dto.response.SurveyDto;
import kz.hackathon.ecommerce.models.*;
import kz.hackathon.ecommerce.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final AccountService accountService;

    private final RequestSellerService requestSellerService;

    private final RequestProductService requestProductService;

    private final ProductService productService;

    private final SurveyService surveyService;

    private final AnswerService answerService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto dto) {
        try {
            accountService.findByEmail(dto.getEmail());
        } catch (UsernameNotFoundException e) {
            Account account = AccountMapper.fromRequestDto(dto);
            account = accountService.save(account);
            return new ResponseEntity<>(AccountMapper.toResponseDto(account), HttpStatus.OK);
        }
        return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/request/seller")
    public ResponseEntity<?> sendRequestToSeller(@RequestBody RequestSellerDto dto) {
        RequestSeller requestSeller = RequestSellerMapper.fromRequestDto(dto);
        requestSeller.setAccount(accountService.findByEmail(accountService.isLogged()));
        requestSellerService.save(requestSeller);
        return new ResponseEntity<>("Request is send", HttpStatus.OK);
    }

    @PostMapping("/request/product")
    public ResponseEntity<?> sendRequestToProduct(@RequestBody RequestProductDto dto) {

        // TODO: сделать в филтре проверку на sellera

        RequestProduct requestProduct = RequestProductMapper.fromRequestDto(dto);
        for (String artifact : dto.getArtifacts()) {
            requestProduct.getProducts().add(productService.findByArtifact(artifact));
        }
        requestProduct.setAccount(accountService.findByEmail(accountService.isLogged()));
        requestProductService.save(requestProduct);

        return new ResponseEntity<>("Request is send", HttpStatus.OK);
    }

    @GetMapping("/survey")
    public ResponseEntity<?> getSurvey() {

        List<Survey> surveyList = surveyService.findAll();
        List<SurveyDto> dtoList = new ArrayList<>();

        for (Survey survey : surveyList) {
            dtoList.add(
                    SurveyMapper.toResponseDto(survey)
            );
        }

        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("/survey")
    public ResponseEntity<?> answerToSurvey(@RequestBody IdsDto ids) {
        for (Long id: ids.getIds()){
            Answer answer = answerService.findById(id);
            productService.addProductsToAccount(answer.getProducts());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profile(){
        return ResponseEntity.ok(AccountMapper.toResponseDto(accountService.findByEmail(accountService.isLogged())));
    }
}
