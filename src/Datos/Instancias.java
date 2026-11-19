package Datos;
import Principal.PantallaLogin;
import Principal.PantallaPrincipal;

public class Instancias {
   public PantallaLogin pantallaLogin; 
   public Busqueda.BusquedaAvanzada busquedaAvanzada;
   public PantallaPrincipal pantallaPrincipal;
   public ABM.AbmPersona abmPersona;
   public ABM.PantallaABMDatos pantallaAbmDatos;
   public ABM.AbmSector abmSector;
   public ABMUsuarios.AbmPersonal abmPersonal;
   public ABMUsuarios.CambiarUsuarioPropio usuario;
   public ABM.ABMCampo abmCampo;
   public ABM.ABMCasa abmCasa;
   public ABM.ABMCochera abmCochera;
   public ABM.ABMDepto abmDepto;
   public ABM.ABMInmuebles abmInmuebles;
   public ABM.ABMLocal abmLocal;
   public ABM.ABMGalpon abmGalpon;
   public ABM.ABMContratoA abmContratoA;
   public ABM.ABMContratoV abmContratoV;
   public Facturacion.Facturacion facturacion;
   public Contabilidad.CuentaCorriente cuentaCorriente;
   public Listados.MisComprobantes browser;
   public Listados.ListaContratos listaContratos;   
   public Listados.PresentacionServicios presentacionServicios;   
   public Listados.ItemComprobante item;
   public Configuracion.PantallaOpciones pantallaOpciones;
   private static Instancias instance; 
   
   public Instancias(){
      
   }  
   
   public synchronized static Instancias getInstance(){
        if (instance == null)
                instance = new Instancias();
        return instance;
    }
   
}
