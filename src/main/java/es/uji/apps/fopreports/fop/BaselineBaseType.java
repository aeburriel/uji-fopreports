//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.13 at 06:06:38 PM CEST 
//


package es.uji.apps.fopreports.fop;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseline_base_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="baseline_base_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="baseline"/>
 *     &lt;enumeration value="sub"/>
 *     &lt;enumeration value="super"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "baseline_base_Type")
@XmlEnum
public enum BaselineBaseType {

    @XmlEnumValue("baseline")
    BASELINE("baseline"),
    @XmlEnumValue("sub")
    SUB("sub"),
    @XmlEnumValue("super")
    SUPER("super");
    private final String value;

    BaselineBaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaselineBaseType fromValue(String v) {
        for (BaselineBaseType c: BaselineBaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
