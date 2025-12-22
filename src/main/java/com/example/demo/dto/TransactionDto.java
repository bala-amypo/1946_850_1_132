package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long transactionId;
    private Long matchId;
    private String status;
    private LocalDateTime completedDate;
    private Integer offererRating;
    private Integer requesterRating;
}
