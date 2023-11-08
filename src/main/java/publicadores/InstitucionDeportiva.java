/**
 * InstitucionDeportiva.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

import java.lang.String;
import java.util.ArrayList;

public class InstitucionDeportiva implements java.io.Serializable {

    private ArrayList<ActividadDeportiva> actividades;

    private String descripcion;

    private String nombre;

    private String url;

    public InstitucionDeportiva() {
    }

    public InstitucionDeportiva(
            ArrayList<ActividadDeportiva> actividades,
            String descripcion,
            String nombre,
            String url) {
        this.actividades = actividades;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.url = url;
    }

    /**
     * Gets the actividades value for this InstitucionDeportiva.
     * 
     * @return actividades
     */
    public ArrayList<ActividadDeportiva> getActividades() {
        return actividades;
    }

    /**
     * Sets the actividades value for this InstitucionDeportiva.
     * 
     * @param actividades
     */
    public void setActividades(ArrayList<ActividadDeportiva> actividades) {
        this.actividades = actividades;
    }

    public publicadores.ActividadDeportiva getActividades(int i) {
        return this.actividades.get(i);
    }

    public void setActividades(int i, publicadores.ActividadDeportiva _value) {
        this.actividades.set(i, _value);
    }

    /**
     * Gets the descripcion value for this InstitucionDeportiva.
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion value for this InstitucionDeportiva.
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets the nombre value for this InstitucionDeportiva.
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre value for this InstitucionDeportiva.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the url value for this InstitucionDeportiva.
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url value for this InstitucionDeportiva.
     * 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InstitucionDeportiva))
            return false;
        InstitucionDeportiva other = (InstitucionDeportiva) obj;
        if (this == obj)
            return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.actividades == null && other.getActividades() == null) ||
                        (this.actividades != null &&
                                this.actividades == other.getActividades()))
                &&
                ((this.descripcion == null && other.getDescripcion() == null) ||
                        (this.descripcion != null &&
                                this.descripcion.equals(other.getDescripcion())))
                &&
                ((this.nombre == null && other.getNombre() == null) ||
                        (this.nombre != null &&
                                this.nombre.equals(other.getNombre())))
                &&
                ((this.url == null && other.getUrl() == null) ||
                        (this.url != null &&
                                this.url.equals(other.getUrl())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getActividades() != null) {
            for (int i = 0; i < java.lang.reflect.Array.getLength(getActividades()); i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActividades(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            InstitucionDeportiva.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "institucionDeportiva"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actividades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "actividadDeportiva"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
            String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanSerializer(
                _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanDeserializer(
                _javaType, _xmlType, typeDesc);
    }

}
