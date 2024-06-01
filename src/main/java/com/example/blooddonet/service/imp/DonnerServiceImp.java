package com.example.blooddonet.service.imp;

import com.example.blooddonet.entity.DonnerEntity;
import com.example.blooddonet.entity.UserEntity;
import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.model.DonnerUpdateRequest;
import com.example.blooddonet.repository.DonnerRepository;
import com.example.blooddonet.service.AuthntictionService;
import com.example.blooddonet.service.DonnerService;
import com.example.blooddonet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public  class DonnerServiceImp implements DonnerService {

@Autowired
 private  DonnerRepository donnerRepository;
@Autowired
private AuthntictionService authntictionService;
@Autowired
private UserService userService;
    @Override
    public DonnerEntity getDonnerDetails(Long id) {
        return donnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not"));
    }
    @Override
    public long update(Long id, DonnerUpdateRequest request) {
        DonnerEntity donnerEntity= donnerRepository.findById(id).orElseThrow(() -> new RuntimeException("UserEntity not found"));
        donnerEntity.setBloodGroup(request.getBloodGroup());
        donnerEntity.setPhoneNumber(request.getPhoneNumber());
        donnerEntity.setUpdateAt(new Date());
        donnerEntity.setPermanentAddress(request.getPermanentAddress());
        donnerEntity.setAvailable(donnerEntity.isAvailable());
        //donnerEntity.setId(request.getId());
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
        donnerEntity.setLastDonnetAt(donnerRequest.getLastDonnetAt());
        donnerEntity.setAvailable(donnerRequest.isAvailable());
        donnerEntity.setCreateAt(new Date());
        UserEntity userEntity=userService.findUserByUsername(authntictionService.getCurrentUser().getUsername());
        donnerEntity.setCreateBy(userEntity);

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
