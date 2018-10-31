package com.mercadolivre.mutant.domain.detector;

import com.mercadolivre.mutant.domain.validator.DnaValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanMutantDetectorTest {

    private HumanMutantDetector humanMutantDetector;

    @BeforeEach
    void setUp() {
        humanMutantDetector = new HumanMutantDetector(new DnaValidate(), new HumanDnaSequenceSummarizer());
    }

    @Test
    void shouldBeMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutant = humanMutantDetector.isMutant(dna);
        assertTrue(isMutant);
    }

    @Test
    void shouldBeTraitor() {
        String[] dna = {"WELIFF"};
        boolean isTraitor = humanMutantDetector.isMutant(dna);
        assertTrue(isTraitor);
    }

    @Test
    void shouldNotBeMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATCT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutant = humanMutantDetector.isMutant(dna);
        assertFalse(isMutant);
    }

    @Test
    void shouldBeInvalidDnaWhenSizeNotEqual() {
        String[] dna = {"ATGCGAAAAAAAAAA","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        assertThrows(IllegalArgumentException.class, () -> humanMutantDetector.isMutant(dna));

    }
    @Test
    void shouldBeInvalidDnaWhenWordNotEqual() {
        String[] dna = {"KLASMK","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        assertThrows(IllegalArgumentException.class, () -> humanMutantDetector.isMutant(dna));

    }

}
