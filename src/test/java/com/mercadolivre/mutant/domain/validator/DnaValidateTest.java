package com.mercadolivre.mutant.domain.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DnaValidateTest {

    private DnaValidate dnaValidator = new DnaValidate();

    @Test
    void shouldBeValidDna() {
        String[] dna = {"ATGCGA","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        assertFalse(dnaValidator.isNotValidDna(dna));

    }

    @Test
    void shouldBeInvalidDnaWhenSizeNotEqual() {
        String[] dna = {"ATGCGAAAAAAAAAA","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        assertTrue(dnaValidator.isNotValidDna(dna));

    }

    @Test
    void shouldBeInvalidDnaWhenWordNotEqual() {
        String[] dna = {"KLASMK","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        assertTrue(dnaValidator.isNotValidDna(dna));

    }

}