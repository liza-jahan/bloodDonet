package com.example.blooddonet.service;

import com.example.blooddonet.entity.DonnerEntity;
import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.model.DonnerUpdateRequest;

import java.util.List;

public interface DonnerService {
    DonnerEntity getDonnerDetails(Long id);
    long update(Long id, DonnerUpdateRequest request);
    boolean saveDonner(DonnerRegistrationRequest donnerRequest);
    boolean deleteDonner(Long id);
    List<DonnerEntity> getAllDonner();
}
