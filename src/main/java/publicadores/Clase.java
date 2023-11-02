/**
 * Clase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Clase  implements java.io.Serializable {
    private publicadores.LocalDate fecha;

    private publicadores.LocalDate fechaReg;

    private publicadores.LocalTime hora;

    private java.lang.String img;

    private java.lang.String nombre;

    private publicadores.Profesor profesor;

    private publicadores.Registro[] registros;

    private java.lang.String url;

    public Clase() {
    }

    public Clase(
           publicadores.LocalDate fecha,
           publicadores.LocalDate fechaReg,
           publicadores.LocalTime hora,
           java.lang.String img,
           java.lang.String nombre,
           publicadores.Profesor profesor,
           publicadores.Registro[] registros,
           java.lang.String url) {
           this.fecha = fecha;
           this.fechaReg = fechaReg;
           this.hora = hora;
           this.img = img;
           this.nombre = nombre;
           this.profesor = profesor;
           this.registros = registros;
           this.url = url;
    }


    /**
     * Gets the fecha value for this Clase.
     * 
     * @return fecha
     */
    public publicadores.LocalDate getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this Clase.
     * 
     * @param fecha
     */
    public void setFecha(publicadores.LocalDate fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the fechaReg value for this Clase.
     * 
     * @return fechaReg
     */
    public publicadores.LocalDate getFechaReg() {
        return fechaReg;
    }


    /**
     * Sets the fechaReg value for this Clase.
     * 
     * @param fechaReg
     */
    public void setFechaReg(publicadores.LocalDate fechaReg) {
        this.fechaReg = fechaReg;
    }


    /**
     * Gets the hora value for this Clase.
     * 
     * @return hora
     */
    public publicadores.LocalTime getHora() {
        return hora;
    }


    /**
     * Sets the hora value for this Clase.
     * 
     * @param hora
     */
    public void setHora(publicadores.LocalTime hora) {
        this.hora = hora;
    }


    /**
     * Gets the img value for this Clase.
     * 
     * @return img
     */
    public java.lang.String getImg() {
        return img;
    }


    /**
     * Sets the img value for this Clase.
     * 
     * @param img
     */
    public void setImg(java.lang.String img) {
        this.img = img;
    }


    /**
     * Gets the nombre value for this Clase.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Clase.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the profesor value for this Clase.
     * 
     * @return profesor
     */
    public publicadores.Profesor getProfesor() {
        return profesor;
    }


    /**
     * Sets the profesor value for this Clase.
     * 
     * @param profesor
     */
    public void setProfesor(publicadores.Profesor profesor) {
        this.profesor = profesor;
    }


    /**
     * Gets the registros value for this Clase.
     * 
     * @return registros
     */
    public publicadores.Registro[] getRegistros() {
        return registros;
    }


    /**
     * Sets the registros value for this Clase.
     * 
     * @param registros
     */
    public void setRegistros(publicadores.Registro[] registros) {
        this.registros = registros;
    }

    public publicadores.Registro getRegistros(int i) {
        return this.registros[i];
    }

    public void setRegistros(int i, publicadores.Registro _value) {
        this.registros[i] = _value;
    }


    /**
     * Gets the url value for this Clase.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Clase.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Clase)) return false;
        Clase other = (Clase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.fechaReg==null && other.getFechaReg()==null) || 
             (this.fechaReg!=null &&
              this.fechaReg.equals(other.getFechaReg()))) &&
            ((this.hora==null && other.getHora()==null) || 
             (this.hora!=null &&
              this.hora.equals(other.getHora()))) &&
            ((this.img==null && other.getImg()==null) || 
             (this.img!=null &&
              this.img.equals(other.getImg()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.profesor==null && other.getProfesor()==null) || 
             (this.profesor!=null &&
              this.profesor.equals(other.getProfesor()))) &&
            ((this.registros==null && other.getRegistros()==null) || 
             (this.registros!=null &&
              java.util.Arrays.equals(this.registros, other.getRegistros()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
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
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFechaReg() != null) {
            _hashCode += getFechaReg().hashCode();
        }
        if (getHora() != null) {
            _hashCode += getHora().hashCode();
        }
        if (getImg() != null) {
            _hashCode += getImg().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getProfesor() != null) {
            _hashCode += getProfesor().hashCode();
        }
        if (getRegistros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegistros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegistros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Clase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "clase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "localDate"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("hora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "localTime"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profesor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profesor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "profesor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "registro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
