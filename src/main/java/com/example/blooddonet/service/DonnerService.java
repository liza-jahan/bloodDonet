package com.example.blooddonet.service;

import com.example.blooddonet.model.DonnerResponse;
import com.example.blooddonet.repository.DonnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonnerService {

    @Autowired
    DonnerRepository repo;

    public List<DonnerResponse> getAllToDoItems() {
        ArrayList<DonnerResponse> list = new ArrayList<>();
        repo.findAll().forEach(todo -> list.add(todo));

        return list;
    }

    public DonnerResponse getToDoItemById(Long id) {
        return repo.findById(id).get();
    }

    public boolean updateStatus(Long id) {
        DonnerResponse donnerResponse = getToDoItemById(id);
        donnerResponse.setStatus("Completed");

        return saveOrUpdateToDoItem(donnerResponse);
    }

    public boolean saveOrUpdateToDoItem(DonnerResponse donnerResponse) {
        DonnerResponse updatedObj = repo.save(donnerResponse);

        if (getToDoItemById(updatedObj.getId()) != null) {
            return true;
        }

        return false;
    }

    public boolean deleteToDoItem(Long id) {
        repo.deleteById(id);

        if (repo.findById(id).isEmpty()) {
            return true;
        }

        return false;
    }
}
