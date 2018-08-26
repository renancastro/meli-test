package com.mercadolivre.mutant.service;

import com.mercadolivre.mutant.domain.detector.MutantDetector;
import com.mercadolivre.mutant.domain.model.DnaVerified;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

class HumanMutantServiceTest {

    private HumanMutantService humanMutantService;

    private MutantDetector mutantDetectorMock;

    private ApplicationEventPublisher applicationEventPublisherMock;

    @BeforeEach
    void setUp() {
        this.mutantDetectorMock = Mockito.mock(MutantDetector.class);
        this.applicationEventPublisherMock = Mockito.mock(ApplicationEventPublisher.class);
        this.humanMutantService = new HumanMutantService(mutantDetectorMock, applicationEventPublisherMock);
    }

    @Test
    void shouldPublisherEventWhenVerifyDna() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        this.humanMutantService.isMutant(dna);
        Mockito.verify(applicationEventPublisherMock).publishEvent(Mockito.any(DnaVerified.class));
    }
}