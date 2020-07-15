package io.github.csokol.springdataplayground;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import io.github.csokol.springdataplayground.application.console.SpringDataPlaygroundConsoleApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.csokol.springdataplayground"},
        excludeFilters = @ComponentScan.Filter(classes = SpringDataPlaygroundConsoleApp.class, type = ASSIGNABLE_TYPE)
)
public class SpringDataPlaygroundWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataPlaygroundWebApplication.class, args);
    }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        builder.visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return builder;
    }

}
