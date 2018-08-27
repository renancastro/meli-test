package com.mercadolivre.mutant.domain.detector;

public interface DnaSequenceSummarizer {

    int getQuantitySequences(String[] dna);

    int getQuantityHorizontal(String[] dna);

    int getQuantityVertical(String[] dna);

    int getQuantityOblique(String[] dna);
}
