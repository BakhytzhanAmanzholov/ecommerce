package kz.hackathon.ecommerce.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String artifact;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<PriceInfo> prices;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private Category category;
}
