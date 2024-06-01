package com.example.blooddonet.controller;

import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.model.DonnerUpdateRequest;
import com.example.blooddonet.repository.DonnerRepository;
import com.example.blooddonet.service.imp.DonnerServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class DonnerController {
@Autowired
    private  DonnerServiceImp service;


    @GetMapping( "/viewDonnerList")
    public String viewAllDonnerList(Model model) {
        model.addAttribute("donner", service.getAllDonner());
        return "ViewPage";
    }


    @GetMapping("/donner/new")
    public String createDonnerForm(Model model) {

        // create donner object to hold donner form data
        DonnerRegistrationRequest donnerRequest = new DonnerRegistrationRequest();
        model.addAttribute("donnerRequest", donnerRequest);
        return "CreateDonnerForm";

    }

    @PostMapping("/viewDonnerList")
         public String donnerSave(DonnerRegistrationRequest donnerRegistrationRequest) {
        service.saveDonner(donnerRegistrationRequest);
        return "redirect:/viewDonnerList";
    }


    @GetMapping("/donner/edit/{id}")
    public String editDonnerForm(@PathVariable Long id, Model model) {

        model.addAttribute("donnerEdit", service.getDonnerDetails(id));
        return "EditDonnerInfo";
    }


    @PutMapping("/donner/{id}")
    public String editDonnerList(@PathVariable Long id, @ModelAttribute("donnerUpdateRequest") DonnerUpdateRequest donnerUpdateRequest) {
        service.update(id, donnerUpdateRequest);
        return "redirect:/viewDonnerList";
    }




    @GetMapping("/deleteDonner/{id}")
    public String deleteToDoItem(@PathVariable Long id) {
     service.deleteDonner(id);
        return "redirect:/viewDonnerList";
    }

}
