package org.maciek.patient;

import lombok.RequiredArgsConstructor;
import org.maciek.patient.dto.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void updateAddressesActive(
            Long userId,
            List<AddressActiveUpdate> updates
    ) {
        if (updates == null || updates.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Address updates cannot be empty"
            );
        }

        User user = userRepository
                .findWithAddressesById(userId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found: " + userId
                        )
                );

        Map<Long, Address> addressesById = user.getAddresses()
                .stream()
                .collect(Collectors.toMap(
                        Address::getId,
                        Function.identity()
                ));

        Set<Long> updatedIds = new HashSet<>();

        updates.forEach(update -> {

            if (update == null || update.id() == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Address id cannot be null"
                );
            }

            if (!updatedIds.add(update.id())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Duplicate address id: " + update.id()
                );
            }

            Address address = Optional
                    .ofNullable(addressesById.get(update.id()))
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Address not found for user: " + update.id()
                            )
                    );

            address.setActive(update.active());
        });
    }

    @Transactional(readOnly = true)
    public List<UserSummaryResponse> getUsers() {

        return userRepository
                .findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(user -> new UserSummaryResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {

        User user = userRepository
                .findWithAddressesById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found: " + id
                        )
                );

        List<AddressResponse> addresses = user.getAddresses()
                .stream()
                .map(address -> new AddressResponse(
                        address.getId(),
                        address.getStreet(),
                        address.getCity(),
                        address.getPostalCode(),
                        address.getCountry(),
                        address.getType(),
                        address.isActive()
                ))
                .toList();

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                user.getRiskTolerance(),
                user.isActive(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                addresses
        );
    }

    @Transactional
    public void updateActive(UpdateActiveRequest request) {

        if (request == null || request.users() == null || request.users().isEmpty()) {
            return;
        }

        Set<Long> ids = request.users()
                .stream()
                .map(UserActiveUpdate::id)
                .collect(Collectors.toSet());

        List<User> users = userRepository.findAllById(ids);

        Map<Long, User> usersById = users.stream()
                .collect(Collectors.toMap(
                        User::getId,
                        Function.identity()
                ));

        request.users().forEach(update -> {

            User user = Optional
                    .ofNullable(usersById.get(update.id()))
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "User not found: " + update.id()
                            )
                    );

            user.setActive(update.active());
        });
    }

    @Transactional(readOnly = true)
    public UserStatisticsResponse getStatistics() {

        List<User> users = userRepository.findAll();

        return new UserStatisticsResponse(
                users.stream().filter(u ->
                        u.getRiskTolerance() == RiskTolerance.LOW
                ).count(),

                users.stream().filter(u ->
                        u.getRiskTolerance() == RiskTolerance.MEDIUM
                ).count(),

                users.stream().filter(u ->
                        u.getRiskTolerance() == RiskTolerance.HIGH
                ).count(),

                users.stream().filter(User::isActive).count(),

                users.stream().filter(u -> !u.isActive()).count()
        );
    }


}