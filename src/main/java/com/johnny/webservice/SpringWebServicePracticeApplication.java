package com.johnny.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.webservice.schema.parlayx.common.v2_1.SimpleReference;
import com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local.StartSmsNotification;
import com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local.StartSmsNotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class SpringWebServicePracticeApplication implements CommandLineRunner {

    @Value("${baseurl.backend}")
    private String backendBaseUrl;

    @Value("${baseurl.web-service}")
    private String webServiceBaseUrl;

    private final Jaxb2Marshaller smsNotificationManagerServiceJaxb2Marshaller;

    private final ObjectMapper objectMapper;

    private final WebServiceTemplate webServiceTemplate;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication (SpringWebServicePracticeApplication.class);
        app.setAdditionalProfiles("dev");
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    @Override
    public void run(String... args) {
        try {
            StartSmsNotification startSmsNotificationRequest = new StartSmsNotification();
            startSmsNotificationRequest.setSmsServiceActivationNumber("smsActivationNumber");
            startSmsNotificationRequest.setCriteria("criteria");
            SimpleReference simpleReference = new SimpleReference();
            simpleReference.setCorrelator("correlator");
            simpleReference.setEndpoint("endpoint");
            simpleReference.setInterfaceName("interfaceName");
            startSmsNotificationRequest.setReference(simpleReference);
            webServiceTemplate.setMarshaller(smsNotificationManagerServiceJaxb2Marshaller);
            webServiceTemplate.setUnmarshaller(smsNotificationManagerServiceJaxb2Marshaller);
            JAXBElement<StartSmsNotificationResponse> startSmsNotificationResponse = (JAXBElement<StartSmsNotificationResponse>) webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri() + "/SmsNotificationManagerService", startSmsNotificationRequest);
            log.info("on startup startSmsNotificationResponse ======= {}", objectMapper.writeValueAsString(startSmsNotificationResponse.getValue()));
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");
        String serverPort = env.getProperty("server.port");
        String contextPath = Optional
                .ofNullable(env.getProperty("server.servlet.context-path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        log.info(
                "\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles().length == 1 ? "[dev]" : env.getActiveProfiles()[0].equals("dev")? "["+env.getActiveProfiles()[1]+"]" : "["+env.getActiveProfiles()[0]+"]"
        );
    }
}
