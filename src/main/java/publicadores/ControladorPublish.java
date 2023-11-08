package publicadores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ControladorPublish extends Remote {
        InstitucionDeportiva getInstitucionesByName(String nombre) throws RemoteException;

        ActividadDeportiva obtenerActividadPorNombre(String nombreActividad) throws RemoteException;

        ArrayList<Clase> obtenerRankingDeClases() throws RemoteException;

        ArrayList<ActividadDeportiva> obtenerRankingDeActividades() throws RemoteException;

        void addClase(String nombre, LocalDate fecha, LocalTime hora, String url, LocalDate fechaReg,
                        String nombreProfesor, String img, String actividad) throws RemoteException;

        ArrayList<InstitucionDeportiva> getInstituciones() throws RemoteException;

        ArrayList<Clase> obtenerClasesPorActividad(ActividadDeportiva actividad) throws RemoteException;

        boolean addRegistroDictadoWeb(String nicknameSocio, String nombreClase, LocalDate fechaReg)
                        throws RemoteException;

        ArrayList<Clase> getClasesByActividad(String nombreActividad) throws RemoteException;

        Clase obtenerClasePorNombre(String nombreClase) throws RemoteException;

        boolean modificarUsuarioWeb(String nickname, String nuevoNombre, String nuevoApellido, LocalDate nuevaFecha,
                        String img) throws RemoteException;

        ArrayList<ActividadDeportiva> getActividadesByProfe(String nicknameProfesor) throws RemoteException;

        boolean eliminarRegistroDeClase(String nombreInstitucion, String nombreActividad, String nombreClase,
                        String nicknameSocio) throws RemoteException;

        Clase getClaseByNombre(String clase) throws RemoteException;

        Socio getSocio(String nicknameSocio) throws RemoteException;

        ArrayList<Clase> getClasesByUser(String nickname) throws RemoteException;

        boolean validateDataWeb(String nicknameSocio, String nombreClase) throws RemoteException;

        boolean crearRegistro(Socio socio, Clase clase) throws RemoteException;

        ArrayList<Socio> getSociosByClase(Clase clase) throws RemoteException;

        Sesion iniciarSesion(String nickname, String contrasena) throws RemoteException;

        boolean existenElementos(String nombreInstitucion, String nombreActividad, String nombreClase,
                        String nicknameSocio) throws RemoteException;
}
