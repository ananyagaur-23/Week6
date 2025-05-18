package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
    }
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAll() {
        return greetingService.getAll();
    }

    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.update(id, message);
    }

    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.delete(id);
    }

}
