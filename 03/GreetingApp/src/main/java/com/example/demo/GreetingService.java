package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository repository;

    public Greeting getGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            message = "Hello " + firstName;
        } else if (lastName != null) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }
        Greeting greeting = new Greeting(counter.incrementAndGet(), message);
        return repository.save(greeting);
    }

    public Greeting getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Greeting> getAll() {
        return repository.findAll();
    }

    public Greeting update(Long id, String message) {
        return repository.update(id, message);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
