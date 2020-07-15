package io.github.csokol.springdataplayground.infra;

import io.github.csokol.springdataplayground.domain.Bucket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends CrudRepository<Bucket, Long> {
}
