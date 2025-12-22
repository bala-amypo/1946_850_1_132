package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDto {
    private Long matchId;
    private Long offerId;
    private Long requestId;
    private Long matchedUserId;
    private String matchStatus;
    private Double matchScore;
}
