//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.28 at 12:57:21 AM WAT 
//


package com.johnny.webservice.schema.parlayx.sms.notification_manager.v2_3.local;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.csapi.schema.parlayx.sms.notification_manager.v2_3.local package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StartSmsNotification_QNAME = new QName("http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", "startSmsNotification");
    private final static QName _StartSmsNotificationResponse_QNAME = new QName("http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", "startSmsNotificationResponse");
    private final static QName _StopSmsNotification_QNAME = new QName("http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", "stopSmsNotification");
    private final static QName _StopSmsNotificationResponse_QNAME = new QName("http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", "stopSmsNotificationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.csapi.schema.parlayx.sms.notification_manager.v2_3.local
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StartSmsNotification }
     * 
     */
    public StartSmsNotification createStartSmsNotification() {
        return new StartSmsNotification();
    }

    /**
     * Create an instance of {@link StartSmsNotificationResponse }
     * 
     */
    public StartSmsNotificationResponse createStartSmsNotificationResponse() {
        return new StartSmsNotificationResponse();
    }

    /**
     * Create an instance of {@link StopSmsNotification }
     * 
     */
    public StopSmsNotification createStopSmsNotification() {
        return new StopSmsNotification();
    }

    /**
     * Create an instance of {@link StopSmsNotificationResponse }
     * 
     */
    public StopSmsNotificationResponse createStopSmsNotificationResponse() {
        return new StopSmsNotificationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartSmsNotification }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StartSmsNotification }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", name = "startSmsNotification")
    public JAXBElement<StartSmsNotification> createStartSmsNotification(StartSmsNotification value) {
        return new JAXBElement<StartSmsNotification>(_StartSmsNotification_QNAME, StartSmsNotification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartSmsNotificationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StartSmsNotificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", name = "startSmsNotificationResponse")
    public JAXBElement<StartSmsNotificationResponse> createStartSmsNotificationResponse(StartSmsNotificationResponse value) {
        return new JAXBElement<StartSmsNotificationResponse>(_StartSmsNotificationResponse_QNAME, StartSmsNotificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopSmsNotification }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StopSmsNotification }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", name = "stopSmsNotification")
    public JAXBElement<StopSmsNotification> createStopSmsNotification(StopSmsNotification value) {
        return new JAXBElement<StopSmsNotification>(_StopSmsNotification_QNAME, StopSmsNotification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopSmsNotificationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StopSmsNotificationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.csapi.org/schema/parlayx/sms/notification_manager/v2_3/local", name = "stopSmsNotificationResponse")
    public JAXBElement<StopSmsNotificationResponse> createStopSmsNotificationResponse(StopSmsNotificationResponse value) {
        return new JAXBElement<StopSmsNotificationResponse>(_StopSmsNotificationResponse_QNAME, StopSmsNotificationResponse.class, null, value);
    }

}
