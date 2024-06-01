package com.example.blooddonet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="donners")
public class DonnerRegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "phoneNumber", nullable = false)
    private  String phoneNumber;
    @NotBlank(message = "BloodGroup field is required")
    @Column(name = "bloodGroup")
    private  String bloodGroup;
    @Column(name = "permanentAddress", nullable = false)
    private  String permanentAddress;
    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "lastDonnetAt", nullable = false)
    private Date lastDonnetAt;

}
