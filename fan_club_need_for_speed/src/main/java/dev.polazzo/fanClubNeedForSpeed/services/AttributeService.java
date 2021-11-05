package dev.polazzo.fanClubNeedForSpeed.services;

import dev.polazzo.fanClubNeedForSpeed.entities.Attribute;
import dev.polazzo.fanClubNeedForSpeed.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeService implements CrudInterface<Attribute, String> {
    private final AttributeRepository repository;

    public AttributeService(AttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Attribute> findAll() {
        return repository.findAll();
    }

    @Override
    public Attribute save(Attribute entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Attribute> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Attribute entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
