package Principal;

import Datos.Instancias;
import ProcedimientosSQL.Conexion;
import java.util.Calendar;


public class Inmobiliaria {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion con = new Conexion("postgres","11155636","inmobiliaria");
        if (con.conected){
            if (Instancias.getInstance().pantallaLogin == null){
                Instancias.getInstance().pantallaLogin = new PantallaLogin();
            }
            Instancias.getInstance().pantallaLogin.setVisible(true);
            Datos.Procedimientos.escribirEnLog("Inicio sesión "+Calendar.getInstance().getTime().toString());
        } else {
            System.exit(0);
        }
    }
    
}
