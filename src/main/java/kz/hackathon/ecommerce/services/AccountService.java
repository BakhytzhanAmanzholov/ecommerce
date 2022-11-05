package kz.hackathon.ecommerce.services;

import kz.hackathon.ecommerce.models.Account;
import kz.hackathon.ecommerce.models.PriceInfo;
import kz.hackathon.ecommerce.models.Product;

public interface AccountService extends CrudService<Account, Long> {
    Account findByEmail(String email);

    String isLogged();

    Boolean changeRole(String email, String role);

    void addPriceInfoToAccount(Account account, PriceInfo priceInfo);

}