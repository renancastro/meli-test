package com.mercadolivre.mutant.domain.detector;

import java.util.Objects;

class DnaSequenceSummarizer {

    private static final int MINIMUM_LETTER_EQUALS = 4;

    private final String dna[];

    public DnaSequenceSummarizer(String[] dna) {
        this.dna = Objects.requireNonNull(dna, "Dna is required.");
    }

    int getQuantitySequences() {
        return getQuantityVertical() + getQuantityHorizontal() + getQuantityOblique();
    }

    int getQuantityHorizontal() {
        int quantityHorizontalSequence = 0;

        for (int i = 0; i < dna.length; i++) {
            String[] row = dna[i].split("");
            int letterEquals = 1;
            for (int j = 0; j < row.length && j + 1 < row.length; j++) {
                if(row[j].equals(row[j+1])) {
                    letterEquals++;
                } else {
                    letterEquals = 1;
                }

                if (letterEquals == MINIMUM_LETTER_EQUALS) {
                    quantityHorizontalSequence++;
                    break;
                }
            }
        }
        return quantityHorizontalSequence;
    }

    int getQuantityVertical() {
        int quantitySequenceVertical = 0;

        for (int i = 0; i < dna.length; i++) {
            int letterEquals = 1;
            for (int j = 0; j < dna.length && j + 1 < dna.length; j++) {
                String[] row = dna[j].split("");
                String[] nextRow = dna[j + 1].split("");
                if (row[i].equals(nextRow[i])) {
                    letterEquals++;
                } else {
                    letterEquals = 1;
                }

                if (letterEquals == 4) {
                    quantitySequenceVertical++;
                    break;
                }
            }

        }

        return quantitySequenceVertical;
    }

    int getQuantityOblique() {
        int quantitySequenceOblique = 0;
        int letterEquals = 1;
        for (int i = 0; i < dna.length && i + 1 < dna.length; i++) {
            String[] row = dna[i].split("");
            String[] nextRow = dna[i + 1].split("");

            if (row[i].equals(nextRow[i + 1])) {
                letterEquals++;
            } else {
                letterEquals = 1;
            }

            if (letterEquals == MINIMUM_LETTER_EQUALS) {
                quantitySequenceOblique++;
                break;
            }

        }

        letterEquals = 1;

        for (int i = 0, j = dna.length - 1; j > 0; i++, j--) {
            String[] row = dna[i].split("");
            String[] nextRow = dna[i + 1].split("");

            if (row[j].equals(nextRow[j - 1])) {
                letterEquals++;
            } else {
                letterEquals = 1;
            }

            if (letterEquals == MINIMUM_LETTER_EQUALS) {
                quantitySequenceOblique++;
                break;
            }
        }

        return quantitySequenceOblique;

    }
}
