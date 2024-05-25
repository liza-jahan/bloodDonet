package com.example.blooddonet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class DonnerRegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "First name field is required")
    private String firstName;
    @NotBlank(message = "Last name field is required")
    private String lastName;
    @NotBlank(message = "Phone number field is required")
    private  String phoneNumber;
    @NotBlank(message = "BloodGroup field is required")
    private  String bloodGroup;
    private  String permanentAddress;


}
