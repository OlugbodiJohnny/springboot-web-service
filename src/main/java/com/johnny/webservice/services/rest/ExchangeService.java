package com.johnny.webservice.services.rest;

import com.johnny.webservice.payload.request.SmsDeliveryQueryRequest;
import com.johnny.webservice.payload.response.SmsDeliveryQueryResponse;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSms;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSmsResponse;

public interface ExchangeService {

    SendSmsResponse sendSms(SendSms sendSmsRequest);

    SmsDeliveryQueryResponse sendSmsDeliveryQuery(SmsDeliveryQueryRequest smsDeliveryQueryRequest);
}
