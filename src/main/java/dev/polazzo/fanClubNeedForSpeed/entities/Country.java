package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Country {
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Getter(onMethod_ = {@JsonProperty("name")})
    @Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
}
