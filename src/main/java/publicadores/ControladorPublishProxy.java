package publicadores;

public class ControladorPublishProxy implements publicadores.ControladorPublish {
  private String _endpoint = null;
  private publicadores.ControladorPublish controladorPublish = null;
  
  public ControladorPublishProxy() {
    _initControladorPublishProxy();
  }
  
  public ControladorPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishProxy();
  }
  
  private void _initControladorPublishProxy() {
    try {
      controladorPublish = (new publicadores.ControladorPublishServiceLocator()).getControladorPublishPort();
      if (controladorPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublish != null)
      ((javax.xml.rpc.Stub)controladorPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublish getControladorPublish() {
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish;
  }
  
  public publicadores.ArrayList getInstituciones() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getInstituciones();
  }
  
  public publicadores.ArrayList obtenerRankingDeActividades() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerRankingDeActividades();
  }
  
  public void addClase(java.lang.String arg0, publicadores.LocalDate arg1, publicadores.LocalTime arg2, java.lang.String arg3, publicadores.LocalDate arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.addClase(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public publicadores.InstitucionDeportiva getInstitucionesByName(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getInstitucionesByName(arg0);
  }
  
  public publicadores.ActividadDeportiva obtenerActividadPorNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerActividadPorNombre(arg0);
  }
  
  public publicadores.ArrayList obtenerRankingDeClases() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerRankingDeClases();
  }
  
  public boolean eliminarRegistroDeClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.eliminarRegistroDeClase(arg0, arg1, arg2, arg3);
  }
  
  public publicadores.ArrayList obtenerClasesPorActividad(publicadores.ActividadDeportiva arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerClasesPorActividad(arg0);
  }
  
  public boolean modificarUsuarioWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, publicadores.LocalDate arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.modificarUsuarioWeb(arg0, arg1, arg2, arg3, arg4);
  }
  
  public publicadores.ArrayList getClasesByActividad(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClasesByActividad(arg0);
  }
  
  public boolean addRegistroDictadoWeb(java.lang.String arg0, java.lang.String arg1, publicadores.LocalDate arg2) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.addRegistroDictadoWeb(arg0, arg1, arg2);
  }
  
  public publicadores.Clase obtenerClasePorNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerClasePorNombre(arg0);
  }
  
  public publicadores.ArrayList getActividadesByProfe(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getActividadesByProfe(arg0);
  }
  
  public boolean crearRegistro(publicadores.Socio arg0, publicadores.Clase arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.crearRegistro(arg0, arg1);
  }
  
  public boolean validateDataWeb(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.validateDataWeb(arg0, arg1);
  }
  
  public publicadores.ArrayList getSociosByClase(publicadores.Clase arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getSociosByClase(arg0);
  }
  
  public publicadores.Clase getClaseByNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClaseByNombre(arg0);
  }
  
  public boolean existenElementos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.existenElementos(arg0, arg1, arg2, arg3);
  }
  
  public publicadores.Sesion iniciarSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.iniciarSesion(arg0, arg1);
  }
  
  public publicadores.ArrayList getClasesByUser(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClasesByUser(arg0);
  }
  
  public publicadores.Socio getSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getSocio(arg0);
  }
  
  
}