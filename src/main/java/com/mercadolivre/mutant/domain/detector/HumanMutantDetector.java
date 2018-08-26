package com.mercadolivre.mutant.domain.detector;


import com.mercadolivre.mutant.domain.validator.DnaValidator;

import java.util.Objects;

public class HumanMutantDetector implements MutantDetector {

    private static final int MINIMUM_SEQUENCES = 3;

    private DnaValidator dnaValidator;

    public HumanMutantDetector(DnaValidator dnaValidator) {
        this.dnaValidator = Objects.requireNonNull(dnaValidator, "A Validator is required.");
    }

    @Override
    public boolean isMutant(String[] dna) {
        if(dnaValidator.isNotValidDna(dna)) throw new IllegalArgumentException("Invalid Dna");

        DnaSequenceSummarizer summarizer = new DnaSequenceSummarizer(dna);
        int quantitySequences = summarizer.getQuantitySequences();
        return quantitySequences >= MINIMUM_SEQUENCES;
    }
}
