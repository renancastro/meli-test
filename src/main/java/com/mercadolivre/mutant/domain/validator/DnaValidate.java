package com.mercadolivre.mutant.domain.validator;

import java.util.stream.Stream;

public class DnaValidate implements DnaValidator {

    private static final String WORDS_DNA = "ATCG";

    @Override
    public boolean isNotValidDna(String[] dna) {
        return Stream.of(dna)
                .anyMatch(sequence -> isInvalidSize(dna.length, sequence) || hasInvalidWord(sequence));
    }

    private boolean hasInvalidWord(String sequence) {
        return Stream.of(sequence.split("")).anyMatch(element -> !WORDS_DNA.contains(element));
    }

    private boolean isInvalidSize(int size, String sequence) {
        return sequence.replaceAll("\\s+", "").length() != size;
    }
}
