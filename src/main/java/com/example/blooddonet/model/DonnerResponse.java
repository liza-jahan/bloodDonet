package com.example.blooddonet.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class DonnerResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nonnull
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
    private String status;

}
