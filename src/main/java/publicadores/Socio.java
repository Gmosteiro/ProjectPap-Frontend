/**
 * Socio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

import java.util.ArrayList;

public class Socio extends publicadores.Usuario implements java.io.Serializable {
    private ArrayList<publicadores.Registro> clasesRegistradas;

    public Socio() {
    }

    public Socio(
            java.lang.String apellido,
            java.lang.String contrasena,
            java.lang.String email,
            java.time.LocalDate fechaNac,
            java.lang.String img,
            java.lang.String nickname,
            java.lang.String nombre,
            ArrayList<publicadores.Registro> clasesRegistradas) {
        super(
                apellido,
                contrasena,
                email,
                fechaNac,
                img,
                nickname,
                nombre);
        this.clasesRegistradas = clasesRegistradas;
    }

    /**
     * Gets the clasesRegistradas value for this Socio.
     * 
     * @return clasesRegistradas
     */
    public ArrayList<publicadores.Registro> getClasesRegistradas() {
        return clasesRegistradas;
    }

    /**
     * Sets the clasesRegistradas value for this Socio.
     * 
     * @param clasesRegistradas
     */
    public void setClasesRegistradas(ArrayList<publicadores.Registro> clasesRegistradas) {
        this.clasesRegistradas = clasesRegistradas;
    }

    public publicadores.Registro getClasesRegistradas(int i) {
        return this.clasesRegistradas.get(i);
    }

    public void setClasesRegistradas(int i, publicadores.Registro _value) {
        this.clasesRegistradas.set(i, _value);
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Socio))
            return false;
        Socio other = (Socio) obj;
        if (this == obj)
            return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
                ((this.clasesRegistradas == null && other.getClasesRegistradas() == null) ||
                        (this.clasesRegistradas != null &&
                                this.clasesRegistradas == other.getClasesRegistradas()));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getClasesRegistradas() != null) {
            for (int i = 0; i < java.lang.reflect.Array.getLength(getClasesRegistradas()); i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClasesRegistradas(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(Socio.class,
            true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "socio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clasesRegistradas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clasesRegistradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "registro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanSerializer(
                _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanDeserializer(
                _javaType, _xmlType, typeDesc);
    }

}
