package dev.polazzo.fanClubNeedForSpeed.services;


import java.util.List;
import java.util.Optional;

public interface CrudInterface<T, S>  {

    List<T> findAll();
    T save(T entity);
    Optional<T> findById(S id);
    void delete(T entity);
    void deleteById(S id);
    long count();


}
