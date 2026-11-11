package org.maciek.context;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser(User user) {

        if (user.getPosts() != null) {
            for (Post post : user.getPosts()) {
                post.setUser(user);
            }
        }

        return userRepository.save(user);
    }

    @Transactional
    public boolean deleteUserByNick(String nick) {

        userRepository.deletePostsByNick(nick);

        int deletedUsers = userRepository.deleteUserByNick(nick);

        return deletedUsers > 0;
    }
}
