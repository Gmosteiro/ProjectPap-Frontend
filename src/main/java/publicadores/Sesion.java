/**
 * Sesion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Sesion implements java.io.Serializable {
    private String apellido;

    private String email;

    private String fechaNacimiento;

    private String nickname;

    private String nombre;

    private String profileImageBase64;

    private String userType;

    public Sesion() {
    }

    public Sesion(
            String apellido,
            String email,
            String fechaNacimiento,
            String nickname,
            String nombre,
            String profileImageBase64,
            String userType) {
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nickname = nickname;
        this.nombre = nombre;
        this.profileImageBase64 = profileImageBase64;
        this.userType = userType;
    }

    /**
     * Gets the apellido value for this Sesion.
     * 
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sets the apellido value for this Sesion.
     * 
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Gets the email value for this Sesion.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email value for this Sesion.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the fechaNacimiento value for this Sesion.
     * 
     * @return fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets the fechaNacimiento value for this Sesion.
     * 
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Gets the nickname value for this Sesion.
     * 
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname value for this Sesion.
     * 
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the nombre value for this Sesion.
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre value for this Sesion.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the profileImageBase64 value for this Sesion.
     * 
     * @return profileImageBase64
     */
    public String getProfileImageBase64() {
        return profileImageBase64;
    }

    /**
     * Sets the profileImageBase64 value for this Sesion.
     * 
     * @param profileImageBase64
     */
    public void setProfileImageBase64(String profileImageBase64) {
        this.profileImageBase64 = profileImageBase64;
    }

    /**
     * Gets the userType value for this Sesion.
     * 
     * @return userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the userType value for this Sesion.
     * 
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sesion))
            return false;
        Sesion other = (Sesion) obj;
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
                ((this.email == null && other.getEmail() == null) ||
                        (this.email != null &&
                                this.email.equals(other.getEmail())))
                &&
                ((this.fechaNacimiento == null && other.getFechaNacimiento() == null) ||
                        (this.fechaNacimiento != null &&
                                this.fechaNacimiento.equals(other.getFechaNacimiento())))
                &&
                ((this.nickname == null && other.getNickname() == null) ||
                        (this.nickname != null &&
                                this.nickname.equals(other.getNickname())))
                &&
                ((this.nombre == null && other.getNombre() == null) ||
                        (this.nombre != null &&
                                this.nombre.equals(other.getNombre())))
                &&
                ((this.profileImageBase64 == null && other.getProfileImageBase64() == null) ||
                        (this.profileImageBase64 != null &&
                                this.profileImageBase64.equals(other.getProfileImageBase64())))
                &&
                ((this.userType == null && other.getUserType() == null) ||
                        (this.userType != null &&
                                this.userType.equals(other.getUserType())));
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFechaNacimiento() != null) {
            _hashCode += getFechaNacimiento().hashCode();
        }
        if (getNickname() != null) {
            _hashCode += getNickname().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getProfileImageBase64() != null) {
            _hashCode += getProfileImageBase64().hashCode();
        }
        if (getUserType() != null) {
            _hashCode += getUserType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            Sesion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "sesion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellido"));
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
        elemField.setFieldName("fechaNacimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaNacimiento"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profileImageBase64");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profileImageBase64"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userType"));
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
