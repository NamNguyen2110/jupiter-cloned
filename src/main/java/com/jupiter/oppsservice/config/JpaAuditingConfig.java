package com.jupiter.oppsservice.config;

import com.jupiter.common.security.SecurityContext;
import com.jupiter.common.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    @Autowired
    private SecurityContext securityContext;

    @Bean
    public AuditorAware<String> auditorProviderAuth() {
        return new AuditorAwareImpl();
    }

    private class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of(DataUtils.safeToString(securityContext.getUsername(), "administrator"));
        }
    }
}
