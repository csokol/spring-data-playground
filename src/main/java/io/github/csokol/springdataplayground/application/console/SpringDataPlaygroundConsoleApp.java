package io.github.csokol.springdataplayground.application.console;

import io.github.csokol.springdataplayground.SpringDataPlaygroundWebApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@SpringBootApplication
@ComponentScan(
        basePackages = {"io.github.csokol.springdataplayground"}
)
public class SpringDataPlaygroundConsoleApp implements CommandLineRunner {

    @Autowired
    private ConsoleScript consoleScript;

    public static void main(String[] args) {
        var app = new SpringApplicationBuilder(SpringDataPlaygroundConsoleApp.class);
        app.web(WebApplicationType.NONE);
        var context = app.run(args);
        context.close();
    }

    @Override
    public void run(String... args) throws Exception {
        consoleScript.run();
    }
}
