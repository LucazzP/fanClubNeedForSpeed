package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class State {
    @Getter
    @Setter
    @JsonProperty("id")
    @Id
    @GeneratedValue(generator= "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Getter
    @Setter
    @JsonProperty("name")
    @Column(unique = true, nullable = false)
    private String name;
}
