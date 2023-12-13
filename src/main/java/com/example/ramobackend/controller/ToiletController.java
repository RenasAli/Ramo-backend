package com.example.ramobackend.controller;

import com.example.ramobackend.model.Toilet;
import com.example.ramobackend.services.ToiletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/toilet")
public class ToiletController {
    ToiletService toiletService;

    public ToiletController(ToiletService toiletService) {
        this.toiletService = toiletService;
    }

    @GetMapping()
    public ResponseEntity<List<Toilet>> getAlleToilets(){
        return  new ResponseEntity<>(toiletService.getAlleToilets(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Toilet> createToilet(@RequestBody Toilet toilet){
        return  new ResponseEntity<>(toiletService.createToilet(toilet), HttpStatus.OK);
    }

    @PatchMapping("/{toiletId}")
    public ResponseEntity<Toilet> editToiletById(@PathVariable("toiletId") Long toiletId,
                                                 @RequestBody Toilet toilet){
        return new ResponseEntity<>(toiletService.editToilet(toiletId, toilet), HttpStatus.OK);
    }

    @DeleteMapping("/{toiletId}")
    public void deleteToiletById(@PathVariable("toiletId") Long toiletId){
        toiletService.deleteToiletById(toiletId);
    }
}
