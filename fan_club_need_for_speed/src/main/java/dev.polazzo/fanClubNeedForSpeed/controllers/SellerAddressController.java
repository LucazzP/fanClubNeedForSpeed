package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.SellerAddress;
import dev.polazzo.fanClubNeedForSpeed.repositories.SellerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellerAddress")
public class SellerAddressController {
    private final SellerAddressRepository repository;

    @Autowired
    public SellerAddressController(SellerAddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    SellerAddress getOne(@PathVariable("id") Long id) {
        return repository.getOne(id);
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
        final SellerAddress sellerAddressOnRepo = repository.getOne(sellerAddress.getId());
        
        sellerAddressOnRepo.setCity(sellerAddress.getCity());
        sellerAddressOnRepo.setState(sellerAddress.getState());
        sellerAddressOnRepo.setCountry(sellerAddress.getCountry());

        return repository.save(sellerAddressOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
