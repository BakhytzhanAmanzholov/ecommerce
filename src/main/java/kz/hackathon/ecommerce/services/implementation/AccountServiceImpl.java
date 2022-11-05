package kz.hackathon.ecommerce.services.implementation;

import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.PriceInfo;
import kz.hackathon.ecommerce.repositories.AccountRepository;
import kz.hackathon.ecommerce.services.AccountService;
import kz.hackathon.ecommerce.services.PriceInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kz.hackathon.ecommerce.models.Account.State.CONFIRMED;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    private final PriceInfoService priceInfoService;

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User <" + email + "> not found"));
    }

    @Override
    public String isLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        log.info(currentPrincipalName);
        if (!currentPrincipalName.equals("anonymousUser")) {
            return currentPrincipalName;
        }
        return "anonymousUser";
    }

    @Override
    public Account save(Account user) {
        log.info("Saving new User {}", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmed(true);
        user.setState(CONFIRMED);
//        emailSenderService.sendEmail(user.getEmail(), user.getUsername()); // Отправка письма
        user = accountRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long aLong) {
        Account account = findById(aLong);
        accountRepository.delete(account);
    }

    @Override
    public Account update(Account entity) {
        Account account = findById(entity.getId());
        account.setName(entity.getName());
        account.setSurname(entity.getSurname());
        return account;
    }

    @Override
    public Account findById(Long aLong) {
        return accountRepository.findById(aLong).orElseThrow(
                () -> new UsernameNotFoundException("User <" + aLong + "> not found"));
    }

    @Override
    public Boolean changeRole(String email, String roleName) {
        Account account = findByEmail(email);
        for (Account.Role roleIterator : Account.Role.values()) {
            if (roleName.equals(roleIterator.name())) {
                account.setRole(roleIterator);
                return true;
            }
        }
        return false;
    }

    @Override
    public void addPriceInfoToAccount(Account account, PriceInfo priceInfo) {
        Account realAccount = findByEmail(account.getEmail());
        PriceInfo real = priceInfoService.findById(priceInfo.getId());
        real.setAccount(realAccount);
    }
}
