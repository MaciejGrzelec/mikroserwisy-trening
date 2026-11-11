package org.maciek.patient;

import lombok.RequiredArgsConstructor;
import org.maciek.patient.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserSummaryResponse> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PatchMapping("/active")
    public ResponseEntity<Void> updateActive(@RequestBody UpdateActiveRequest request) {
        userService.updateActive(request);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/statistics")
    public UserStatisticsResponse getStatistics() {
        return userService.getStatistics();
    }

    @PatchMapping("/{userId}/addresses/active")
    public ResponseEntity<Void> updateAddressesActive(
            @PathVariable Long userId,
            @RequestBody List<AddressActiveUpdate> updates
    ) {
        userService.updateAddressesActive(userId, updates);

        return ResponseEntity.noContent().build();
    }
}