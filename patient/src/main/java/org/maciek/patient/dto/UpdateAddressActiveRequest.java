package org.maciek.patient.dto;

import java.util.List;

public record UpdateAddressActiveRequest(
        List<AddressActiveUpdate> addresses
) {
}
