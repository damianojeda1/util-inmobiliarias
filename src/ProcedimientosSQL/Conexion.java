package ProcedimientosSQL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Conexion {
	
	//Estas variables se utilizan para formar los parametros de la coneccion 
	private final String driver = "org.postgresql.Driver";
        private static LinkedList<String> ips;
        private static Connection conn;
        private static String base;
        private static String usuario;
        private static String password;
        public boolean conected;
       
	//Funciones auxiliares que le permiten obtener a otras clases las distintas
	//variables globales, ya que estas son privadas de la clase.
	public synchronized static Connection getInstance(){
                if (conn == null)
                        conn = new Conexion(usuario,password,base).getConexion();
                return conn;
        }

	public Connection getConexion(){
		return conn;
	}
	
	//Funcion principal y constructor de la clase, que se encarga de pedir
	//los datos y realizar la coneccion correspondiente.
	public Conexion(String user, String pass, String db){
            leerIp();
            base = db;
            usuario = user;
            password = pass;
            try {
                Class.forName(driver);
                int i = 0;
                conected = false;
                while (i<ips.size() && !conected){
                    try {
                        System.out.println("Probando "+ips.get(i));
                        conn = DriverManager.getConnection(ips.get(i)+db,user,pass);
                        conected = true;
                    } catch(SQLException sqle) {
                        Datos.Procedimientos.escribirEnLog("Error en Conexion en linea 56: "+sqle);
                        System.out.println("NO! - "+ips.get(i));
                        i++;
                    }                    
                }
                System.out.println(i+" - "+ips.size());
                if (i==ips.size()){
                    ConexionManual cm = new ConexionManual(null,true);
                    while (!cm.closed && !cm.ok){ 
                        try {
                            cm.setVisible(true);
                            if (!cm.closed){
                                conn = DriverManager.getConnection("jdbc:postgresql://"+cm.tfIP.getText()+":5432/"+db,user,pass);
                                conected = true;
                                cm.ok = true;
                                agregarNuevoIp("jdbc:postgresql://"+cm.tfIP.getText()+":5432/");
                            } else {
                                conected = false;
                            }
                        } catch(SQLException sqle) {
                            JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos");
                            System.out.println("NO! - " + cm.tfIP.getText());
                            sqle.printStackTrace();
                            Datos.Procedimientos.escribirEnLog("Error en linea 79 en conexion en conexion"+sqle.getMessage());
                        }   
                    } 
                        
                } else {
                    System.out.println("Conexion exitosa " + ips.get(i));
                }
                
            } catch(ClassNotFoundException cnfe) {
                    System.err.println("Error loading driver: " + cnfe);
                    Datos.Procedimientos.escribirEnLog("Error loading driver linea 89: " + cnfe.toString());
            } 
	}
                
        private void leerIp(){
            try {
                String ruta = "ip.txt";
                ips = new LinkedList<>();
                File archivo = new File(ruta);
                FileReader fr = new FileReader (archivo);            
                if(archivo.exists()) {
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while((linea=br.readLine())!=null)
                       ips.add(linea);                  
                }
            }catch(Exception ex){
                Datos.Procedimientos.escribirEnLog("Error en leer Ip en conexion.java en linea 106: "+ex);
            }
            
        }
        
        private void agregarNuevoIp(String ip){
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter("ip.txt");
                pw = new PrintWriter(fichero);
                pw.println(ip);
            } catch (Exception e) {
                Datos.Procedimientos.escribirEnLog("Error en agregar nuevo ip en conexion.java en linea 119: "+e);
            } finally {
                try {
                    if (null != fichero)
                       fichero.close();
                } catch (Exception e2) {
                    Datos.Procedimientos.escribirEnLog("Error en leer Ip en conexion.java en linea 125: "+e2);
                }
            }
        }
        
}