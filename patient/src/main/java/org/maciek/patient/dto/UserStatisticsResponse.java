package org.maciek.patient.dto;

public record UserStatisticsResponse(
        long lowRisk,
        long mediumRisk,
        long highRisk,
        long activeUsers,
        long inactiveUsers
) {
}
