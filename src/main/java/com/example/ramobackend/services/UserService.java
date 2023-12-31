package com.example.ramobackend.services;

import com.example.ramobackend.configuration.SecurityConfiguration;
import com.example.ramobackend.model.User;
import com.example.ramobackend.repositories.UserRepository;
import com.example.ramobackend.securityServices.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserService  implements IUserService {
    private UserRepository userRepository;

    @Override
    public Set<User> findAll() {
        Set<User> set = new HashSet<>();
        userRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public User save(User user) {
        PasswordEncoder pw = SecurityConfiguration.passwordEncoder();
        user.setUserPassword(pw.encode(user.getUserPassword()));
        return userRepository.save(user);
    }
    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }


    @Override
    public List<User> findByName(String name) {
        System.out.println("Userservice called findByName with argument: " + name);
        return userRepository.findByUsername(name);
    }
}

