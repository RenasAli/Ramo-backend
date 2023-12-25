package com.example.ramobackend.repositories;

import com.example.ramobackend.model.SubImages;
import org.springframework.data.repository.CrudRepository;

public interface SubImageRepository extends CrudRepository<SubImages, Long> {
    SubImages findSubImagesByProductItemSubImageNumber(Integer productItemSubImageNumber);
}
