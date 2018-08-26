package com.mercadolivre.mutant.listener;

import com.mercadolivre.mutant.domain.model.DnaVerified;
import com.mercadolivre.mutant.repository.DnaVerifiedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class DnaVerifiedListener {

    private DnaVerifiedRepository dnaVerifiedRepository;

    @Autowired
    public DnaVerifiedListener(DnaVerifiedRepository dnaVerifiedRepository) {
        this.dnaVerifiedRepository= Objects.requireNonNull(dnaVerifiedRepository);
    }

    @Async
    @EventListener
    public void onDnaVerified(DnaVerified dnaVerified) {
        log.debug("Saving new DnaVerified={}", dnaVerified);
        dnaVerifiedRepository.save(dnaVerified);
    }
}
