package io.github.csokol.springdataplayground.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Bucket {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "bucket", cascade = CascadeType.PERSIST)
    private Set<Scenario> scenarios;

    public void addScenario(Scenario scenario) {
        scenarios.add(scenario);
    }
}
