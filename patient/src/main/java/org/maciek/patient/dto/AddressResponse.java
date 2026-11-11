package org.maciek.patient.dto;

import org.maciek.patient.AddressType;

public record AddressResponse(
        Long id,
        String street,
        String city,
        String postalCode,
        String country,
        AddressType type,
        boolean active
) {
}
