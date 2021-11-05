package dev.polazzo.fanClubNeedForSpeed.repositories;

import dev.polazzo.fanClubNeedForSpeed.entities.City;
import dev.polazzo.fanClubNeedForSpeed.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
