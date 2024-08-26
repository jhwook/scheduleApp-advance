package com.sparta.scheduleappadvance.repository;

import com.sparta.scheduleappadvance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
