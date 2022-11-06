package kz.hackathon.ecommerce.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Account {
    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED, BANNED
    }

    public enum Role {
        USER, SUPERVISOR, SELLER, ADMIN, COSMETOLOGIST
    }

    public enum Subscription {
        ENABLED, DISABLED, TRIAL, EARLIER, COSMETOLOGIST
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String name;
    private String surname;
    private String password;

    private Boolean confirmed = false;

    private Boolean banned = false;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Subscription subscription;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Product> preferencesProducts = new HashSet<>();

    @OneToMany
    private List<InfoProduct> purchasedProducts;

    @OneToMany
    private List<CosmetologistInfo> cosmetologistInfos;
}
