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
  
  public publicadores.DtInstitucion getInstitucionesByName(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getInstitucionesByName(arg0);
  }
  
  public void addClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.addClase(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public boolean addRegistroDictadoWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.addRegistroDictadoWeb(arg0, arg1, arg2);
  }
  
  public publicadores.DtActividadDeportiva obtenerActividadPorNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerActividadPorNombre(arg0);
  }
  
  public publicadores.DtActividadDeportiva[] getActividadesByInstitucion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getActividadesByInstitucion(arg0);
  }
  
  public publicadores.Sesion iniciarSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.iniciarSesion(arg0, arg1);
  }
  
  public publicadores.DtActividadDeportiva[] getActividadesByProfe(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getActividadesByProfe(arg0);
  }
  
  public boolean modificarUsuarioWeb(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.modificarUsuarioWeb(arg0, arg1, arg2, arg3, arg4);
  }
  
  public boolean validateDataWeb(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.validateDataWeb(arg0, arg1);
  }
  
  public boolean eliminarRegistroDeClase(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.eliminarRegistroDeClase(arg0, arg1, arg2, arg3);
  }
  
  public boolean existenElementos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.existenElementos(arg0, arg1, arg2, arg3);
  }
  
  public publicadores.DtClase[] getClasesByActividad(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClasesByActividad(arg0);
  }
  
  public publicadores.LocalDate stringToLocalDate(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.stringToLocalDate(arg0);
  }
  
  public publicadores.LocalTime stringToLocalTime(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.stringToLocalTime(arg0);
  }
  
  public boolean crearRegistro(publicadores.DtUsuario arg0, publicadores.DtClase arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.crearRegistro(arg0, arg1);
  }
  
  public publicadores.DtUsuario[] getSociosByClase(publicadores.DtClase arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getSociosByClase(arg0);
  }
  
  public publicadores.DtClase[] obtenerClasesPorActividad(publicadores.DtActividadDeportiva arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerClasesPorActividad(arg0);
  }
  
  public publicadores.DtClase getClaseByNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClaseByNombre(arg0);
  }
  
  public publicadores.DtClase[] getClasesByUser(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClasesByUser(arg0);
  }
  
  public publicadores.DtClase obtenerClasePorNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerClasePorNombre(arg0);
  }
  
  public publicadores.DtActividadDeportiva[] obtenerRankingDeActividades() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerRankingDeActividades();
  }
  
  public publicadores.DtClase[] obtenerRankingDeClases() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.obtenerRankingDeClases();
  }
  
  public publicadores.DtInstitucion[] getInstituciones() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getInstituciones();
  }
  
  public publicadores.DtUsuario getSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getSocio(arg0);
  }
  
  
}