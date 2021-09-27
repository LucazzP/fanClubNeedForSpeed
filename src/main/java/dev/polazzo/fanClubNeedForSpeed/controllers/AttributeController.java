package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.Attribute;
import dev.polazzo.fanClubNeedForSpeed.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeRepository repository;

    @Autowired
    public AttributeController(AttributeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    Attribute getOne(@PathVariable("id") String id) {
        return repository.getById(id);
    }

    @GetMapping
    List<Attribute> getAll() {
        return repository.findAll();
    }

    @PostMapping
    Attribute add(@RequestBody Attribute attribute) {
        return repository.save(attribute);
    }

    @PutMapping
    Attribute update(@RequestBody Attribute attribute) {
        final Attribute attributeOnRepo = repository.getById(attribute.getId());

        attributeOnRepo.setValueName(attribute.getValueName());

        return repository.save(attributeOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
