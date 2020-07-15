package io.github.csokol.springdataplayground.application.console;

import io.github.csokol.springdataplayground.application.CreateBucketService;
import io.github.csokol.springdataplayground.domain.Bucket;
import io.github.csokol.springdataplayground.infra.BucketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@RequiredArgsConstructor
public class ConsoleScript {
    private final BucketRepository bucketRepository;
    private final CreateBucketService createBucketService;
    private final TransactionTemplate transactionTemplate;

    public void run() {

        var created = transactionTemplate.execute((s) -> createBucketService.createBucket());
        System.out.println("\n#######################\n\n");

        transactionTemplate.execute((status) -> {

            var bucket = bucketRepository.findById(created.getId()).get();

            bucket.getScenarios()
                    .stream()
                    .flatMap(s -> s.getParameters().stream())
                    .forEach(System.out::println);

            return null;
        });
    }
}
