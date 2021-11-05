package dev.polazzo.fanClubNeedForSpeed.repositories;

import dev.polazzo.fanClubNeedForSpeed.entities.City;
import dev.polazzo.fanClubNeedForSpeed.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, String> {
}
