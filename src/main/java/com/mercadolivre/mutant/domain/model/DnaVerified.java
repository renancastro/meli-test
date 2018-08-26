package com.mercadolivre.mutant.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@ToString(of = {"dna", "mutant"})
@EqualsAndHashCode(of = "id")
@Entity
public class DnaVerified {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String[] dna;

    private final Boolean mutant;

    private ZonedDateTime createdOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = ZonedDateTime.now();
    }

    public DnaVerified(String[] dna, boolean mutant) {
        this.dna = dna;
        this.mutant = mutant;
    }

}
