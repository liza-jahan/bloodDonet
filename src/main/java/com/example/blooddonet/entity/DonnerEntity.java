package com.example.blooddonet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donners")
public class DonnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String bloodGroup;
    private String permanentAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by")
    private UserEntity createBy;
    private Long updateBy;
    private Date createAt;
    private Date updateAt;
    private boolean isAvailable;
    private Date lastDonnetAt;


}

