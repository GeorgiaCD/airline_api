package com.example.airline.services;

import com.example.airline.models.Flight;
import com.example.airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepositories;

//    POST /flights: Add details of a new flight.
    public void saveFlight(Flight flight){
        flightRepositories.save(flight);
    }

//    GET /flights: Display all available flights.
    public List<Flight> findAllFlight(){
        return flightRepositories.findAll();
    }


//    GET /flights/{flightId}: Display details of a specific flight.
    public Flight findFlight(Long id){
        return flightRepositories.findById(id).get();
    }

//    DELETE /flights/{flightId}: Cancel a flight.
    public void deleteFlight(Long id){
        Flight deletedFlight = flightRepositories.findById(id).get();
        flightRepositories.delete(deletedFlight);
    }

}
