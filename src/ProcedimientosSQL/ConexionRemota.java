
package ProcedimientosSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionRemota {
    
    //Estas variables se utilizan para formar los parametros de la coneccion 
    private final String driver = "com.mysql.jdbc.Driver";
    private static String url= "jdbc:mysql://11111/";
    private static Connection conn;
    private static String base;
    private static String usuario;
    private static String password;

    
    //Funciones auxiliares que le permiten obtener a otras clases las distintas
    //variables globales, ya que estas son privadas de la clase.
    public synchronized static Connection getInstance(){
        if (conn == null)
            conn = new ConexionRemota(usuario,password,base).getConexion();
        return conn;
    }

    public Connection getConexion(){
        return conn;
    }
	
    public ConexionRemota(String user, String pass, String db){
        try {
            base = db;
            usuario = user;
            password = pass;
            Class.forName(driver);
            //url = url + db;
            conn = DriverManager.getConnection(url+db,user,pass);
            System.out.println("Conexion exitosa " + url);
        } catch(ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);
            Datos.Procedimientos.escribirEnLog("Error loading driver linea 53 en ConexioRemota.java: " + cnfe.toString());
            conn = null;
        } catch(SQLException sqle) {
            System.err.println("Error connecting: " + sqle);
            Datos.Procedimientos.escribirEnLog("Error connecting en linea 57 en conexion remota: " + sqle.toString());
            conn = null;
        }
        
    }
   
}
