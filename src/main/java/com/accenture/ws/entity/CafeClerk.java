package com.accenture.ws.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CafeClerk {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String name;

    public CafeClerk() {
    }

    // Constructor
    public CafeClerk(String name) {
        this.name = "Jane Doe";
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

}