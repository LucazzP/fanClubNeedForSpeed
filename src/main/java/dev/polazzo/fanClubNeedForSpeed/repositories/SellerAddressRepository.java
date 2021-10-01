package dev.polazzo.fanClubNeedForSpeed.repositories;

import dev.polazzo.fanClubNeedForSpeed.entities.Product;
import dev.polazzo.fanClubNeedForSpeed.entities.SellerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerAddressRepository extends JpaRepository<SellerAddress, String> {
}
