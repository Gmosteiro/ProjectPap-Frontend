/**
 * ActividadDeportiva.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;
import java.time.LocalDate;

public class ActividadDeportiva implements java.io.Serializable {
    private float costo;

    private java.lang.String descripcion;

    private int duracion;

    private java.time.LocalDate fechaReg;

    private java.lang.String img;

    private java.lang.String nombre;

    public ActividadDeportiva() {
    }

    public ActividadDeportiva(
            float costo,
            java.lang.String descripcion,
            int duracion,
            java.time.LocalDate fechaReg,
            java.lang.String img,
            java.lang.String nombre) {
        this.costo = costo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaReg = fechaReg;
        this.img = img;
        this.nombre = nombre;
    }

    /**
     * Gets the costo value for this ActividadDeportiva.
     * 
     * @return costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Sets the costo value for this ActividadDeportiva.
     * 
     * @param costo
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Gets the descripcion value for this ActividadDeportiva.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion value for this ActividadDeportiva.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets the duracion value for this ActividadDeportiva.
     * 
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets the duracion value for this ActividadDeportiva.
     * 
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Gets the fechaReg value for this ActividadDeportiva.
     * 
     * @return fechaReg
     */
    public java.time.LocalDate getFechaReg() {
        return fechaReg;
    }

    /**
     * Sets the fechaReg value for this ActividadDeportiva.
     * 
     * @param fechaReg
     */
    public void setFechaReg(java.time.LocalDate fechaReg) {
        this.fechaReg = fechaReg;
    }

    /**
     * Gets the img value for this ActividadDeportiva.
     * 
     * @return img
     */
    public java.lang.String getImg() {
        return img;
    }

    /**
     * Sets the img value for this ActividadDeportiva.
     * 
     * @param img
     */
    public void setImg(java.lang.String img) {
        this.img = img;
    }

    /**
     * Gets the nombre value for this ActividadDeportiva.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre value for this ActividadDeportiva.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ActividadDeportiva))
            return false;
        ActividadDeportiva other = (ActividadDeportiva) obj;
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.costo == other.getCosto() &&
                ((this.descripcion == null && other.getDescripcion() == null) ||
                        (this.descripcion != null &&
                                this.descripcion.equals(other.getDescripcion())))
                &&
                this.duracion == other.getDuracion() &&
                ((this.fechaReg == null && other.getFechaReg() == null) ||
                        (this.fechaReg != null &&
                                this.fechaReg.equals(other.getFechaReg())))
                &&
                ((this.img == null && other.getImg() == null) ||
                        (this.img != null &&
                                this.img.equals(other.getImg())))
                &&
                ((this.nombre == null && other.getNombre() == null) ||
                        (this.nombre != null &&
                                this.nombre.equals(other.getNombre())));
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
        _hashCode += new Float(getCosto()).hashCode();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getDuracion();
        if (getFechaReg() != null) {
            _hashCode += getFechaReg().hashCode();
        }
        if (getImg() != null) {
            _hashCode += getImg().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            ActividadDeportiva.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "actividadDeportiva"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaReg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaReg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "localDate"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("img");
        elemField.setXmlName(new javax.xml.namespace.QName("", "img"));
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
