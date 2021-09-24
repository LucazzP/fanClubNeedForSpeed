package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.*;
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
public class Attribute {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @lombok.Getter(onMethod_ = {@JsonProperty("value_name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("value_name")})
    private String valueName;
}
