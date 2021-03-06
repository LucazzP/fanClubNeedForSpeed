package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Attribute {
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("id")
    @Id
    @GeneratedValue(generator= "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("value_name")
    @Column(unique = true, nullable = false)
    private String valueName;
}
