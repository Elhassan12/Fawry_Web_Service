package com.example.fawryapi.transaction.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(
        name = "transaction"
)
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long transactionID;
    @Column(name = "status")
    private String status = " ";
    private String paymentway;
    private Date transactionDate;

    @Column(name = "customer_id",nullable = false)
    private Long customerId;

    private String providerName;
    private String serviceName;
    private String sentTo;
    private double amount;

    @Column(name = "complete")
    private boolean complete;

    public Transaction(Long id) {
        this.customerId = id;
    }
}
//