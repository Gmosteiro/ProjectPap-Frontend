
package publicadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clase" type="{http://publicadores/}clase" minOccurs="0"/&gt;
 *         &lt;element name="fechaReg" type="{http://publicadores/}localDate" minOccurs="0"/&gt;
 *         &lt;element name="socio" type="{http://publicadores/}socio" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registro", propOrder = {
    "clase",
    "fechaReg",
    "socio"
})
public class Registro {

    protected Clase clase;
    protected LocalDate fechaReg;
    protected Socio socio;

    /**
     * Gets the value of the clase property.
     * 
     * @return
     *     possible object is
     *     {@link Clase }
     *     
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Sets the value of the clase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clase }
     *     
     */
    public void setClase(Clase value) {
        this.clase = value;
    }

    /**
     * Gets the value of the fechaReg property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaReg() {
        return fechaReg;
    }

    /**
     * Sets the value of the fechaReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaReg(LocalDate value) {
        this.fechaReg = value;
    }

    /**
     * Gets the value of the socio property.
     * 
     * @return
     *     possible object is
     *     {@link Socio }
     *     
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * Sets the value of the socio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Socio }
     *     
     */
    public void setSocio(Socio value) {
        this.socio = value;
    }

}
