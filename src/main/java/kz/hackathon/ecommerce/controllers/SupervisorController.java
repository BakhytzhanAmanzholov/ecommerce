package kz.hackathon.ecommerce.controllers;

import kz.hackathon.ecommerce.dto.request.ChangeRoleDto;
import kz.hackathon.ecommerce.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/supervisor")
public class SupervisorController {
    private final AccountService accountService;

    @PatchMapping("/role")
    public ResponseEntity<?> changeRole(@RequestBody ChangeRoleDto dto) {
        if (accountService.changeRole(dto.getEmail(), dto.getRole())) {
            return new ResponseEntity<>("Account by email " + dto.getEmail() + " successfully changed role to"
                    + dto.getRole(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
