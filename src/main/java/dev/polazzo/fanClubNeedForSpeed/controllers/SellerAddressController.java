package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.SellerAddress;
import dev.polazzo.fanClubNeedForSpeed.repositories.SellerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellerAddress")
public class SellerAddressController {
    private final SellerAddressRepository repository;

    @Autowired
    public SellerAddressController(SellerAddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    SellerAddress getOne(@PathVariable("id") String id) {
        return repository.getById(id);
    }

    @GetMapping
    List<SellerAddress> getAll() {
        return repository.findAll();
    }

    @PostMapping
    SellerAddress add(@RequestBody SellerAddress sellerAddress) {
        return repository.save(sellerAddress);
    }

    @PutMapping
    SellerAddress update(@RequestBody SellerAddress sellerAddress) {
        final SellerAddress sellerAddressOnRepo = repository.getById(sellerAddress.getId());
        
        sellerAddressOnRepo.setName(sellerAddress.getName());

        return repository.save(sellerAddressOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
