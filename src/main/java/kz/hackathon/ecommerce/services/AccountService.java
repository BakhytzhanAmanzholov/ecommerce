package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.Account;

public interface AccountService extends CrudService<Account, Long> {
    Account findByEmail(String email);

    String isLogged();

    Boolean changeRole(String email, String role);
}