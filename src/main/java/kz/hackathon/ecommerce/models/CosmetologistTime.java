package kz.hackathon.ecommerce.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CosmetologistTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @ToString.Exclude
    private Account cosmetologist;
    @ManyToOne
    @ToString.Exclude
    private Account account;
    private Time time;
}
