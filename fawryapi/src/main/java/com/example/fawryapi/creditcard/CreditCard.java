package com.example.fawryapi.creditcard;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(
        name = "credit_card",
        uniqueConstraints = {
                @UniqueConstraint(name = "credit_card_number",columnNames = "credit_card_number" )
        }
)
public class CreditCard {
    @Id
    @SequenceGenerator(
            name = "credit_sequence",
            sequenceName = "credit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_sequence"
    )
    @Column(name = "credit_card_id")
    private Long creditCardId;

    @Length(min= 4, max= 8)
    @Column(name = "credit_card_number", nullable = false)
    private String creditCardNumber;

    @Column(name = "credit_card_balance", nullable = false)
    private double creditCardBalance;
}
