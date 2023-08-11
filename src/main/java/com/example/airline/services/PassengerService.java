package com.example.airline.services;

import com.example.airline.models.Passenger;
import com.example.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepositories;

//    POST /passengers: Add details of a new passenger.
        public void savePassenger(Passenger passenger){
            passengerRepositories.save(passenger);
        }

//    GET /passengers: Display details of all passengers.
    public List<Passenger> getAllPassengers(){
            return passengerRepositories.findAll();
    }

//    GET /passengers/{passengerId}: Display details of a specific passenger.
    public Passenger getPassenger(Long id){
            Passenger passenger = passengerRepositories.findById(id).get();
            return passenger;
    }
}
