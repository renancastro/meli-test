package com.mercadolivre.mutant.listener;

import com.mercadolivre.mutant.domain.model.DnaVerified;
import com.mercadolivre.mutant.repository.DnaVerifiedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DnaVerifiedListenerTest {

    private DnaVerifiedListener dnaVerifiedListener;

    private DnaVerifiedRepository dnaVerifiedRepositoryMock;

    @BeforeEach
    void setUp() {
        this.dnaVerifiedRepositoryMock = Mockito.mock(DnaVerifiedRepository.class);
        this.dnaVerifiedListener = new DnaVerifiedListener(dnaVerifiedRepositoryMock);
    }

    @Test
    void shouldSaveNewDnaVerified() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaVerified dnaVerified = new DnaVerified(dna, true);
        dnaVerifiedListener.onDnaVerified(dnaVerified);
        Mockito.verify(dnaVerifiedRepositoryMock).save(dnaVerified);
    }
}