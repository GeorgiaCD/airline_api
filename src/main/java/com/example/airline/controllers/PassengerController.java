package com.example.airline.controllers;

import com.example.airline.models.Passenger;
import com.example.airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

//    GET Display details of all passengers.
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }


//    GET /{passengerId}: Display details of a specific passenger.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.getPassenger(id) , HttpStatus.OK);
    }

//    POST : Add details of a new passenger.
    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.CREATED);
    }


}
