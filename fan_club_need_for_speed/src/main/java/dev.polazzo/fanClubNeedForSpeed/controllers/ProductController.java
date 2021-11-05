package dev.polazzo.fanClubNeedForSpeed.controllers;

import dev.polazzo.fanClubNeedForSpeed.entities.Product;
import dev.polazzo.fanClubNeedForSpeed.repositories.AttributeRepository;
import dev.polazzo.fanClubNeedForSpeed.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository repository;
    private final AttributeRepository repositoryAttribute;

    @Autowired
    public ProductController(ProductRepository repository, AttributeRepository repositoryAttribute) {
        this.repository = repository;
        this.repositoryAttribute = repositoryAttribute;
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
        if(product.getAttributes() != null && product.getAttributes().size() > 0) {
            repositoryAttribute.saveAll(product.getAttributes());
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