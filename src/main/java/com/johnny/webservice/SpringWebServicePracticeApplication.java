package com.johnny.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.webservice.schema.parlayx.common.v2_1.SimpleReference;
import com.johnny.webservice.schema.parlayx.sms.notification.v2_2.local.NotifySmsReception;
import com.johnny.webservice.schema.parlayx.sms.notification.v2_2.local.NotifySmsReceptionResponse;
import com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local.StartSmsNotification;
import com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local.StartSmsNotificationResponse;
import com.johnny.webservice.schema.parlayx.sms.v2_2.SmsMessage;
import com.johnny.webservice.utils.MD5;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class SpringWebServicePracticeApplication implements CommandLineRunner {

    @Value("${baseurl.backend}")
    private String backendBaseUrl;

    @Value("${baseurl.web-service}")
    private String webServiceBaseUrl;

    @Value("${exchange.partner-account.partner-username}")
    private String exchangePartnerAccountUsername;

    @Value("${exchange.partner-account.password}")
    private String exchangePartnerAccountPassword;

    @Qualifier("smsNotificationManagerServiceJaxb2Marshaller")
    private final Jaxb2Marshaller smsNotificationManagerServiceJaxb2Marshaller;

    @Qualifier("smsNotificationServiceJaxb2Marshaller")
    private final Jaxb2Marshaller smsNotificationServiceJaxb2Marshaller;

    private final ObjectMapper objectMapper;

    private final WebServiceTemplate webServiceTemplate;

//    @Autowired
//    public SpringWebServicePracticeApplication(@Qualifier("smsNotificationManagerServiceJaxb2Marshaller")Jaxb2Marshaller smsNotificationManagerServiceJaxb2Marshaller, @Qualifier("smsNotificationServiceJaxb2Marshaller") Jaxb2Marshaller smsNotificationServiceJaxb2Marshaller, ObjectMapper objectMapper, WebServiceTemplate webServiceTemplate) {
//        this.smsNotificationManagerServiceJaxb2Marshaller = smsNotificationManagerServiceJaxb2Marshaller;
//        this.smsNotificationServiceJaxb2Marshaller = smsNotificationServiceJaxb2Marshaller;
//        this.objectMapper = objectMapper;
//        this.webServiceTemplate = webServiceTemplate;
//    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication (SpringWebServicePracticeApplication.class);
        app.setAdditionalProfiles("dev");
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    @Override
    public void run(String... args) {
        testStartSmsNotificationEndpoint();
        testNotifySmsReceptionEndpoint();
    }

    private void testStartSmsNotificationEndpoint() {
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
            JAXBElement<StartSmsNotificationResponse> startSmsNotificationResponse = (JAXBElement<StartSmsNotificationResponse>) webServiceTemplate.marshalSendAndReceive(webServiceTemplate.getDefaultUri(), startSmsNotificationRequest, new WebServiceMessageCallback() {
                @Override
                public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                    try {
                        SOAPMessage soapMessage = ((SaajSoapMessage)webServiceMessage).getSaajMessage();
                        SOAPHeader header = soapMessage.getSOAPHeader();
                        SOAPHeaderElement requestSoapHeader = header.addHeaderElement(new QName("http://www.huawei.com.cn/schema/common/v2_1","RequestSOAPHeader","ns3"));
                        SOAPElement spId = requestSoapHeader.addChildElement("spId", "ns3");
                        SOAPElement spPassword = requestSoapHeader.addChildElement("spPassword", "ns3");
                        SOAPElement serviceId = requestSoapHeader.addChildElement("serviceId", "ns3");
                        SOAPElement timeStamp = requestSoapHeader.addChildElement("timeStamp", "ns3");
                        spId.setTextContent(exchangePartnerAccountUsername);
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                        String date = dateTimeFormatter.format(LocalDateTime.now());
                        log. info("date header in testStartSmsNotificationEndpoint() {}",date);
                        String md5Password = MD5.getMd5(exchangePartnerAccountUsername+exchangePartnerAccountPassword+date);
                        spPassword.setTextContent(md5Password);
                        serviceId.setTextContent("10496");
                        timeStamp.setTextContent(date);
                        log.info("requestSoapHeader===={}",objectMapper.writeValueAsString(requestSoapHeader));
                    } catch (Exception e) {
                        //... handle appropriately
                        log.info("{}",e);
                    }
                }
            });
            log.info("on startup startSmsNotificationResponse ======= {}", objectMapper.writeValueAsString(startSmsNotificationResponse.getValue()));
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
    }

    private void testNotifySmsReceptionEndpoint () {
        try {
            NotifySmsReception notifySmsReceptionRequest = new NotifySmsReception();
            notifySmsReceptionRequest.setCorrelator("correlator");
            SmsMessage smsMessage = new SmsMessage();
            smsMessage.setMessage("sms message");
            smsMessage.setSmsServiceActivationNumber("smsServiceActivationNumber");
            Date currentDate = new Date();
            XMLGregorianCalendar xmlDate = null;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(currentDate);
            try {
                xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
                log.info("dateTime header is ======= {}",xmlDate);
            } catch (Exception e) {
                log.info("error creating xml gregorian calender {}", e.getMessage());
            }
            smsMessage.setDateTime(xmlDate);
            smsMessage.setSenderAddress("2347010334256");
            notifySmsReceptionRequest.setMessage(smsMessage);
            webServiceTemplate.setMarshaller(smsNotificationServiceJaxb2Marshaller);
            webServiceTemplate.setUnmarshaller(smsNotificationServiceJaxb2Marshaller);
            JAXBElement<NotifySmsReceptionResponse> notifySmsReceptionResponse = (JAXBElement<NotifySmsReceptionResponse>) webServiceTemplate.marshalSendAndReceive(notifySmsReceptionRequest, new WebServiceMessageCallback() {
                @Override
                public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                    try {
                        SOAPMessage soapMessage = ((SaajSoapMessage) webServiceMessage).getSaajMessage();
                        SOAPHeader header = soapMessage.getSOAPHeader();
                        SOAPHeaderElement notifySoapHeader = header.addHeaderElement(new QName("http://www.huawei.com.cn/schema/common/v2_1", "NotifySOAPHeader", "ns1"));
                        SOAPElement spRevId = notifySoapHeader.addChildElement("spRevId", "ns1");
                        SOAPElement spRevPassword = notifySoapHeader.addChildElement("spRevpassword", "ns1");
                        SOAPElement spId = notifySoapHeader.addChildElement("spId", "ns1");
                        SOAPElement serviceId = notifySoapHeader.addChildElement("serviceId", "ns1");
                        SOAPElement traceUniqueID = notifySoapHeader.addChildElement("traceUniqueID", "ns1");
                        SOAPElement timeStamp = notifySoapHeader.addChildElement("timeStamp", "ns1");
                        SOAPElement operatorID = notifySoapHeader.addChildElement("OperatorID", "ns1");
                        SOAPElement linkId = notifySoapHeader.addChildElement("linkid", "ns1");
                        spRevId.setTextContent(exchangePartnerAccountUsername);
                        spRevPassword.setTextContent(exchangePartnerAccountUsername);
                        spId.setTextContent(exchangePartnerAccountUsername);
                        serviceId.setTextContent("10496");
                        traceUniqueID.setTextContent("100001200101110623021721000011");
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                        String date = dateTimeFormatter.format(LocalDateTime.now());
                        log.info("date header in testNotifySmsReceptionEndpoint() {}", date);
                        timeStamp.setTextContent(date);
                        operatorID.setTextContent("2");
                        linkId.setTextContent("linkID");
                    } catch (Exception e) {
                        log.info("{}", e.getMessage());
                    }
                }
            });
            log.info("on startup notifySmsReceptionResponse ======= {}", objectMapper.writeValueAsString(notifySmsReceptionResponse.getValue()));
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
