package com.example.blooddonet.service.imp;

import com.example.blooddonet.entity.DonnerEntity;
import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.model.DonnerUpdateRequest;
import com.example.blooddonet.repository.DonnerRepository;
import com.example.blooddonet.service.DonnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public  class DonnerServiceImp implements DonnerService {

@Autowired
 private  DonnerRepository donnerRepository;

    @Override
    public DonnerEntity getDonnerDetails(Long id) {
        return donnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not"));
    }
    @Override
    public long update(Long id, DonnerUpdateRequest request) {
        DonnerEntity donnerEntity= donnerRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        donnerEntity.setBloodGroup(request.getBloodGroup());
        donnerEntity.setPhoneNumber(request.getPhoneNumber());
        donnerEntity.setUpdateAt(new Date());
        donnerEntity.setPermanentAddress(request.getPermanentAddress());
        donnerEntity.setAvailable(donnerEntity.isAvailable());
        donnerRepository.save(donnerEntity);
        return donnerEntity.getId();
    }
    @Override
    public boolean saveDonner(DonnerRegistrationRequest donnerRequest) {
        DonnerEntity donnerEntity=new DonnerEntity();
        donnerEntity.setFirstName(donnerRequest.getFirstName());
        donnerEntity.setLastName(donnerRequest.getLastName());
        donnerEntity.setBloodGroup(donnerRequest.getBloodGroup());
        donnerEntity.setPhoneNumber(donnerRequest.getPhoneNumber());
        donnerEntity.setPermanentAddress(donnerRequest.getPermanentAddress());
        donnerEntity.setAvailable(false);
        donnerEntity.setCreateAt(new Date());
        //   donnerEntity.setCreateBy();

        donnerEntity = donnerRepository.save(donnerEntity);

        if (getDonnerDetails(donnerEntity.getId()) != null) {
            return true;
        }

        return false;
    }
    @Override
    public boolean deleteDonner(Long id) {
        donnerRepository.deleteById(id);

        if (donnerRepository.findById(id).isEmpty()) {
            return true;
        }

        return false;
    }
    @Override
    public List<DonnerEntity> getAllDonners(){

        // TODO: 25/5/2024 incorporate pageable

        return donnerRepository.findAll();
    }

    @Override
    public List<DonnerEntity> getAllDonner() {
        return donnerRepository.findAll();
    }

}
