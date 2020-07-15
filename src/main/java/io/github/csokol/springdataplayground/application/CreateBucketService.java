package io.github.csokol.springdataplayground.application;

import io.github.csokol.springdataplayground.domain.Bucket;
import io.github.csokol.springdataplayground.domain.Scenario;
import io.github.csokol.springdataplayground.domain.ScenarioParameter;
import io.github.csokol.springdataplayground.infra.BucketRepository;
import io.github.csokol.springdataplayground.infra.ScenarioParameterRepository;
import io.github.csokol.springdataplayground.infra.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CreateBucketService {
    private final BucketRepository bucketRepository;
    private final ScenarioParameterRepository scenarioParameterRepository;
    private final ScenarioRepository scenarioRepository;

    public Bucket createBucket() {
        var bucket = Bucket.builder()
                .scenarios(new HashSet<>())
                .build();
        bucketRepository.save(bucket);

        addScenario(bucket);
        addScenario(bucket);
        addScenario(bucket);
        addScenario(bucket);

        return bucket;
    }

    private void addScenario(Bucket bucket) {
        var scenario = Scenario.builder()
                .bucket(bucket)
                .parameters(new ArrayList<>())
                .build();
        bucket.addScenario(scenario);
        scenarioRepository.save(scenario);

        var parameters = List.of(
                parameter("param1", "value1", scenario),
                parameter("param1", "value1", scenario),
                parameter("param1", "value1", scenario),
                parameter("param1", "value1", scenario)
        );

        scenarioParameterRepository.saveAll(parameters);
        scenario.addParameters(new HashSet<>(parameters));
    }

    private ScenarioParameter parameter(String param1, String value1, Scenario scenario) {
        return ScenarioParameter.builder()
                .name(param1)
                .scenario(scenario)
                .value(value1)
                .build();
    }
}
