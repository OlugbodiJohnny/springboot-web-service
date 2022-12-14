//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.28 at 12:57:21 AM WAT 
//


package com.johnny.webservice.schema.osg.ussd.notification_manager.v1_0.local;

import com.johnny.webservice.schema.parlayx.common.v2_1.SimpleReference;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for startUSSDNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="startUSSDNotification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reference" type="{http://www.csapi.org/schema/parlayx/common/v2_1}SimpleReference"/&gt;
 *         &lt;element name="ussdServiceActivationNumber" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element name="criteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "startUSSDNotification", propOrder = {
    "reference",
    "ussdServiceActivationNumber",
    "criteria"
})
public class StartUSSDNotification {

    @XmlElement(required = true)
    protected SimpleReference reference;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String ussdServiceActivationNumber;
    protected String criteria;

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleReference }
     *     
     */
    public SimpleReference getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleReference }
     *     
     */
    public void setReference(SimpleReference value) {
        this.reference = value;
    }

    /**
     * Gets the value of the ussdServiceActivationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUssdServiceActivationNumber() {
        return ussdServiceActivationNumber;
    }

    /**
     * Sets the value of the ussdServiceActivationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUssdServiceActivationNumber(String value) {
        this.ussdServiceActivationNumber = value;
    }

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteria(String value) {
        this.criteria = value;
    }

}
