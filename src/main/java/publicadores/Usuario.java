/**
 * Usuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public abstract class Usuario implements java.io.Serializable {
    private java.lang.String apellido;

    private java.lang.String contrasena;

    private java.lang.String email;

    private java.time.LocalDate fechaNac;

    private java.lang.String img;

    private java.lang.String nickname;

    private java.lang.String nombre;

    public Usuario() {
    }

    public Usuario(
            java.lang.String apellido,
            java.lang.String contrasena,
            java.lang.String email,
            java.time.LocalDate fechaNac,
            java.lang.String img,
            java.lang.String nickname,
            java.lang.String nombre) {
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaNac = fechaNac;
        this.img = img;
        this.nickname = nickname;
        this.nombre = nombre;
    }

    /**
     * Gets the apellido value for this Usuario.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }

    /**
     * Sets the apellido value for this Usuario.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }

    /**
     * Gets the contrasena value for this Usuario.
     * 
     * @return contrasena
     */
    public java.lang.String getContrasena() {
        return contrasena;
    }

    /**
     * Sets the contrasena value for this Usuario.
     * 
     * @param contrasena
     */
    public void setContrasena(java.lang.String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Gets the email value for this Usuario.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }

    /**
     * Sets the email value for this Usuario.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    /**
     * Gets the fechaNac value for this Usuario.
     * 
     * @return fechaNac
     */
    public java.time.LocalDate getFechaNac() {
        return fechaNac;
    }

    /**
     * Sets the fechaNac value for this Usuario.
     * 
     * @param fechaNac
     */
    public void setFechaNac(java.time.LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Gets the img value for this Usuario.
     * 
     * @return img
     */
    public java.lang.String getImg() {
        return img;
    }

    /**
     * Sets the img value for this Usuario.
     * 
     * @param img
     */
    public void setImg(java.lang.String img) {
        this.img = img;
    }

    /**
     * Gets the nickname value for this Usuario.
     * 
     * @return nickname
     */
    public java.lang.String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname value for this Usuario.
     * 
     * @param nickname
     */
    public void setNickname(java.lang.String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the nombre value for this Usuario.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre value for this Usuario.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Usuario))
            return false;
        Usuario other = (Usuario) obj;
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
                ((this.apellido == null && other.getApellido() == null) ||
                        (this.apellido != null &&
                                this.apellido.equals(other.getApellido())))
                &&
                ((this.contrasena == null && other.getContrasena() == null) ||
                        (this.contrasena != null &&
                                this.contrasena.equals(other.getContrasena())))
                &&
                ((this.email == null && other.getEmail() == null) ||
                        (this.email != null &&
                                this.email.equals(other.getEmail())))
                &&
                ((this.fechaNac == null && other.getFechaNac() == null) ||
                        (this.fechaNac != null &&
                                this.fechaNac.equals(other.getFechaNac())))
                &&
                ((this.img == null && other.getImg() == null) ||
                        (this.img != null &&
                                this.img.equals(other.getImg())))
                &&
                ((this.nickname == null && other.getNickname() == null) ||
                        (this.nickname != null &&
                                this.nickname.equals(other.getNickname())))
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
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getContrasena() != null) {
            _hashCode += getContrasena().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFechaNac() != null) {
            _hashCode += getFechaNac().hashCode();
        }
        if (getImg() != null) {
            _hashCode += getImg().hashCode();
        }
        if (getNickname() != null) {
            _hashCode += getNickname().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            Usuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "usuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrasena");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrasena"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaNac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaNac"));
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
        elemField.setFieldName("nickname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nickname"));
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
