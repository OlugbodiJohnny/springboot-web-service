package com.johnny.webservice.controllers.rest;

import com.johnny.webservice.payload.request.SmsDeliveryQueryRequest;
import com.johnny.webservice.payload.response.SmsDeliveryQueryResponse;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSms;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSmsResponse;
import com.johnny.webservice.services.rest.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("restSmsController")
@RequestMapping("/api/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping("/send-sms")
    public SendSmsResponse sendSms (@RequestBody SendSms sendSmsRequest) {
        return exchangeService.sendSms(sendSmsRequest);
    }

    @PostMapping("/send-sms-delivery-query")
    public SmsDeliveryQueryResponse sendSmsDeliveryQuery (@RequestBody SmsDeliveryQueryRequest smsDeliveryQueryRequest) {
        return exchangeService.sendSmsDeliveryQuery(smsDeliveryQueryRequest);
    }


}
