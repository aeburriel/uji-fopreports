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
 * <p>Java class for scaling_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="scaling_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="uniform"/>
 *     &lt;enumeration value="non-uniform"/>
 *     &lt;enumeration value="inherit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "scaling_Type")
@XmlEnum
public enum ScalingType {

    @XmlEnumValue("uniform")
    UNIFORM("uniform"),
    @XmlEnumValue("non-uniform")
    NON_UNIFORM("non-uniform"),
    @XmlEnumValue("inherit")
    INHERIT("inherit");
    private final String value;

    ScalingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScalingType fromValue(String v) {
        for (ScalingType c: ScalingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
