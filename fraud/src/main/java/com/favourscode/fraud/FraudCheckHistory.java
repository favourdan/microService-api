package com.favourscode.fraud;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name="fraud_sequence_id",
            sequenceName = "fraud_sequence_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE
             ,generator = "fraud_sequence_id" )
    private Integer id;
    private Integer customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;

}
