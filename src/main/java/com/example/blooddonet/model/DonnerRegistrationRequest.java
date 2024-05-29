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
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(name = "phonenumber", nullable = false)
    private  String phoneNumber;
    @NotBlank(message = "BloodGroup field is required")
    @Column(name = "bloodgroup")
    private  String bloodGroup;
    @Column(name = "permanentAddress", nullable = false)
    private  String permanentAddress;


}
