package com.example.blooddonet.service;

import com.example.blooddonet.entity.DonnerEntity;
import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.model.DonnerUpdateRequest;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface DonnerService {
    DonnerEntity getDonnerDetails(Long id);
    long update(Long id, DonnerUpdateRequest request);
    boolean saveDonner(DonnerRegistrationRequest donnerRequest);
    boolean deleteDonner(Long id);
    List<DonnerEntity> getAllDonner();
    List<DonnerEntity> getAllDonners();

}
