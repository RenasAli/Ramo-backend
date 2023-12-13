package com.example.ramobackend.services;

import com.example.ramobackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService extends ICrudService<User,Long>{
    List<User> findByName(String name);
}
