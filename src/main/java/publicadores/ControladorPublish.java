package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 4.0.3
 * 2023-11-10T11:07:44.338-03:00
 * Generated source version: 4.0.3
 *
 */
@WebService(targetNamespace = "http://publicadores/", name = "ControladorPublish")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ControladorPublish {

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/modificarUsuarioWebRequest", output = "http://publicadores/ControladorPublish/modificarUsuarioWebResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public boolean modificarUsuarioWeb(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        LocalDate arg3,
        @WebParam(partName = "arg4", name = "arg4")
        java.lang.String arg4
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/existenElementosRequest", output = "http://publicadores/ControladorPublish/existenElementosResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public boolean existenElementos(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getSociosByClaseRequest", output = "http://publicadores/ControladorPublish/getSociosByClaseResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList getSociosByClase(

        @WebParam(partName = "arg0", name = "arg0")
        Clase arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getClasesByUserRequest", output = "http://publicadores/ControladorPublish/getClasesByUserResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList getClasesByUser(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getClasesByActividadRequest", output = "http://publicadores/ControladorPublish/getClasesByActividadResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList getClasesByActividad(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/validateDataWebRequest", output = "http://publicadores/ControladorPublish/validateDataWebResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public boolean validateDataWeb(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/obtenerActividadPorNombreRequest", output = "http://publicadores/ControladorPublish/obtenerActividadPorNombreResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ActividadDeportiva obtenerActividadPorNombre(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/obtenerClasesPorActividadRequest", output = "http://publicadores/ControladorPublish/obtenerClasesPorActividadResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList obtenerClasesPorActividad(

        @WebParam(partName = "arg0", name = "arg0")
        ActividadDeportiva arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/obtenerRankingDeActividadesRequest", output = "http://publicadores/ControladorPublish/obtenerRankingDeActividadesResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList obtenerRankingDeActividades()
;

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/addClaseRequest", output = "http://publicadores/ControladorPublish/addClaseResponse")
    public void addClase(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        LocalDate arg1,
        @WebParam(partName = "arg2", name = "arg2")
        LocalTime arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3,
        @WebParam(partName = "arg4", name = "arg4")
        LocalDate arg4,
        @WebParam(partName = "arg5", name = "arg5")
        java.lang.String arg5,
        @WebParam(partName = "arg6", name = "arg6")
        java.lang.String arg6,
        @WebParam(partName = "arg7", name = "arg7")
        java.lang.String arg7
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getClaseByNombreRequest", output = "http://publicadores/ControladorPublish/getClaseByNombreResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public Clase getClaseByNombre(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/crearRegistroRequest", output = "http://publicadores/ControladorPublish/crearRegistroResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public boolean crearRegistro(

        @WebParam(partName = "arg0", name = "arg0")
        Socio arg0,
        @WebParam(partName = "arg1", name = "arg1")
        Clase arg1
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/obtenerClasePorNombreRequest", output = "http://publicadores/ControladorPublish/obtenerClasePorNombreResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public Clase obtenerClasePorNombre(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/iniciarSesionRequest", output = "http://publicadores/ControladorPublish/iniciarSesionResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public Sesion iniciarSesion(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getInstitucionesByNameRequest", output = "http://publicadores/ControladorPublish/getInstitucionesByNameResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public InstitucionDeportiva getInstitucionesByName(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getActividadesByProfeRequest", output = "http://publicadores/ControladorPublish/getActividadesByProfeResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList getActividadesByProfe(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/addRegistroDictadoWebRequest", output = "http://publicadores/ControladorPublish/addRegistroDictadoWebResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public boolean addRegistroDictadoWeb(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        LocalDate arg2
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/obtenerRankingDeClasesRequest", output = "http://publicadores/ControladorPublish/obtenerRankingDeClasesResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList obtenerRankingDeClases()
;

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getInstitucionesRequest", output = "http://publicadores/ControladorPublish/getInstitucionesResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public ArrayList getInstituciones()
;

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/getSocioRequest", output = "http://publicadores/ControladorPublish/getSocioResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public Socio getSocio(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://publicadores/ControladorPublish/eliminarRegistroDeClaseRequest", output = "http://publicadores/ControladorPublish/eliminarRegistroDeClaseResponse")
    @WebResult(name = "return", targetNamespace = "http://publicadores/", partName = "return")
    public boolean eliminarRegistroDeClase(

        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3
    );
}
