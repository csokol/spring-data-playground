package io.github.csokol.springdataplayground.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "bucket")
public class Scenario {

    private Long id;

    private List<ScenarioParameter> parameters;


    private Bucket bucket;

    public void addParameters(Set<ScenarioParameter> parameters) {
        this.parameters.addAll(parameters);
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JsonIgnore
    public Bucket getBucket() {
        return bucket;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    @BatchSize(size = 10)
    @OneToMany(mappedBy = "scenario", cascade = CascadeType.PERSIST)
    public List<ScenarioParameter> getParameters() {
        return parameters;
    }


    public void setParameters(List<ScenarioParameter> parameters) {
        this.parameters = parameters;
    }

}
