package com.example.blooddonet.service.imp;

import com.example.blooddonet.entity.UserEntity;
import com.example.blooddonet.repository.UsersRepository;
import com.example.blooddonet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserEntity findUserByUsername(String userName) {

        return usersRepository.findByUsername(userName);
    }
}
