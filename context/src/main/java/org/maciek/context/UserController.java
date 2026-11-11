package org.maciek.context;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userService.createUser(user);

        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/by-nick/{nick}")
    public ResponseEntity<Void> deleteUserByNick(@PathVariable String nick) {

        boolean deleted = userService.deleteUserByNick(nick);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
