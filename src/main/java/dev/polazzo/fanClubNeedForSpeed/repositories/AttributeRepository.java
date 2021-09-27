package dev.polazzo.fanClubNeedForSpeed.repositories;

import dev.polazzo.fanClubNeedForSpeed.entities.Attribute;
import dev.polazzo.fanClubNeedForSpeed.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, String> {
}
