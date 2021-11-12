package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.Country;
import dev.polazzo.fanClubNeedForSpeed.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    Country getOne(@PathVariable("id") String id) {
        return repository.getOne(id);
    }

    @GetMapping
    List<Country> getAll() {
        return repository.findAll();
    }

    @PostMapping
    Country add(@RequestBody Country country) {
        return repository.save(country);
    }

    @PutMapping
    Country update(@RequestBody Country country) {
        final Country countryOnRepo = repository.getOne(country.getId());

        countryOnRepo.setName(country.getName());

        return repository.save(countryOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
