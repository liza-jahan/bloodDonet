package com.example.blooddonet.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="")
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nonnull
    private Long id;
    private String firstName;
    private String lastName;
    private  String phoneNumber;
    private  String bloodGroup;
    private  String permanentAddress;

}
