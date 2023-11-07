/**
 * ControladorPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublish extends java.rmi.Remote {
    public java.util.ArrayList getInstituciones() throws java.rmi.RemoteException;

    public java.util.ArrayList obtenerRankingDeActividades() throws java.rmi.RemoteException;

    public void addClase(java.lang.String arg0, java.time.LocalDate arg1, java.time.LocalTime arg2,
            java.lang.String arg3, java.time.LocalDate arg4, java.lang.String arg5, java.lang.String arg6,
            java.lang.String arg7) throws java.rmi.RemoteException;

    public publicadores.InstitucionDeportiva getInstitucionesByName(java.lang.String arg0)
            throws java.rmi.RemoteException;

    public publicadores.ActividadDeportiva obtenerActividadPorNombre(java.lang.String arg0)
            throws java.rmi.RemoteException;

    public java.util.ArrayList obtenerRankingDeClases() throws java.rmi.RemoteException;

    public boolean eliminarRegistroDeClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
            java.lang.String arg3) throws java.rmi.RemoteException;

    public java.util.ArrayList obtenerClasesPorActividad(publicadores.ActividadDeportiva arg0)
            throws java.rmi.RemoteException;

    public boolean modificarUsuarioWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
            java.time.LocalDate arg3, java.lang.String arg4) throws java.rmi.RemoteException;

    public java.util.ArrayList getClasesByActividad(java.lang.String arg0) throws java.rmi.RemoteException;

    public boolean addRegistroDictadoWeb(java.lang.String arg0, java.lang.String arg1, java.time.LocalDate arg2)
            throws java.rmi.RemoteException;

    public publicadores.Clase obtenerClasePorNombre(java.lang.String arg0) throws java.rmi.RemoteException;

    public java.util.ArrayList getActividadesByProfe(java.lang.String arg0) throws java.rmi.RemoteException;

    public boolean crearRegistro(publicadores.Socio arg0, publicadores.Clase arg1) throws java.rmi.RemoteException;

    public boolean validateDataWeb(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;

    public java.util.ArrayList getSociosByClase(publicadores.Clase arg0) throws java.rmi.RemoteException;

    public publicadores.Clase getClaseByNombre(java.lang.String arg0) throws java.rmi.RemoteException;

    public boolean existenElementos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2,
            java.lang.String arg3) throws java.rmi.RemoteException;

    public publicadores.Sesion iniciarSesion(java.lang.String arg0, java.lang.String arg1)
            throws java.rmi.RemoteException;

    public java.util.ArrayList getClasesByUser(java.lang.String arg0) throws java.rmi.RemoteException;

    public publicadores.Socio getSocio(java.lang.String arg0) throws java.rmi.RemoteException;
}
