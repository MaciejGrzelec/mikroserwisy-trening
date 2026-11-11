package org.maciek.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) {

        if (userRepository.count() > 0) {
            return;
        }

        List<User> users = List.of(
                createUser("Adam", 28, RiskTolerance.LOW, true),
                createUser("Kasia", 31, RiskTolerance.HIGH, true),
                createUser("Tomek", 25, RiskTolerance.MEDIUM, false),
                createUser("Ania", 33, RiskTolerance.LOW, false),
                createUser("Marek", 40, RiskTolerance.HIGH, true),
                createUser("Ola", 27, RiskTolerance.MEDIUM, true),

                createUser("Adam1", 29, RiskTolerance.LOW, false),
                createUser("Kasia1", 32, RiskTolerance.HIGH, false),
                createUser("Tomek1", 26, RiskTolerance.MEDIUM, false),
                createUser("Ania1", 34, RiskTolerance.LOW, false),
                createUser("Marek1", 41, RiskTolerance.HIGH, false),
                createUser("Ola1", 28, RiskTolerance.MEDIUM, false),

                createUser("Adam3", 30, RiskTolerance.LOW, false),
                createUser("Kasia3", 33, RiskTolerance.HIGH, false),
                createUser("Tomek3", 27, RiskTolerance.MEDIUM, false),
                createUser("Ania3", 35, RiskTolerance.LOW, false),
                createUser("Marek3", 42, RiskTolerance.HIGH, false),
                createUser("Ola3", 29, RiskTolerance.MEDIUM, false),

                createUser("Adam4", 31, RiskTolerance.LOW, false),
                createUser("Kasia4", 34, RiskTolerance.HIGH, false),
                createUser("Tomek14", 28, RiskTolerance.MEDIUM, false),
                createUser("Ania14", 36, RiskTolerance.LOW, false),
                createUser("Marek14", 43, RiskTolerance.HIGH, false),
                createUser("Ola14", 30, RiskTolerance.MEDIUM, false)
        );

        // Dodajemy przykładowe adresy
        users.get(0).addAddress(
                createAddress(
                        "Długa 10",
                        "Warszawa",
                        "00-001",
                        AddressType.HOME
                )
        );

        users.get(0).addAddress(
                createAddress(
                        "Krótka 5",
                        "Kraków",
                        "30-001",
                        AddressType.WORK
                )
        );

        users.get(1).addAddress(
                createAddress(
                        "Leśna 12",
                        "Gdańsk",
                        "80-001",
                        AddressType.HOME
                )
        );

        // Dodajemy adresy pozostałym użytkownikom
        for (int i = 2; i < users.size(); i++) {
            users.get(i).addAddress(
                    createAddress(
                            "Przykładowa " + (i + 1),
                            "Warszawa",
                            "00-001",
                            AddressType.HOME
                    )
            );

            users.get(i).addAddress(
                    createAddress(
                            "PrzykładowaWork " + (i + 1),
                            "WarszawaWork",
                            "00-002",
                            AddressType.WORK
                    )
            );
        }

        userRepository.saveAll(users);
    }

    private User createUser(
            String name,
            int age,
            RiskTolerance riskTolerance,
            boolean active
    ) {
        return User.builder()
                .name(name)
                .email(name.toLowerCase() + "@example.com")
                .age(age)
                .riskTolerance(riskTolerance)
                .active(active)
                .build();
    }

    private Address createAddress(
            String street,
            String city,
            String postalCode,
            AddressType type
    ) {
        return Address.builder()
                .street(street)
                .city(city)
                .postalCode(postalCode)
                .country("Poland")
                .type(type)
                .build();
    }
}