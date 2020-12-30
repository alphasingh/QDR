package com.cambian.questionnaire.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.cambian.questionnaire.security.SecurityConfiguration.OAUTH_TOKEN_ENDPOINT;

@Configuration
public class OpenApiDocsConfig {

    public static final String SECURITY_KEY = "bearer-key";
    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${server.port}")
    private String port;

    @Bean
    public OpenAPI openAPI() {
        final OAuthFlows oAuthFlows = new OAuthFlows().clientCredentials(new OAuthFlow()
                .tokenUrl("http://localhost:" + port + contextPath + OAUTH_TOKEN_ENDPOINT));
        return new OpenAPI()
                .addServersItem(new Server()
                        .description("Local")
                        .url("http://localhost:" + port + contextPath))
                .addServersItem(new Server()
                        .description("Dev")
                        .url("https://dev.fhir.com" + contextPath))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_KEY,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.OAUTH2)
                                        .flows(oAuthFlows))
                );
    }
}