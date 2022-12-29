package com.example.fawryapi.admin;

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
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "admin_name",columnNames = "admin_name")
})
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_name",nullable = false)
    private String userName;

    @Length(min = 4, max = 8)
    @Column(name = "admin_password",nullable = false)
    private String password;
}



