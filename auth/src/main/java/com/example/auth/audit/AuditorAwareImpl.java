package com.example.auth.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
//Auditing
public class AuditorAwareImpl implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.ofNullable("Murat");
    }
}
