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
 * <p>Java class for show_destination_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="show_destination_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="replace"/>
 *     &lt;enumeration value="new"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "show_destination_Type")
@XmlEnum
public enum ShowDestinationType {

    @XmlEnumValue("replace")
    REPLACE("replace"),
    @XmlEnumValue("new")
    NEW("new");
    private final String value;

    ShowDestinationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ShowDestinationType fromValue(String v) {
        for (ShowDestinationType c: ShowDestinationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
