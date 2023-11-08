/**
 * Profesor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Profesor extends publicadores.Usuario implements java.io.Serializable {
    private String biografia;

    private String descripcion;

    private publicadores.InstitucionDeportiva institucion;

    private String sitioWeb;

    public Profesor() {
    }

    public Profesor(
            String apellido,
            String contrasena,
            String email,
            java.time.LocalDate fechaNac,
            String img,
            String nickname,
            String nombre,
            String biografia,
            String descripcion,
            publicadores.InstitucionDeportiva institucion,
            String sitioWeb) {
        super(
                apellido,
                contrasena,
                email,
                fechaNac,
                img,
                nickname,
                nombre);
        this.biografia = biografia;
        this.descripcion = descripcion;
        this.institucion = institucion;
        this.sitioWeb = sitioWeb;
    }

    /**
     * Gets the biografia value for this Profesor.
     * 
     * @return biografia
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Sets the biografia value for this Profesor.
     * 
     * @param biografia
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * Gets the descripcion value for this Profesor.
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion value for this Profesor.
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets the institucion value for this Profesor.
     * 
     * @return institucion
     */
    public publicadores.InstitucionDeportiva getInstitucion() {
        return institucion;
    }

    /**
     * Sets the institucion value for this Profesor.
     * 
     * @param institucion
     */
    public void setInstitucion(publicadores.InstitucionDeportiva institucion) {
        this.institucion = institucion;
    }

    /**
     * Gets the sitioWeb value for this Profesor.
     * 
     * @return sitioWeb
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    /**
     * Sets the sitioWeb value for this Profesor.
     * 
     * @param sitioWeb
     */
    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Profesor))
            return false;
        Profesor other = (Profesor) obj;
        if (this == obj)
            return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) &&
                ((this.biografia == null && other.getBiografia() == null) ||
                        (this.biografia != null &&
                                this.biografia.equals(other.getBiografia())))
                &&
                ((this.descripcion == null && other.getDescripcion() == null) ||
                        (this.descripcion != null &&
                                this.descripcion.equals(other.getDescripcion())))
                &&
                ((this.institucion == null && other.getInstitucion() == null) ||
                        (this.institucion != null &&
                                this.institucion.equals(other.getInstitucion())))
                &&
                ((this.sitioWeb == null && other.getSitioWeb() == null) ||
                        (this.sitioWeb != null &&
                                this.sitioWeb.equals(other.getSitioWeb())));
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
        if (getBiografia() != null) {
            _hashCode += getBiografia().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getInstitucion() != null) {
            _hashCode += getInstitucion().hashCode();
        }
        if (getSitioWeb() != null) {
            _hashCode += getSitioWeb().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            Profesor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "profesor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("biografia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "biografia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("institucion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "institucion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "institucionDeportiva"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sitioWeb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sitioWeb"));
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
