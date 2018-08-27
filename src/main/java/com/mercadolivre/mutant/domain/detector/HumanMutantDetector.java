package com.mercadolivre.mutant.domain.detector;


import com.mercadolivre.mutant.domain.validator.DnaValidator;

import java.util.Objects;

public class HumanMutantDetector implements MutantDetector {

    private static final int MINIMUM_SEQUENCES = 3;

    private DnaValidator dnaValidator;

    private DnaSequenceSummarizer dnaSequenceSummarizer;

    public HumanMutantDetector(DnaValidator dnaValidator, DnaSequenceSummarizer dnaSequenceSummarizer) {
        this.dnaValidator = Objects.requireNonNull(dnaValidator, "A Validator is required.");
        this.dnaSequenceSummarizer = Objects.requireNonNull(dnaSequenceSummarizer);
    }

    @Override
    public boolean isMutant(String[] dna) {
        if(dnaValidator.isNotValidDna(dna)) throw new IllegalArgumentException("Invalid Dna");
        int quantitySequences = dnaSequenceSummarizer.getQuantitySequences(dna);
        return quantitySequences >= MINIMUM_SEQUENCES;
    }
}
