package com.example.ramobackend.securityServices;

import com.example.ramobackend.model.User;
import com.example.ramobackend.securityServices.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
//Den er kopiet fra Jons JWTprep repository
// https://github.com/joneikholmkea/JWTprep
@Service
public interface IUserService extends ICrudService<User,Long> {
    List<User> findByName(String name);
}
