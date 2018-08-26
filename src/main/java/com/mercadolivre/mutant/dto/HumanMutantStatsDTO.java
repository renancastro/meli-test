package com.mercadolivre.mutant.dto;

import lombok.Getter;

@Getter
public class HumanMutantStatsDTO {

    private Long countMutantDna;

    private Long countHumanDna;

    public HumanMutantStatsDTO(Long countMutantDna, Long countHumanDna) {
        this.countMutantDna = countMutantDna == null ? 0 : countMutantDna;
        this.countHumanDna = countHumanDna == null ? 0 : countHumanDna;
    }

    public Double getRatio() {
        if (countHumanDna != 0) {
            return countMutantDna.doubleValue() / countHumanDna.doubleValue();
        }
        return 0.0;
    }
}
