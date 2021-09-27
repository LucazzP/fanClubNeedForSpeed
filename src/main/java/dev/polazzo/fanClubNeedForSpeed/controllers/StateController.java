package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.State;
import dev.polazzo.fanClubNeedForSpeed.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
    private final StateRepository repository;

    @Autowired
    public StateController(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    State getOne(@PathVariable("id") String id) {
        return repository.getById(id);
    }

    @GetMapping
    List<State> getAll() {
        return repository.findAll();
    }

    @PostMapping
    State add(@RequestBody State state) {
        return repository.save(state);
    }

    @PutMapping
    State update(@RequestBody State state) {
        final State stateOnRepo = repository.getById(state.getId());

        stateOnRepo.setName(state.getName());

        return repository.save(stateOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
