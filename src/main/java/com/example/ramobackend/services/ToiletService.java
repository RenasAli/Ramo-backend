package com.example.ramobackend.services;

import com.example.ramobackend.model.Toilet;
import com.example.ramobackend.repositories.ToiletRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToiletService {
    ToiletRepository toiletRepository;

    public ToiletService(ToiletRepository toiletRepository) {
        this.toiletRepository = toiletRepository;
    }

    public List<Toilet> getAlleToilets(){
        return (List<Toilet>) toiletRepository.findAll();
    }

    public Toilet createToilet(Toilet toilet){
        return toiletRepository.save(toilet);
    }

    public Toilet editToilet(Long toiletId, Toilet toilet){
        Toilet editedToilet = toiletRepository.findById(toiletId).get();

        editedToilet.setToiletName(toilet.getToiletName());
        editedToilet.setToiletBrand(toilet.getToiletBrand());
        editedToilet.setToiletDescription(toilet.getToiletDescription());
        editedToilet.setToiletPrice(toilet.getToiletPrice());
        editedToilet.setToiletColor(toilet.getToiletColor());
        editedToilet.setToiletColor(toilet.getToiletType());

        return toiletRepository.save(editedToilet);
    }

    public void deleteToiletById(Long toiletId){
        toiletRepository.deleteById(toiletId);
    }
}
