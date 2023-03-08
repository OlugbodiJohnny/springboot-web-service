package com.johnny.webservice.controllers.soap;

import com.johnny.webservice.schema.osg.ussd.notification_manager.v1_0.local.StartUSSDNotification;
import com.johnny.webservice.schema.osg.ussd.notification_manager.v1_0.local.StartUSSDNotificationResponse;
import com.johnny.webservice.schema.parlayx.sms.notification.v2_2.local.NotifySmsReception;
import com.johnny.webservice.schema.parlayx.sms.notification.v2_2.local.NotifySmsReceptionResponse;
import com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local.StartSmsNotification;
import com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local.StartSmsNotificationResponse;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSms;
import com.johnny.webservice.schema.parlayx.sms.send.v2_2.local.SendSmsResponse;
import com.johnny.webservice.schema.parlayx.ussd.notification.v1_0.local.NotifyUssdAbort;
import com.johnny.webservice.schema.parlayx.ussd.notification.v1_0.local.NotifyUssdAbortResponse;
import com.johnny.webservice.schema.parlayx.ussd.notification.v1_0.local.NotifyUssdReception;
import com.johnny.webservice.schema.parlayx.ussd.notification.v1_0.local.NotifyUssdReceptionResponse;
import com.johnny.webservice.schema.parlayx.ussd.send.v1_0.local.SendUssd;
import com.johnny.webservice.schema.parlayx.ussd.send.v1_0.local.SendUssdAbort;
import com.johnny.webservice.schema.parlayx.ussd.send.v1_0.local.SendUssdAbortResponse;
import com.johnny.webservice.schema.parlayx.ussd.send.v1_0.local.SendUssdResponse;
import com.johnny.webservice.services.soap.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import javax.xml.soap.SOAPHeaderElement;

@Endpoint(value = "soapExchangeController")
@RequiredArgsConstructor
@Slf4j
public class ExchangeController {

    private final ExchangeService exchangeService;
    private static final  String SMS_NOTIFICATION_MANAGER_SERVICE_NAMESPACE_URI = "http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local";
    private static final  String SMS_NOTIFICATION_SERVICE_NAMESPACE_URI = "http://www.csapi.org/schema/parlayx/sms/notification/v2_2/local";
    private static final  String SMS_SEND_SMS_SERVICE_NAMESPACE_URI = "http://www.csapi.org/schema/parlayx/sms/send/v2_2/local";
    private static final  String USSD_NOTIFICATION_MANAGER_SERVICE_NAMESPACE_URI = "http://www.csapi.org/schema/osg/ussd/notification_manager/v1_0/local";
    private static final  String USSD_NOTIFICATION_SERVICE_NAMESPACE_URI = "http://www.csapi.org/schema/parlayx/ussd/notification/v1_0/local";
    private static final  String USSD_SEND_SERVICE_NAMESPACE_URI = "http://www.csapi.org/schema/parlayx/ussd/send/v1_0/local";
    private static final  String SMS_NOTIFICATION_MANAGER_SERVICE_LOCAL_PART = "startSmsNotification";
    private static final  String SMS_NOTIFICATION_SERVICE_LOCAL_PART = "notifySmsReception";
    private static final  String SMS_SEND_SMS_SERVICE_LOCAL_PART = "sendSms";
    private static final  String USSD_NOTIFICATION_MANAGER_SERVICE_LOCAL_PART = "startUSSDNotification";
    private static final  String USSD_NOTIFICATION_SERVICE_RECEPTION_LOCAL_PART = "notifyUssdReception";
    private static final  String USSD_NOTIFICATION_SERVICE_ABORT_LOCAL_PART = "notifyUssdAbort";
    private static final  String USSD_SEND_SERVICE_SEND_USSD_LOCAL_PART = "sendUssd";
    private static final  String USSD_SEND_SERVICE_SEND_USSD_ABORT_LOCAL_PART = "sendUssdAbort";

    @PayloadRoot(namespace = SMS_NOTIFICATION_MANAGER_SERVICE_NAMESPACE_URI, localPart = SMS_NOTIFICATION_MANAGER_SERVICE_LOCAL_PART)
    @ResponsePayload
    public StartSmsNotificationResponse startSmsNotification (@RequestPayload StartSmsNotification startSmsNotificationRequest, @SoapHeader(value = "{http://www.huawei.com.cn/schema/common/v2_1}RequestSOAPHeader")SoapHeaderElement soapHeaderElement) {
        return exchangeService.startSmsNotification(startSmsNotificationRequest,soapHeaderElement);
    }

    @PayloadRoot(namespace = SMS_NOTIFICATION_SERVICE_NAMESPACE_URI, localPart = SMS_NOTIFICATION_SERVICE_LOCAL_PART)
    @ResponsePayload
    public NotifySmsReceptionResponse notifySmsReception (@RequestPayload NotifySmsReception notifySmsReceptionRequest, @SoapHeader(value = "{http://www.huawei.com.cn/schema/common/v2_1}NotifySOAPHeader")SoapHeaderElement soapHeaderElement) {
        return exchangeService.notifySmsReception(notifySmsReceptionRequest,soapHeaderElement);
    }

    @PayloadRoot(namespace = SMS_SEND_SMS_SERVICE_NAMESPACE_URI, localPart = SMS_SEND_SMS_SERVICE_LOCAL_PART)
    @ResponsePayload
    public SendSmsResponse sendSms (@RequestPayload SendSms sendSmsRequest, @SoapHeader(value = "{http://www.huawei.com.cn/schema/common/v2_1}RequestSOAPHeader")SoapHeaderElement soapHeaderElement) {
        return exchangeService.sendSms(sendSmsRequest,soapHeaderElement);
    }

    @PayloadRoot(namespace = USSD_NOTIFICATION_MANAGER_SERVICE_NAMESPACE_URI, localPart = USSD_NOTIFICATION_MANAGER_SERVICE_LOCAL_PART)
    @ResponsePayload
    public StartUSSDNotificationResponse startUssdNotification (@RequestPayload StartUSSDNotification startUSSDNotificationRequest) {
        return exchangeService.startUssdNotification(startUSSDNotificationRequest);
    }

    @PayloadRoot(namespace = USSD_NOTIFICATION_SERVICE_NAMESPACE_URI, localPart = USSD_NOTIFICATION_SERVICE_RECEPTION_LOCAL_PART)
    @ResponsePayload
    public NotifyUssdReceptionResponse notifyUssdReception (@RequestPayload NotifyUssdReception notifyUssdReceptionRequest) {
        return exchangeService.notifyUssdReception(notifyUssdReceptionRequest);
    }

    @PayloadRoot(namespace = USSD_NOTIFICATION_SERVICE_NAMESPACE_URI, localPart = USSD_NOTIFICATION_SERVICE_ABORT_LOCAL_PART)
    @ResponsePayload
    public NotifyUssdAbortResponse notifyUssdAbort (@RequestPayload NotifyUssdAbort notifyUssdAbortRequest) {
        return exchangeService.notifyUssdAbort(notifyUssdAbortRequest);
    }

    @PayloadRoot(namespace = USSD_SEND_SERVICE_NAMESPACE_URI, localPart = USSD_SEND_SERVICE_SEND_USSD_LOCAL_PART)
    @ResponsePayload
    public SendUssdResponse sendUssd (@RequestPayload SendUssd sendUssdRequest) {
        return exchangeService.sendUssd(sendUssdRequest);
    }

    @PayloadRoot(namespace = USSD_SEND_SERVICE_NAMESPACE_URI, localPart = USSD_SEND_SERVICE_SEND_USSD_ABORT_LOCAL_PART)
    @ResponsePayload
    public SendUssdAbortResponse sendUssdAbort (@RequestPayload SendUssdAbort sendUssdAbortRequest) {
        return exchangeService.sendUssdAbort(sendUssdAbortRequest);
    }

}

