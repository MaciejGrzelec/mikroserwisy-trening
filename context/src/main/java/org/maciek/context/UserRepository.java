package org.maciek.context;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        DELETE FROM Post p
        WHERE p.user.nick_user = :nick
    """)
    int deletePostsByNick(@Param("nick") String nick);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        DELETE FROM User u
        WHERE u.nick_user = :nick
    """)
    int deleteUserByNick(@Param("nick") String nick);
}
