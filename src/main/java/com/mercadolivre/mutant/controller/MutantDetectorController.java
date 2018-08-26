package com.mercadolivre.mutant.controller;

import com.mercadolivre.mutant.dto.DnaDTO;
import com.mercadolivre.mutant.dto.HumanMutantStatsDTO;
import com.mercadolivre.mutant.repository.DnaVerifiedRepository;
import com.mercadolivre.mutant.service.HumanMutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantDetectorController {

    private HumanMutantService humanMutantService;

    private DnaVerifiedRepository dnaVerifiedRepository;

    public MutantDetectorController(HumanMutantService humanMutantService,
                                    DnaVerifiedRepository dnaVerifiedRepository) {
        this.humanMutantService = humanMutantService;
        this.dnaVerifiedRepository = dnaVerifiedRepository;
    }

    @PostMapping
    public ResponseEntity<Void> isMutant(@RequestBody @Validated DnaDTO dnaDTO) {
        if (humanMutantService.isMutant(dnaDTO.getDna())){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/stats")
    public HumanMutantStatsDTO getStats() {
        return dnaVerifiedRepository.stats();
    }

}
