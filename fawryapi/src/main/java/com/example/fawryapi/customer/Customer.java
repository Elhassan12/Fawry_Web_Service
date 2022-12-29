package com.example.fawryapi.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
        name = "cutomer_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_name", columnNames = "customer_name"),
                @UniqueConstraint(name = "customer_email", columnNames = "customer_email")
        }
)
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name = "customer_id")
    private Long customerID;

    @Column(name = "customer_name", nullable = false)
    private String userName;

    @Email
    @Column(name = "customer_email", nullable = false)
    private String email;

    @Column(name = "wallet_amount")
    private double walletAmount;

    @Length(min = 4, max = 8)
    @Column(name = "customer_password", nullable = false)
    private String password;
}



