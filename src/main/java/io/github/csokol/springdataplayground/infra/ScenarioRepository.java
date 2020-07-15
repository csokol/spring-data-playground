package io.github.csokol.springdataplayground.infra;

import io.github.csokol.springdataplayground.domain.Scenario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenario, Long> {
}
