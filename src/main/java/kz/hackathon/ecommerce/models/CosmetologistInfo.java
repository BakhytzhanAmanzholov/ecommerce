package kz.hackathon.ecommerce.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CosmetologistInfo {
    public enum Sphere {
        Cosmetologist, Dermatologist, Makeup
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Sphere state;
    @ManyToOne
    @ToString.Exclude
    private Account cosmetologist;
    private Integer price;
    @OneToMany
    private List<CosmetologistTime> times;
}
