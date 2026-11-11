package org.maciek.patient.dto;

import java.util.List;

public record UpdateActiveRequest(
        List<UserActiveUpdate> users
) {
}