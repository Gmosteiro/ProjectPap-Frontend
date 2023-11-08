/**
 * ControladorPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublish extends java.rmi.Remote {
    public publicadores.InstitucionDeportiva getInstitucionesByName(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.ActividadDeportiva obtenerActividadPorNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.ArrayList obtenerRankingDeClases() throws java.rmi.RemoteException;
    public publicadores.ArrayList obtenerRankingDeActividades() throws java.rmi.RemoteException;
    public void addClase(java.lang.String arg0, publicadores.LocalDate arg1, publicadores.LocalTime arg2, java.lang.String arg3, publicadores.LocalDate arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException;
    public publicadores.ArrayList getInstituciones() throws java.rmi.RemoteException;
    public publicadores.ArrayList obtenerClasesPorActividad(publicadores.ActividadDeportiva arg0) throws java.rmi.RemoteException;
    public boolean addRegistroDictadoWeb(java.lang.String arg0, java.lang.String arg1, publicadores.LocalDate arg2) throws java.rmi.RemoteException;
    public publicadores.ArrayList getClasesByActividad(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.Clase obtenerClasePorNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean modificarUsuarioWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, publicadores.LocalDate arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public publicadores.ArrayList getActividadesByProfe(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean eliminarRegistroDeClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public publicadores.Clase getClaseByNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.Socio getSocio(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.ArrayList getClasesByUser(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean validateDataWeb(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean crearRegistro(publicadores.Socio arg0, publicadores.Clase arg1) throws java.rmi.RemoteException;
    public publicadores.ArrayList getSociosByClase(publicadores.Clase arg0) throws java.rmi.RemoteException;
    public publicadores.Sesion iniciarSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean existenElementos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
}
