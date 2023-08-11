package com.example.airline.components;

import com.example.airline.models.Flight;
import com.example.airline.models.Passenger;
import com.example.airline.repositories.FlightRepository;
import com.example.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Passenger passenger = new Passenger("Josy",123);
        Passenger passenger1 = new Passenger("John",121);
        Passenger passenger2 = new Passenger("Jam",124);
        Passenger passenger3 = new Passenger("Jenny",125);
        Passenger passenger4 = new Passenger("Jay",321);

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);
        passengerRepository.save(passenger4);


        Flight flight1 = new Flight("Gatwick",25,"09/10/23","13:00");
        Flight flight2 = new Flight("Lisbon",30,"21/08/23","08:00");
        Flight flight3 = new Flight("Paris",100,"10/11/23","09:30");
        Flight flight4 = new Flight("New York",105,"25/12/23","19:30");
        Flight flight5 = new Flight("Copenhagen",50,"20/10/23","15:00");
        Flight flight6 = new Flight("Amsterdam",80,"30/11/23","03:00");

        flight1.addPassenger(passenger1);
        flightRepository.save(flight1);

        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flightRepository.save(flight2);


        flight3.addPassenger(passenger4);
        flightRepository.save(flight3);

        flight4.addPassenger(passenger4);
        flightRepository.save(flight4);


        flight5.addPassenger(passenger3);
        flightRepository.save(flight5);


        flight6.addPassenger(passenger3);
        flight6.addPassenger(passenger2);
        flight6.addPassenger(passenger1);
        flight6.addPassenger(passenger4);
        flightRepository.save(flight6);


    }


}
