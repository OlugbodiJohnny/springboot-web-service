//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.28 at 12:57:21 AM WAT 
//


package com.johnny.webservice.schema.parlayx.data.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="notifySPURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="operationTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subscriptionValidTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subscriptionAddtionalInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductDetail", propOrder = {
    "notifySPURL",
    "operationTime",
    "subscriptionValidTime",
    "subscriptionAddtionalInfo"
})
public class ProductDetail {

    @XmlElement(required = true)
    protected String notifySPURL;
    protected String operationTime;
    protected String subscriptionValidTime;
    protected String subscriptionAddtionalInfo;

    /**
     * Gets the value of the notifySPURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotifySPURL() {
        return notifySPURL;
    }

    /**
     * Sets the value of the notifySPURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotifySPURL(String value) {
        this.notifySPURL = value;
    }

    /**
     * Gets the value of the operationTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationTime() {
        return operationTime;
    }

    /**
     * Sets the value of the operationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationTime(String value) {
        this.operationTime = value;
    }

    /**
     * Gets the value of the subscriptionValidTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionValidTime() {
        return subscriptionValidTime;
    }

    /**
     * Sets the value of the subscriptionValidTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionValidTime(String value) {
        this.subscriptionValidTime = value;
    }

    /**
     * Gets the value of the subscriptionAddtionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionAddtionalInfo() {
        return subscriptionAddtionalInfo;
    }

    /**
     * Sets the value of the subscriptionAddtionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionAddtionalInfo(String value) {
        this.subscriptionAddtionalInfo = value;
    }

}