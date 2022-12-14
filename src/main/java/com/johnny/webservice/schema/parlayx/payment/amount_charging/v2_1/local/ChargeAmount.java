//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.28 at 12:57:21 AM WAT 
//


package com.johnny.webservice.schema.parlayx.payment.amount_charging.v2_1.local;

import com.johnny.webservice.schema.parlayx.common.v2_1.ChargingInformation;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for chargeAmount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chargeAmount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="endUserIdentifier" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element name="charge" type="{http://www.csapi.org/schema/parlayx/common/v2_1}ChargingInformation"/&gt;
 *         &lt;element name="referenceCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeAmount", propOrder = {
    "endUserIdentifier",
    "charge",
    "referenceCode"
})
public class ChargeAmount {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String endUserIdentifier;
    @XmlElement(required = true)
    protected ChargingInformation charge;
    @XmlElement(required = true)
    protected String referenceCode;

    /**
     * Gets the value of the endUserIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndUserIdentifier() {
        return endUserIdentifier;
    }

    /**
     * Sets the value of the endUserIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndUserIdentifier(String value) {
        this.endUserIdentifier = value;
    }

    /**
     * Gets the value of the charge property.
     * 
     * @return
     *     possible object is
     *     {@link ChargingInformation }
     *     
     */
    public ChargingInformation getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargingInformation }
     *     
     */
    public void setCharge(ChargingInformation value) {
        this.charge = value;
    }

    /**
     * Gets the value of the referenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Sets the value of the referenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCode(String value) {
        this.referenceCode = value;
    }

}
