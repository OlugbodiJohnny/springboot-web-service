package com.johnny.webservice.servicesImpl.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.webservice.payload.request.SmsDeliveryQueryRequest;
import com.johnny.webservice.payload.response.Payload;
import com.johnny.webservice.payload.response.SmsDeliveryQueryResponse;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSms;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSmsResponse;
import com.johnny.webservice.services.rest.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;

@Service("restExchangeService")
@RequiredArgsConstructor
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {

    @Value("${baseurl.web-service}")
    private String webServiceBaseUrl;

    @Value("${exchange.sms-account.SpId}")
    private String exchangeSpIdForSms;

    private final WebServiceTemplate webServiceTemplate;

    @Qualifier("sendSmsServiceJaxb2Marshaller")
    private final Jaxb2Marshaller sendSmsServiceJaxb2Marshaller;

    private final ObjectMapper objectMapper;

    @Override
    public SendSmsResponse sendSms (SendSms sendSmsRequest) {
        try {
            webServiceTemplate.setMarshaller(sendSmsServiceJaxb2Marshaller);
            webServiceTemplate.setUnmarshaller(sendSmsServiceJaxb2Marshaller);
            JAXBElement<SendSmsResponse> sendSmsResponseJAXBElement = (JAXBElement<SendSmsResponse>) webServiceTemplate.marshalSendAndReceive(webServiceBaseUrl, sendSmsRequest);
            return sendSmsResponseJAXBElement.getValue();
        }catch (Exception e) {
            log.info("error occurred{}",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SmsDeliveryQueryResponse sendSmsDeliveryQuery (SmsDeliveryQueryRequest smsDeliveryQueryRequest) {
        Payload payload = Payload.builder()
                .msisdn("2347010334256")
                .senderId("13205")
                .account(exchangeSpIdForSms)
                .result("DELIVERED")
                .build();

        return SmsDeliveryQueryResponse.builder()
                .resultCode("0")
                .resultDesc("SUCCESS")
                .payload(payload)
                .build();
    }


}
