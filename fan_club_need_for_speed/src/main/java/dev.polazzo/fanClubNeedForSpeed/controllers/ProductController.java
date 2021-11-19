package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.*;
import dev.polazzo.fanClubNeedForSpeed.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductRepository repository;
    private final AttributeRepository repositoryAttribute;
    private final SellerAddressRepository repositorySellerAddress;
    private final CityRepository repositoryCity;
    private final StateRepository repositoryState;
    private final CountryRepository repositoryCountry;

    @Autowired
    public ProductController(ProductRepository repository, AttributeRepository repositoryAttribute, SellerAddressRepository sellerAddressRepository, CityRepository repositoryCity, CountryRepository repositoryCountry, StateRepository repositoryState) {
        this.repository = repository;
        this.repositoryAttribute = repositoryAttribute;
        this.repositorySellerAddress = sellerAddressRepository;
        this.repositoryCity = repositoryCity;
        this.repositoryCountry = repositoryCountry;
        this.repositoryState = repositoryState;
    }

    @GetMapping("/{id}")
    Product getOne(@PathVariable("id") String id) {
        return repository.getOne(id);
    }

    @GetMapping
    List<Product> getAll() {
        return repository.findAll();
    }

    @PostMapping
    Product add(@RequestBody Product product) {
        List<Attribute> attributes = product.getAttributes();
        City city = product.getSellerAddress().getCity();
        State state = product.getSellerAddress().getState();
        Country country = product.getSellerAddress().getCountry();

        // Attribute
        if (product.getAttributes() != null && attributes.size() > 0) {
            for (int i = 0; i < attributes.size(); i++) {
                Optional<Attribute> optional = repositoryAttribute.findOne(Example.of(attributes.get(i), ExampleMatcher.matchingAny()));
                if (optional.isPresent()) {
                    attributes.set(i, optional.get());
                } else {
                    attributes.set(i, repositoryAttribute.save(attributes.get(i)));
                }
            }
            product.setAttributes(attributes);
        }

        // SellerAddress
        if (product.getSellerAddress() != null) {
            // City
            if (city != null) {
                Optional<City> optional = repositoryCity.findOne(Example.of(city, ExampleMatcher.matchingAny()));
                if (optional.isPresent()) {
                    city = optional.get();
                } else {
                    city = repositoryCity.save(city);
                }
                product.getSellerAddress().setCity(city);
            }

            // State
            if (state != null) {
                Optional<State> optional = repositoryState.findOne(Example.of(state, ExampleMatcher.matchingAny()));
                if (optional.isPresent()) {
                    state = optional.get();
                } else {
                    state = repositoryState.save(state);
                }
                product.getSellerAddress().setState(state);
            }

            // Country
            if (country != null) {
                Optional<Country> optional = repositoryCountry.findOne(Example.of(country, ExampleMatcher.matchingAny()));
                if (optional.isPresent()) {
                    country = optional.get();
                } else {
                    country = repositoryCountry.save(country);
                }
                product.getSellerAddress().setCountry(country);
            }

            SellerAddress sellerAddress = repositorySellerAddress.save(product.getSellerAddress());
            product.setSellerAddress(sellerAddress);
        }

        return repository.save(product);
    }

    @PutMapping
    Product update(@RequestBody Product product) {
        final Product productOnRepo = repository.getOne(product.getId());

        productOnRepo.setTitle(product.getTitle());
        productOnRepo.setIdIntegracao(product.getIdIntegracao());
        productOnRepo.setSubtitle(product.getSubtitle());
        productOnRepo.setSellerId(product.getSellerId());
        productOnRepo.setPrice(product.getPrice());
        productOnRepo.setBasePrice(product.getBasePrice());
        productOnRepo.setOriginalPrice(product.getOriginalPrice());
        productOnRepo.setCurrencyId(product.getCurrencyId());
        productOnRepo.setInitialQuantity(product.getInitialQuantity());
        productOnRepo.setAvailableQuantity(product.getAvailableQuantity());
        productOnRepo.setStartTime(product.getStartTime());
        productOnRepo.setStopTime(product.getStopTime());
        productOnRepo.setConditional(product.getConditional());
        productOnRepo.setPermalink(product.getPermalink());
        productOnRepo.setSellerAddress(product.getSellerAddress());
        productOnRepo.setSellerContact(product.getSellerContact());
        productOnRepo.setAttributes(product.getAttributes());

        return repository.save(productOnRepo);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
