package com.favourscode.customer;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @SequenceGenerator(name = "customer-id_sequence",
            sequenceName = "customer-id_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence_id")

    private Integer id;
    private String name;
    private String lastName;
    private String email;
}
