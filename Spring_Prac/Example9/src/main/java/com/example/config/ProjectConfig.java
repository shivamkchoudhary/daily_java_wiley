package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Mahindra");
        return vehicle;
    }

    @Bean
    public Person person() {
        var person = new Person();
        person.setName("Ram");
        person.setVehicle(vehicle());
        return person;
    }
}
