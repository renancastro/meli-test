package com.mercadolivre.mutant.repository;

import com.mercadolivre.mutant.domain.model.DnaVerified;
import com.mercadolivre.mutant.dto.HumanMutantStatsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DnaVerifiedRepository extends JpaRepository<DnaVerified, Long> {

    @Query("select new com.mercadolivre.mutant.dto.HumanMutantStatsDTO(SUM(CASE WHEN d.mutant > 0 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN d.mutant > 0 THEN 0 ELSE 1 END)) " +
            "from DnaVerified d")
    HumanMutantStatsDTO stats();
}
