package com.example.blooddonet.controller;

import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.model.DonnerUpdateRequest;
import com.example.blooddonet.repository.DonnerRepository;
import com.example.blooddonet.service.imp.DonnerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class DonnerController {



   private final DonnerServiceImp service;
   private final DonnerRepository donnerRepository;

    @GetMapping( "viewTDonnerList")
    public String viewAllDonnerList(Model model) {
        model.addAttribute("donner", service.getAllDonner());
        return "ViewPage";
    }

    @GetMapping("/donner/new")
    public String createDonnerForm(Model model) {

        // create donner object to hold donner form data
        DonnerRegistrationRequest donnerRegistrationRequest = new DonnerRegistrationRequest();
        model.addAttribute("donnerRequest", donnerRegistrationRequest);
        return "create_donnerForm";

    }

    @PostMapping("donner")
         public String donnerSave(DonnerRegistrationRequest donnerRegistrationRequest) {
        service.saveDonner(donnerRegistrationRequest);
        return "ViewToDoList";
    }


    @GetMapping("/donner/edit/{id}")
    public String editDonnerForm(@PathVariable Long id, Model model) {
       service.getDonnerDetails(id);
        return "edit_donner";
    }




    @PostMapping("/donner/{id}")
    public String editDonnerList(@PathVariable Long id, DonnerUpdateRequest donnerUpdateRequest) {
       service.update(id,donnerUpdateRequest);
        return "EditToDonnerList.jsp";
    }



    @GetMapping("/deleteDonner/{id}")
    public String deleteToDoItem(@PathVariable Long id) {
     service.deleteDonner(id);
        return "redirect:/viewToDoList.jsp";
    }

}
