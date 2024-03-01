package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
