//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.01.11 at 11:33:52 PM MSK 
//


package org.example.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ping" type="{http://org/example/secondservicesoap/catalog}PingGetResponseDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ping"
})
@XmlRootElement(name = "getPingResponse")
public class GetPingResponse {

    @XmlElement(required = true)
    protected PingGetResponseDto ping;

    /**
     * Gets the value of the ping property.
     * 
     * @return
     *     possible object is
     *     {@link PingGetResponseDto }
     *     
     */
    public PingGetResponseDto getPing() {
        return ping;
    }

    /**
     * Sets the value of the ping property.
     * 
     * @param value
     *     allowed object is
     *     {@link PingGetResponseDto }
     *     
     */
    public void setPing(PingGetResponseDto value) {
        this.ping = value;
    }

}
