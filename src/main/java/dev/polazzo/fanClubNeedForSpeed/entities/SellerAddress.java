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
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("city")
    @ManyToOne
    private City city;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("state")
    @ManyToOne
    private State state;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("country")
    @ManyToOne
    private Country country;

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
