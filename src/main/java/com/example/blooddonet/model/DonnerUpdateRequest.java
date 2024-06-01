package com.example.blooddonet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DonnerUpdateRequest {
    private long id;
    private String phoneNumber;
    private String bloodGroup;
    private String permanentAddress;
    private Date lastDonnetAt;
    private boolean isAvailable;
}
