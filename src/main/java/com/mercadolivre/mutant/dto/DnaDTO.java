package com.mercadolivre.mutant.dto;

import javax.validation.constraints.NotNull;

public class DnaDTO {

    @NotNull
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
