package com.example.ramobackend.repositories;

import com.example.ramobackend.model.Subimages;
import org.springframework.data.repository.CrudRepository;

public interface SubimageRepository extends CrudRepository<Subimages, Long> {
    Subimages findSubimagesByProductItemSubimageNumber(Integer productItemSubimageNumber);
}
