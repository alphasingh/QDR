package com.cambian.questionnaire.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FHIRServletConfig {
    @Bean
    public ServletRegistrationBean<?> ServletRegistrationBean() {
        final String[] urlMappings = {"/fhir/*", "/unsecure/fhir/*"};
        ServletRegistrationBean<?> registration
                = new ServletRegistrationBean<>(new SimpleRestfulServer(), urlMappings);
        registration.setName("FhirServlet");
        return registration;
    }
}
