/**
 * ControladorPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublish extends java.rmi.Remote {
    public publicadores.DtInstitucion getInstitucionesByName(java.lang.String arg0) throws java.rmi.RemoteException;
    public void addClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException;
    public boolean addRegistroDictadoWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva obtenerActividadPorNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva[] getActividadesByInstitucion(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.Sesion iniciarSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva[] getActividadesByProfe(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean modificarUsuarioWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public boolean validateDataWeb(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean eliminarRegistroDeClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public boolean existenElementos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public publicadores.DtClase[] getClasesByActividad(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.LocalDate stringToLocalDate(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.LocalTime stringToLocalTime(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean crearRegistro(publicadores.DtUsuario arg0, publicadores.DtClase arg1) throws java.rmi.RemoteException;
    public publicadores.DtUsuario[] getSociosByClase(publicadores.DtClase arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase[] obtenerClasesPorActividad(publicadores.DtActividadDeportiva arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase getClaseByNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase[] getClasesByUser(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase obtenerClasePorNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva[] obtenerRankingDeActividades() throws java.rmi.RemoteException;
    public publicadores.DtClase[] obtenerRankingDeClases() throws java.rmi.RemoteException;
    public publicadores.DtInstitucion[] getInstituciones() throws java.rmi.RemoteException;
    public publicadores.DtUsuario getSocio(java.lang.String arg0) throws java.rmi.RemoteException;
}
