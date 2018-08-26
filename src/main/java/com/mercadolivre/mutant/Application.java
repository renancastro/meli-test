package com.mercadolivre.mutant;

import com.mercadolivre.mutant.domain.detector.HumanMutantDetector;
import com.mercadolivre.mutant.domain.detector.MutantDetector;
import com.mercadolivre.mutant.domain.validator.DnaValidate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MutantDetector mutantDetector() {
        return new HumanMutantDetector(new DnaValidate());
    }

}
