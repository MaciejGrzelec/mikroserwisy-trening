package org.maciek.patient.dto;


import org.maciek.patient.RiskTolerance;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(
        Long id,
        String name,
        String email,
        Integer age,
        RiskTolerance riskTolerance,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<AddressResponse> addresses
) {
}