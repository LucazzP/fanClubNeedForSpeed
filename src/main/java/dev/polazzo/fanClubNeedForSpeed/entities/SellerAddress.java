package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SellerAddress {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("city")})
    @lombok.Setter(onMethod_ = {@JsonProperty("city")})
    private City city;
    @lombok.Getter(onMethod_ = {@JsonProperty("state")})
    @lombok.Setter(onMethod_ = {@JsonProperty("state")})
    private City state;
    @lombok.Getter(onMethod_ = {@JsonProperty("country")})
    @lombok.Setter(onMethod_ = {@JsonProperty("country")})
    private City country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerAddress that = (SellerAddress) o;
        return Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(country, that.country) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state, country, id);
    }
}
