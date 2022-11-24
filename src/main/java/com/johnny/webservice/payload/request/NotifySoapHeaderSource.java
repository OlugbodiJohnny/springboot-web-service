package com.johnny.webservice.payload.request;

import lombok.*;

import javax.xml.bind.annotation.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@ToString
@XmlRootElement(name = "NotifySOAPHeader", namespace = "http://www.huawei.com.cn/schema/common/v2_1")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifySoapHeaderSource")
public class NotifySoapHeaderSource {

    @XmlElement
    private String xmlnsNs1;
    @XmlElement(name = "spRevId")
    private String spRevID;
    @XmlElement
    private String spRevPassword;
    @XmlElement
    private String spID;
    @XmlElement()
    private String serviceID;
    @XmlElement
    private String traceUniqueID;
    @XmlElement
    private String timeStamp;
    @XmlElement
    private String operatorID;
    @XmlElement
    private String linkId;
    @XmlElement
    private String node;
    @XmlElement
    private String systemId;
    @XmlElement
    private String empty;

    public String getEmpty() {
        return empty;
    }

    public void setEmpty(String empty) {
        this.empty = empty;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getXmlnsNs1() {
        return xmlnsNs1;
    }

    public void setXmlnsNs1(String xmlnsNs1) {
        this.xmlnsNs1 = xmlnsNs1;
    }

    public String getSpRevID() {
        return spRevID;
    }

    public void setSpRevID(String spRevID) {
        this.spRevID = spRevID;
    }

    public String getSpRevPassword() {
        return spRevPassword;
    }

    public void setSpRevPassword(String spRevPassword) {
        this.spRevPassword = spRevPassword;
    }

    public String getSpID() {
        return spID;
    }

    public void setSpID(String spID) {
        this.spID = spID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getTraceUniqueID() {
        return traceUniqueID;
    }

    public void setTraceUniqueID(String traceUniqueID) {
        this.traceUniqueID = traceUniqueID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }
}
