package com.johnny.webservice.services.soap;


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
import org.springframework.ws.soap.SoapHeaderElement;

import javax.xml.soap.SOAPHeaderElement;

public interface ExchangeService {

    StartSmsNotificationResponse startSmsNotification (StartSmsNotification startSmsNotificationRequest, SoapHeaderElement soapHeaderElement);

    NotifySmsReceptionResponse notifySmsReception (NotifySmsReception notifySmsReceptionRequest, SoapHeaderElement soapHeaderElement);

    SendSmsResponse sendSms (SendSms sendSmsRequest, SoapHeaderElement soapHeaderElement);

    StartUSSDNotificationResponse startUssdNotification (StartUSSDNotification startUSSDNotificationRequest);

    NotifyUssdReceptionResponse notifyUssdReception (NotifyUssdReception notifyUssdReceptionRequest);

    NotifyUssdAbortResponse notifyUssdAbort (NotifyUssdAbort notifyUssdAbortRequest);

    SendUssdResponse sendUssd (SendUssd sendUssdRequest);

    SendUssdAbortResponse sendUssdAbort (SendUssdAbort sendUssdAbortRequest);
}
