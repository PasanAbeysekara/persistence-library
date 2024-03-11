package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
   // @Query("SELECT MAX(u.user_id) FROM users u")
   // Optional<Long> findMaxUserId();
}
