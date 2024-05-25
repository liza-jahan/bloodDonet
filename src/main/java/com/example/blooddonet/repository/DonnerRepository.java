package com.example.blooddonet.repository;

import com.example.blooddonet.entity.DonnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonnerRepository extends JpaRepository<DonnerEntity,Long> {
}
