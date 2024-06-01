package com.example.blooddonet.repository;

import com.example.blooddonet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
