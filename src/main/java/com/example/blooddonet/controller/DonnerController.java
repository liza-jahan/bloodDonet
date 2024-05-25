package com.example.blooddonet.controller;

import com.example.blooddonet.model.DonnerRegistrationRequest;
import com.example.blooddonet.service.DonnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class DonnerController {


   @Autowired
   private DonnerService service;

    @GetMapping({"/", "viewToDoList"})
    public String viewAllToDoItems(Model model) {
        model.addAttribute("list", service.getAllDonner());


        return "ViewToDoList.jsp";
    }

    @PostMapping("/editSaveToDoItem")
    public String editSaveToDoItem(DonnerRegistrationRequest todo, Model model) {

        model.addAttribute("todo", todo);
        return "EditToDonnerList.jsp";
    }



    @GetMapping("/addToDoItem")
    public String showAddForm(Model model, DonnerRegistrationRequest response) {
        model.addAttribute("response", response);
        return "DonnerADD.jsp";
    }


    @GetMapping("/addToDoItem")
    public String addToDoItem(Model model) {
        model.addAttribute("todo", new DonnerRegistrationRequest());

        return "DonnerADD.jsp";
    }

    @PostMapping("/createDonner")
    public String createDonner(DonnerRegistrationRequest request, Model model) {
        if (service.saveDonner(request)) {
            return "redirect:/viewToDoList";
        }

        model.addAttribute("request", request);
        return "DonnerADD.jsp";
    }


    @GetMapping("/editToDoItem/{id}")
    public String editToDoItem(@PathVariable Long id, Model model) {
        model.addAttribute("todo", service.getDonnerDetails(id));

        return "EditToDonnerList.jsp";
    }


    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItem(@PathVariable Long id, Model model) {
        if (service.deleteToDoItem(id)) {
            model.addAttribute("Delete Success");
        } else {
            model.addAttribute( "Delete Failure");
        }
        return "redirect:/viewToDoList.jsp";
    }

}
