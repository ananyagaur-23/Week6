package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GreetingRepository {
    private final Map<Long, Greeting> storage = new HashMap<>();

    public Greeting save(Greeting greeting) {
        storage.put(greeting.getId(), greeting);
        return greeting;
    }

    public Optional<Greeting> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Greeting> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Greeting update(Long id, String newMessage) {
        Greeting updated = new Greeting(id, newMessage);
        storage.put(id, updated);
        return updated;
    }

    public void delete(Long id) {
        storage.remove(id);
    }
}
