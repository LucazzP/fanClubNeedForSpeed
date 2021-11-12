package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.Attribute;
import dev.polazzo.fanClubNeedForSpeed.repositories.AttributeRepository;
import dev.polazzo.fanClubNeedForSpeed.services.AttributeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attribute")
public class AttributeController {
    private final AttributeService service;

    @Autowired
    public AttributeController(AttributeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    Attribute getOne(@PathVariable("id") String id) {
        return service.findById(id).get();
    }

    @GetMapping
    List<Attribute> getAll() {
        return service.findAll();
    }

    @PostMapping
    Attribute add(@RequestBody Attribute attribute) {
        return service.save(attribute);
    }

    @PutMapping
    Attribute update(@RequestBody Attribute attribute) {
        final Attribute attributeOnRepo = service.findById(attribute.getId()).get();

        attributeOnRepo.setValueName(attribute.getValueName());

        return service.save(attributeOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
