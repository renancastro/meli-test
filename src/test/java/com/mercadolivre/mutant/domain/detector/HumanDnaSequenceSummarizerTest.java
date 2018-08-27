package com.mercadolivre.mutant.domain.detector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanDnaSequenceSummarizerTest {

    HumanDnaSequenceSummarizer humanDnaSequenceSummarizer = new HumanDnaSequenceSummarizer();

    @Test
    void shouldHaveZeroSequenceHorizontal() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"};
        int quantityHorizontal = humanDnaSequenceSummarizer.getQuantityHorizontal(dna);

        assertEquals(0, quantityHorizontal);
    }


    @Test
    void shouldHaveOneSequenceHorizontal() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        int quantityHorizontal = humanDnaSequenceSummarizer.getQuantityHorizontal(dna);
        assertEquals(1, quantityHorizontal);
    }

    @Test
    void shouldHaveTwoSequencesHorizontal() {
        String[] dna = {"AAAAGG", "ATGCGA","CAGTGC","TTATGT","ATAAGG","CCTCTA","TACCCC"};
        int quantityHorizontal = humanDnaSequenceSummarizer.getQuantityHorizontal(dna);
        assertEquals(2, quantityHorizontal);
    }

    @Test
    void shouldHaveThreeSequencesHorizontal() {
        String[] dna = {"AAAAGG", "ATGCGA","CAGTGC","TTATGT","ACAAGG","TCCCCA","TACCCC"};
        int quantityHorizontal = humanDnaSequenceSummarizer.getQuantityHorizontal(dna);
        assertEquals(3, quantityHorizontal);
    }

    @Test
    void shouldHaveZeroSequenceVertical() {
        String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGAAGG","CCCCCA","TCACCG"};
        int quantityVertical = humanDnaSequenceSummarizer.getQuantityVertical(dna);
        assertEquals(0, quantityVertical);
    }

    @Test
    void shouldHaveOneSequenceVertical() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        int quantityVertical = humanDnaSequenceSummarizer.getQuantityVertical(dna);
        assertEquals(1, quantityVertical);
    }

    @Test
    void shouldHaveTwoSequenceVertical() {
        String[] dna = {"ATGCGA","AAGTGC","ATATGT","AGAAGG","CCCCCA","TCACCG"};
        int quantityVertical = humanDnaSequenceSummarizer.getQuantityVertical(dna);
        assertEquals(2, quantityVertical);
    }

    @Test
    void shouldHaveThreeSequenceVertical() {
        String[] dna = {"AAGCGA","ATGTGC","ATATGT","ATAAGG","CTCCCA","TTACCG"};
        int quantityVertical = humanDnaSequenceSummarizer.getQuantityVertical(dna);
        assertEquals(3, quantityVertical);
    }

    @Test
    void shouldHaveZeroSequenceOblique() {
        String[] dna = {"ATGCGA","CCGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        int quantityOblique = humanDnaSequenceSummarizer.getQuantityOblique(dna);
        assertEquals(0, quantityOblique);
    }

    @Test
    void shouldHaveOneSequenceOblique() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACCG"};
        int quantityOblique = humanDnaSequenceSummarizer.getQuantityOblique(dna);
        assertEquals(1, quantityOblique);
    }

    @Test
    void shouldHaveTwoSequenceOblique() {
        String[] dna = {"ATGCGA","CAGTGC","TTAAGT","AGAAAG","CACCAA","ACACCG"};
        int quantityOblique = humanDnaSequenceSummarizer.getQuantityOblique(dna);
        assertEquals(2, quantityOblique);
    }

    @Test
    void shouldZeroSequenceOblique() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAGGG","CCCCCA","TCACCG"};
        int quantityOblique = humanDnaSequenceSummarizer.getQuantityOblique(dna);
        assertEquals(0, quantityOblique);
    }

}