//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.10.12 at 11:28:48 AM CEST 
//


package es.uji.apps.fopreports.fop;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vertical_position_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="vertical_position_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="top"/>
 *     &lt;enumeration value="center"/>
 *     &lt;enumeration value="bottom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "vertical_position_Type")
@XmlEnum
public enum VerticalPositionType {

    @XmlEnumValue("top")
    TOP("top"),
    @XmlEnumValue("center")
    CENTER("center"),
    @XmlEnumValue("bottom")
    BOTTOM("bottom");
    private final String value;

    VerticalPositionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VerticalPositionType fromValue(String v) {
        for (VerticalPositionType c: VerticalPositionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
