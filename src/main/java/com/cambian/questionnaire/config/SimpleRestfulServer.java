package com.cambian.questionnaire.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.RestfulServer;
import com.cambian.questionnaire.resource.PatientResourceProvider;

import javax.servlet.annotation.WebServlet;

@WebServlet("/*")
public class SimpleRestfulServer extends RestfulServer {
    @Override
    protected void initialize() {
        //create a context for the appropriate version
        setFhirContext(FhirContext.forR5());
        //Register Resource Providers
        registerProvider(new PatientResourceProvider());
    }
}