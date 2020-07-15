package io.github.csokol.springdataplayground.infra;

import io.github.csokol.springdataplayground.application.CreateBucketService;
import io.github.csokol.springdataplayground.domain.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buckets")
@RequiredArgsConstructor
public class BucketController {

    private final CreateBucketService createBucketService;

    @PostMapping
    public ResponseEntity<Bucket> createBucket() {
        return ResponseEntity.ok(createBucketService.createBucket());
    }

}
