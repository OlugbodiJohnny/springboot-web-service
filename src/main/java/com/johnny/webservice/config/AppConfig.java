package com.johnny.webservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.Servlet;

@Configuration
@EnableWs
public class AppConfig {

    @Value("${baseurl.backend}")
    private String backendBaseUrl;

    @Value("${baseurl.web-service}")
    private String webServiceBaseUrl;

    @Bean
    public ServletRegistrationBean<Servlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet =
                new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);

        return new ServletRegistrationBean<>(servlet,
                "/johnny/web-service-practice/*");
    }

//    @Bean(name = "SmsNotificationManagerService")
//    public Wsdl11Definition smsNotificationManagerServiceWsdl11Definition() {
//        SimpleWsdl11Definition wsdl11Definition =
//                new SimpleWsdl11Definition();
//        wsdl11Definition
//                .setWsdl(new ClassPathResource("/wsdl/parlayx_sms_notification_manager_interface_2_3.wsdl"));
//
//        return wsdl11Definition;
//    }

//    @Bean(name = "SmsNotificationService")
//    public Wsdl11Definition smsNotificationServiceWsdl11Definition() {
//        SimpleWsdl11Definition wsdl11Definition =
//                new SimpleWsdl11Definition();
//        wsdl11Definition
//                .setWsdl(new ClassPathResource("/wsdl/parlayx_sms_notification_service_2_2.wsdl"));
//        return wsdl11Definition;
//    }
//
//    @Bean(name = "SendSmsService")
//    public Wsdl11Definition sendSmsServiceWsdl11Definition() {
//        SimpleWsdl11Definition wsdl11Definition =
//                new SimpleWsdl11Definition();
//        wsdl11Definition
//                .setWsdl(new ClassPathResource("/wsdl/parlayx_sms_notification_service_2_2.wsdl"));
//        return wsdl11Definition;
//    }
//
//    @Bean(name = "USSDNotificationManagerService")
//    public Wsdl11Definition uSSDNotificationManagerServiceWsdl11Definition() {
//        SimpleWsdl11Definition wsdl11Definition =
//                new SimpleWsdl11Definition();
//        wsdl11Definition
//                .setWsdl(new ClassPathResource("/wsdl/osg_ussd_notification_manager_service_1_0.wsdl"));
//        return wsdl11Definition;
//    }
//
    @Bean("smsNotificationManagerServiceJaxb2Marshaller")
//    @Qualifier("smsNotificationManagerServiceJaxb2Marshaller")
    Jaxb2Marshaller smsNotificationManagerServiceJaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller
                .setContextPath("com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local");
        return jaxb2Marshaller;
    }

    @Bean("smsNotificationServiceJaxb2Marshaller")
//    @Qualifier("smsNotificationServiceJaxb2Marshaller")
    Jaxb2Marshaller smsNotificationServiceJaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller
                .setContextPath("com.johnny.webservice.schema.parlayx.sms.notification.v2_2.local");
        return jaxb2Marshaller;
    }

    @Bean("sendSmsServiceJaxb2Marshaller")
    Jaxb2Marshaller sendSmsServiceJaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller
                .setContextPath("com.johnny.webservice.schema.parlayx.sms.send.v2_2.local");
        return jaxb2Marshaller;
    }

//
//    @Bean
//    Jaxb2Marshaller uSSDNotificationManagerServiceJaxb2Marshaller() {
//        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//        jaxb2Marshaller
//                .setContextPath("com.johnny.webservice.schema.osg.ussd.notification_manager.v1_0.local");
//        return jaxb2Marshaller;
//    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri(webServiceBaseUrl);
        return webServiceTemplate;
    }

    @Bean
    public ObjectMapper objectMapper () {
        return new ObjectMapper();
    }
}
