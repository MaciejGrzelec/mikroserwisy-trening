package org.maciek.patient.dto;

public record UserSummaryResponse(
        Long id,
        String name,
        String email
) {
}
