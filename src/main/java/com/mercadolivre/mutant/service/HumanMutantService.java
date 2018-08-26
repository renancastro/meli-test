package com.mercadolivre.mutant.service;

import com.mercadolivre.mutant.domain.detector.MutantDetector;
import com.mercadolivre.mutant.domain.model.DnaVerified;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class HumanMutantService {

    private MutantDetector mutantDetector;

    private ApplicationEventPublisher applicationEventPublisher;

    public HumanMutantService(MutantDetector mutantDetector, ApplicationEventPublisher applicationEventPublisher) {
        this.mutantDetector = Objects.requireNonNull(mutantDetector);
        this.applicationEventPublisher = Objects.requireNonNull(applicationEventPublisher);
    }

    public boolean isMutant(String[] dna) {
        boolean isMutant = mutantDetector.isMutant(dna);
        DnaVerified dnaVerified = new DnaVerified(dna, isMutant);
        applicationEventPublisher.publishEvent(dnaVerified);

        return isMutant;
    }
}
