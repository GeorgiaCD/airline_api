package com.example.airline.controllers;

import com.example.airline.models.Flight;
import com.example.airline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

//    GET  Display all available flights.
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlight(), HttpStatus.OK);
    }

//    GET Display details of a specific flight.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id){
        return new ResponseEntity<>(flightService.findFlight(id), HttpStatus.OK);
    }


    //POST  Add details of a new flight.
    @PostMapping
    public ResponseEntity<List<Flight>> addFlight(Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flightService.findAllFlight(), HttpStatus.CREATED);
    }


    //DELETE  Cancel a flight.
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Flight>> removeFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(flightService.findAllFlight(), HttpStatus.OK);

    }

}
