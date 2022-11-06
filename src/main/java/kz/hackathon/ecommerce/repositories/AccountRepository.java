package kz.hackathon.ecommerce.repositories;

import kz.hackathon.ecommerce.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);

    List<Account> findAllByRole(Account.Role role);
}
