package com.johnny.webservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;
import com.johnny.webservice.payload.request.NotifySoapHeaderEnvelope;
import com.johnny.webservice.payload.request.RequestSoapHeader;
import com.johnny.webservice.payload.request.RequestSoapHeaderEnvelope;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import org.json.JSONObject;
import org.json.XML;

@Slf4j
public class XmlUtil {

    public static void main(String[] args) {
//        ObjectFactory objectFactory = new ObjectFactory();
//        StartSmsNotification startSmsNotificationRequest = objectFactory.createStartSmsNotification();
//        startSmsNotificationRequest.setSmsServiceActivationNumber("smsActivationNumber");
//        startSmsNotificationRequest.setCriteria("criteria");
//        SimpleReference simpleReference = new SimpleReference();
//        simpleReference.setCorrelator("correlator");
//        simpleReference.setEndpoint("endpoint");
//        simpleReference.setInterfaceName("interfaceName");
//        startSmsNotificationRequest.setReference(simpleReference);
//        JAXBElement<StartSmsNotification> startSmsNotificationJAXBElement = new JAXBElement<>(new QName("http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", "startSmsNotification"), StartSmsNotification.class, startSmsNotificationRequest);
//        System.out.println(XmlUtil.toXML3(startSmsNotificationJAXBElement));
    }

    public static String toXML(Object data) {
        String xml = "";
        try {
            log.info("Generating xml for: " + data.getClass());
            JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(data, System.out);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(data, sw);
            xml = sw.toString();
        } catch (JAXBException e) {
            //handle your exception here
            e.printStackTrace();
            log.info("{}",e.getMessage());
            log.info("Omo... your xml no gree parse ooh");
        }
        return xml;
    }

    public static NotifySoapHeaderEnvelope mapToNotifySOAPHeader(String data) {
        try {

            JSONObject jsonObject = XML.toJSONObject(data);
            ObjectMapper mapper = JsonMapper.builder()
                    .addModule(new JsonOrgModule())
                    .build();
            NotifySoapHeaderEnvelope notifySoapHeaderEnvelope = mapper.convertValue(jsonObject, NotifySoapHeaderEnvelope.class);
            return notifySoapHeaderEnvelope;
        } catch (Exception e) {
            //handle your exception here
            e.printStackTrace();
            log.info("{}",e.getMessage());
            log.info("Omo... your xml no gree parse ooh");
        }
        throw new RuntimeException("Something went wrong");
    }

    public static RequestSoapHeaderEnvelope mapToRequestSOAPHeader (String data) {
        try {

            JSONObject jsonObject = XML.toJSONObject(data);
            ObjectMapper mapper = JsonMapper.builder()
                    .addModule(new JsonOrgModule())
                    .build();
            RequestSoapHeaderEnvelope requestSoapHeaderEnvelope = mapper.convertValue(jsonObject, RequestSoapHeaderEnvelope.class);
            return requestSoapHeaderEnvelope;
        } catch (Exception e) {
            //handle your exception here
            e.printStackTrace();
            log.info("{}",e.getMessage());
            log.info("Omo... your xml no gree parse ooh");
        }
        throw new RuntimeException("Something went wrong");
    }

    public static String toXML3 (Object data) {
        String xml = "";

        try {
            XmlMapper xmlMapper = new XmlMapper();
            xml = xmlMapper.writeValueAsString(data);
            System.out.println(xml);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return xml;
    }



}
