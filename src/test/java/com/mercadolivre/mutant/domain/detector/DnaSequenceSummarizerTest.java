package com.mercadolivre.mutant.domain.detector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DnaSequenceSummarizerTest {

    @Test
    void shouldHaveZeroSequenceHorizontal() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityHorizontal = dnaSequenceSummarizer.getQuantityHorizontal();

        assertEquals(0, quantityHorizontal);
    }


    @Test
    void shouldHaveOneSequenceHorizontal() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityHorizontal = dnaSequenceSummarizer.getQuantityHorizontal();

        assertEquals(1, quantityHorizontal);
    }

    @Test
    void shouldHaveTwoSequencesHorizontal() {
        String[] dna = {"AAAAGG", "ATGCGA","CAGTGC","TTATGT","ATAAGG","CCTCTA","TACCCC"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityHorizontal = dnaSequenceSummarizer.getQuantityHorizontal();

        assertEquals(2, quantityHorizontal);
    }

    @Test
    void shouldHaveThreeSequencesHorizontal() {
        String[] dna = {"AAAAGG", "ATGCGA","CAGTGC","TTATGT","ACAAGG","TCCCCA","TACCCC"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityHorizontal = dnaSequenceSummarizer.getQuantityHorizontal();

        assertEquals(3, quantityHorizontal);
    }

    @Test
    void shouldHaveZeroSequenceVertical() {
        String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGAAGG","CCCCCA","TCACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityVertical = dnaSequenceSummarizer.getQuantityVertical();

        assertEquals(0, quantityVertical);
    }

    @Test
    void shouldHaveOneSequenceVertical() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityVertical = dnaSequenceSummarizer.getQuantityVertical();

        assertEquals(1, quantityVertical);
    }

    @Test
    void shouldHaveTwoSequenceVertical() {
        String[] dna = {"ATGCGA","AAGTGC","ATATGT","AGAAGG","CCCCCA","TCACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityVertical = dnaSequenceSummarizer.getQuantityVertical();

        assertEquals(2, quantityVertical);
    }

    @Test
    void shouldHaveThreeSequenceVertical() {
        String[] dna = {"AAGCGA","ATGTGC","ATATGT","ATAAGG","CTCCCA","TTACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityVertical = dnaSequenceSummarizer.getQuantityVertical();

        assertEquals(3, quantityVertical);
    }

    @Test
    void shouldHaveZeroSequenceOblique() {
        String[] dna = {"ATGCGA","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityOblique = dnaSequenceSummarizer.getQuantityOblique();

        assertEquals(0, quantityOblique);
    }

    @Test
    void shouldHaveOneSequenceOblique() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityOblique = dnaSequenceSummarizer.getQuantityOblique();

        assertEquals(1, quantityOblique);
    }

    @Test
    void shouldHaveTwoSequenceOblique() {
        String[] dna = {"ATGCGA","CAGTGC","TTAAGT","AGAAAG","CACCAA","ACACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityOblique = dnaSequenceSummarizer.getQuantityOblique();

        assertEquals(2, quantityOblique);
    }

    @Test
    void shouldZeroSequenceOblique() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAGGG","CCCCCA","TCACCG"};
        DnaSequenceSummarizer dnaSequenceSummarizer = new DnaSequenceSummarizer(dna);

        int quantityOblique = dnaSequenceSummarizer.getQuantityOblique();

        assertEquals(0, quantityOblique);
    }

}