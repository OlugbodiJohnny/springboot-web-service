package com.johnny.webservice.servicesImpl.soap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.webservice.payload.request.NotifySoapHeaderSource;
import com.johnny.webservice.payload.request.NotifySoapHeaderEnvelope;
import com.johnny.webservice.payload.request.RequestSoapHeaderEnvelope;
import com.johnny.webservice.payload.request.RequestSoapHeaderSource;
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
import com.johnny.webservice.utils.XmlUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.SoapHeaderElement;

@Service("soapExchangeService")
@RequiredArgsConstructor
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {

    private final ObjectMapper objectMapper;

    @Override
    public StartSmsNotificationResponse startSmsNotification (StartSmsNotification startSmsNotificationRequest, SoapHeaderElement soapHeaderElement) {
        try {
            log.info("inside startSmsNotification() endpoint");
            log.info("we are calling the soap service endpoint to start sms notification");
            RequestSoapHeaderSource requestSoapHeaderSource = objectMapper.convertValue(soapHeaderElement.getSource(), RequestSoapHeaderSource.class);
            RequestSoapHeaderEnvelope requestSoapHeaderEnvelope = XmlUtil.mapToRequestSOAPHeader(requestSoapHeaderSource.getNode());
            String string1 = objectMapper.writeValueAsString(startSmsNotificationRequest);
            log.info("startSmsNotificationRequest in soap endpoint as string is =============== {}", string1);
            log.info("soapHeaderElement in soap endpoint as string is =============== {}", requestSoapHeaderEnvelope);
            StartSmsNotificationResponse startSmsNotificationResponse = new StartSmsNotificationResponse();
            log.info("startSmsNotificationResponse is {}", objectMapper.writeValueAsString(startSmsNotificationResponse));
            return startSmsNotificationResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }

    @Override
    public NotifySmsReceptionResponse notifySmsReception (NotifySmsReception notifySmsReceptionRequest, SoapHeaderElement soapHeaderElement) {
        try {
            log.info("inside notifySmsReception() endpoint");
            log.info("we are calling the soap service endpoint to notify sms reception");
            NotifySoapHeaderSource notifySoapHeaderSource = objectMapper.convertValue(soapHeaderElement.getSource(), NotifySoapHeaderSource.class);
            NotifySoapHeaderEnvelope notifySoapHeaderEnvelope = XmlUtil.mapToNotifySOAPHeader(notifySoapHeaderSource.getNode());
            String string1 = objectMapper.writeValueAsString(notifySmsReceptionRequest);
            log.info("notifySmsReceptionRequest in soap endpoint as string is =============== {}", string1);
            log.info("soapHeaderElement inside notifySmsReception() is {}",objectMapper.writeValueAsString(notifySoapHeaderEnvelope));
            NotifySmsReceptionResponse notifySmsReceptionResponse = new NotifySmsReceptionResponse();
            log.info("notifySmsReceptionResponse is {}, dateTime header is {}", objectMapper.writeValueAsString(notifySmsReceptionResponse),objectMapper.writeValueAsString(notifySoapHeaderEnvelope.getNotifySoapHeader().getTimeStamp()));
            return notifySmsReceptionResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SendSmsResponse sendSms (SendSms sendSmsRequest, SoapHeaderElement soapHeaderElement) {
        try {
            log.info("inside notifySmsReception() endpoint");
            log.info("we are calling the soap service endpoint to send sms message");
            String string = objectMapper.writeValueAsString(sendSmsRequest);
            log.info("sendSmsRequest in soap endpoint is =============== {}", sendSmsRequest);
            log.info("sendSmsRequest in soap endpoint as string is =============== {}", string);
            SendSmsResponse sendSmsResponse = new SendSmsResponse();
            sendSmsResponse.setResult("202105141210518596656834514350");
            log.info("sendSmsResponse is {}", objectMapper.writeValueAsString(sendSmsResponse));
            return sendSmsResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }

    @Override
    public StartUSSDNotificationResponse startUssdNotification (StartUSSDNotification startUSSDNotificationRequest) {
        try {
            log.info("inside startUssdNotification() endpoint");
            log.info("we are calling the soap service endpoint to start ussd notification");
            String string = objectMapper.writeValueAsString(startUSSDNotificationRequest);
            log.info("startUSSDNotificationRequest in soap endpoint is =============== {}", startUSSDNotificationRequest);
            log.info("startUSSDNotificationRequest in soap endpoint as string is =============== {}", string);
            StartUSSDNotificationResponse startUSSDNotificationResponse = new StartUSSDNotificationResponse();
            log.info("startUSSDNotificationResponse is {}", objectMapper.writeValueAsString(startUSSDNotificationResponse));
            return startUSSDNotificationResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }

    @Override
    public NotifyUssdReceptionResponse notifyUssdReception (NotifyUssdReception notifyUssdReceptionRequest) {
        try {
            log.info("inside notifyUssdReception() endpoint");
            log.info("we are calling the soap service endpoint to notify ussd reception");
            String string = objectMapper.writeValueAsString(notifyUssdReceptionRequest);
            log.info("notifyUssdReceptionRequest in soap endpoint is =============== {}", notifyUssdReceptionRequest);
            log.info("notifyUssdReceptionRequest in soap endpoint as string is =============== {}", string);
            NotifyUssdReceptionResponse notifyUssdReceptionResponse = new NotifyUssdReceptionResponse();
            notifyUssdReceptionResponse.setResult("0");
            log.info("notifyUssdReceptionResponse is {}", objectMapper.writeValueAsString(notifyUssdReceptionResponse));
            return notifyUssdReceptionResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }

    @Override
    public NotifyUssdAbortResponse notifyUssdAbort (NotifyUssdAbort notifyUssdAbortRequest) {
        try {
            log.info("inside notifyUssdAbort() endpoint");
            log.info("we are calling the soap service endpoint to notify ussd abort");
            String string = objectMapper.writeValueAsString(notifyUssdAbortRequest);
            log.info("notifyUssdAbortRequest in soap endpoint is =============== {}", notifyUssdAbortRequest);
            log.info("notifyUssdAbortRequest in soap endpoint as string is =============== {}", string);
            NotifyUssdAbortResponse notifyUssdAbortResponse = new NotifyUssdAbortResponse();
            log.info("notifyUssdReceptionResponse is {}", objectMapper.writeValueAsString(notifyUssdAbortResponse));
            return notifyUssdAbortResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }

    @Override
    public SendUssdResponse sendUssd (SendUssd sendUssdRequest) {
        try {
            log.info("inside sendUssd() endpoint");
            log.info("we are calling the soap service endpoint to send ussd message");
            String string = objectMapper.writeValueAsString(sendUssdRequest);
            log.info("sendUssdRequest in soap endpoint is =============== {}", sendUssdRequest);
            log.info("sendUssdRequest in soap endpoint as string is =============== {}", string);
            SendUssdResponse sendUssdResponse = new SendUssdResponse();
            sendUssdResponse.setResult("0");
            log.info("sendUssdResponse is {}", objectMapper.writeValueAsString(sendUssdResponse));
            return sendUssdResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }

    @Override
    public SendUssdAbortResponse sendUssdAbort (SendUssdAbort sendUssdAbortRequest) {
        try {
            log.info("inside sendUssdAbort() endpoint");
            log.info("we are calling the soap service endpoint to send ussd abort message");
            String string = objectMapper.writeValueAsString(sendUssdAbortRequest);
            log.info("sendUssdAbortRequest in soap endpoint is =============== {}", sendUssdAbortRequest);
            log.info("sendUssdAbortRequest in soap endpoint as string is =============== {}", string);
            SendUssdAbortResponse sendUssdAbortResponse = new SendUssdAbortResponse();
            log.info("sendUssdAbortResponse is {}", objectMapper.writeValueAsString(sendUssdAbortResponse));
            return sendUssdAbortResponse;
        }catch (Exception e) {
            log.info("{}",e.getMessage());
        }
        return null;
    }
}
