package io.github.csokol.springdataplayground.infra;

import io.github.csokol.springdataplayground.domain.ScenarioParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioParameterRepository extends CrudRepository<ScenarioParameter, Long> {
}
