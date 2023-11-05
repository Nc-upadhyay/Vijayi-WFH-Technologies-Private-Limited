package com.nc.postgresql_crud.repositry;


import com.nc.postgresql_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCommentTo(String commentTo);
}

