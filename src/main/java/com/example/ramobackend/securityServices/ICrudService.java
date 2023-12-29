package com.example.ramobackend.securityServices;

import java.util.Optional;
import java.util.Set;
//Den er kopiet fra Jons JWTprep repository
// https://github.com/joneikholmkea/JWTprep
public interface ICrudService <T,ID>{
    Set<T> findAll();
    T save(T object);
    void delete(T object);

}
