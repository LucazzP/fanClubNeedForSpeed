package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.City;
import dev.polazzo.fanClubNeedForSpeed.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    private final CityRepository repository;

    @Autowired
    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    City getOne(@PathVariable("id") String id) {
        return repository.getOne(id);
    }

    @GetMapping
    List<City> getAll() {
        return repository.findAll();
    }

    @PostMapping
    City add(@RequestBody City city) {
        return repository.save(city);
    }

    @PutMapping
    City update(@RequestBody City city) {
        final City cityOnRepo = repository.getOne(city.getId());

        cityOnRepo.setName(city.getName());

        return repository.save(cityOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
