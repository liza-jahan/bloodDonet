package com.example.blooddonet.service;

import com.example.blooddonet.entity.UserEntity;

public interface UserService {
    UserEntity findUserByUsername(String userName);

}
