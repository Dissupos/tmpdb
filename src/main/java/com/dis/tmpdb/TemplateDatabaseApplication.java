package com.dis.tmpdb;

import com.dis.tmpdb.model.Template;
import com.dis.tmpdb.repository.TemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class TemplateDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateDatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(TemplateRepository repository) {
        return args -> {

            log.info("Add templates for test");
            repository.save(new Template("SQL script", "select ... from .... where ..."));
            repository.save(new Template("SQL script#2", "select ... from .... where ..."));
            repository.save(new Template("SQL script#3", "select ... from .... where ..."));
            repository.save(new Template("SQL script#4", "select ... from .... where ..."));
            log.info("");
            log.info("All templates with find by all");
            for (Template t : repository.findAll()) {
                log.info(t.toString());
            }
        };
    }
}
