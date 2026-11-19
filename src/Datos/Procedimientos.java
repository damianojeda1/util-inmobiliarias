/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import ProcedimientosSQL.SqlMetodo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Damian
 */
public class Procedimientos {    
        //Funciones de inicializacion
    public static int obtenerUltimo(String campo, String tabla){
        int ultimoId = -1;
        String consultaUltimo = "select MAX("+campo+") from inmobiliaria."+tabla+";";
        java.sql.ResultSet ultimo = ProcedimientosSQL.SqlMetodo.runQuery(consultaUltimo);
        try {
            while (ultimo.next()){
                ultimoId = ultimo.getInt(1);
            }
        }
        catch  (java.sql.SQLException ex){
            System.out.println("ex : "+ex.toString());
            Datos.Procedimientos.escribirEnLog("Error obtener ultimo \n"+ex.toString());
        }
        return ultimoId;
    }    
    
    public static int obtenerPrimero(String campo, String tabla){
        int ultimoId = -1;
        String consultaUltimo = "select MIN("+campo+") from inmobiliaria."+tabla+";";
        java.sql.ResultSet ultimo = ProcedimientosSQL.SqlMetodo.runQuery(consultaUltimo);
        try {
            if (ultimo.next()){
                ultimoId = ultimo.getInt(1);
            }
        }
        catch  (java.sql.SQLException ex){
            System.out.println("ex : "+ex.toString());
            Datos.Procedimientos.escribirEnLog("Error obtenerPrimero \n"+ex.toString());
        }
        return ultimoId;
    }
    
    public static boolean isNumber(String string) {
        try {
            Float.parseFloat(string);
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 59 en isNumber de la Procedimientos: "+e.toString());
            return false;
        }
        return true;
    }  
    
    public static float Redondear(float numero,int digitos) {
        int cifras=(int) Math.pow(10,digitos);
        return Float.parseFloat(Double.toString(Math.rint(numero*cifras)/cifras));
    }; 
    
    public static double Redondear(double numero,int digitos) {
        int cifras=(int) Math.pow(10,digitos);
        return Math.rint(numero*cifras)/cifras;
    }; 
    
    public static String truncar(Float numero){
        return String.format("%1$.2f",numero).replace(',', '.');
    }
    
    public static int perteneceATabla(Object elem, javax.swing.JTable tbl, int columna){
        for (int i=0; i<tbl.getRowCount(); i++){
            if (tbl.getValueAt(i, columna).equals(elem))
                return i;
        }
        return -1;
    }
    
    public static String remplazarCaracter(String palabra){
      return palabra.replaceAll("\'", "''");
    }
    
    public static String completaConCero(String palabra, int Cantidad){
        for (int i = palabra.length(); i < Cantidad; i++)
            palabra = "0"+palabra;
        return palabra;
    }
    
    public static String unificarCifra(float numero, int cantidad){
        String cifra = Float.toString(numero);
        String parteDecimal = cifra.substring(cifra.indexOf("."), cifra.length());
        if (parteDecimal.length() == 2)
            cifra = cifra+"0";
        String cifrafinal= cifra.replace(".", "");
        cifrafinal= completaConCero(cifrafinal,cantidad);
        return cifrafinal;
    }
    
    public static String completaConEspacios(String palabra, int tamaño, String posicion){
        if (palabra.length()>tamaño)
            return palabra.substring(0, tamaño);
        else{
            if (posicion.equals("Derecha"))
                for (int i = palabra.length(); i < tamaño; i++)
                    palabra = palabra+" ";
            else
                for (int i = palabra.length(); i < tamaño; i++)
                    palabra = palabra+" ";
        }
        return palabra;
    }
    
    public static void crearLogExep(){
        try {
            FileWriter fichero = new FileWriter(System.getProperty("user.dir") + "/logExep.txt");
            PrintWriter pw = new PrintWriter(fichero);
            fichero.close();
            File miArchivo = new File (System.getProperty("user.dir") + "/logExep.txt");
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 123 en crearLogExep de 123: "+e.toString());
        }
    }
    
    public static void escribirEnLog(String exc){
        java.io.File log = new java.io.File(System.getProperty("user.dir") + "/logExep.txt");
        if (log.exists()){
            try {
                FileWriter fichero = new FileWriter(log, true);
                fichero.write(exc+"\n");
                fichero.close();
            } catch (IOException ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 172 en main de la Anulados: "+ex.toString());
            }
        }else 
            crearLogExep();
    }
    
    public static void llenarCBAlicuota(javax.swing.JComboBox cbA){
        cbA.removeAllItems();
        cbA.addItem("21.0");
        cbA.addItem("10.5");
    } 
    
    public static void llenarCBSector(javax.swing.JComboBox cbCat){
        cbCat.removeAllItems();
        String consulta = "SELECT id_sector,nombre_sector FROM inmobiliaria.sector;";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            while (rs.next())
                cbCat.addItem(new Objetos.Tripla(rs.getObject(1), null , rs.getObject(2)));
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }            
    }    
    
    public static void llenarCBPersona(javax.swing.JComboBox cbProv, String tipo){
        cbProv.removeAllItems();
        String consulta = "SELECT id_persona,razonsocial_persona FROM inmobiliaria.persona WHERE tipo_persona='"+tipo+"' ORDER BY razonsocial_persona;";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            while (rs.next())
                cbProv.addItem(new Objetos.Tripla(rs.getObject(1), null , rs.getObject(2)));
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }            
    }    
    
    public static Objetos.Tripla obtenerLocDeId(int idLoc){
        String consulta = "SELECT id_ciudad, nombre_ciudad FROM inmobiliaria.ciudad WHERE id_ciudad = "+idLoc+";";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            if (rs.next())
                return new Objetos.Tripla(rs.getInt(1),"",rs.getString(2));
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }       
        return null;
    }
    
    public static Objetos.Tripla obtenerProvDeId(int idLoc){
        String consulta = "SELECT id_provincia, nombre_provincia FROM "
                + "inmobiliaria.ciudad INNER JOIN inmobiliaria.provincia ON id_provincia=id_provincia_ciudad "
                + "WHERE id_ciudad = "+idLoc+";";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            if (rs.next())
                return new Objetos.Tripla(rs.getInt(1),"",rs.getString(2));
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }       
        return null;
    }
    
    public static void llenarCBProvincia(javax.swing.JComboBox cbProvincia){
        cbProvincia.removeAllItems();
        String consulta = "SELECT id_provincia,nombre_provincia FROM inmobiliaria.provincia;";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            while (rs.next())
                cbProvincia.addItem(new Objetos.Tripla(rs.getObject(1), null , rs.getObject(2)));
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }            
    }    
    
    public static void llenarCBLocalidad(javax.swing.JComboBox cbLocalidad, int codigoProvincia){
        cbLocalidad.removeAllItems();
        String consulta = "SELECT id_ciudad,nombre_ciudad FROM inmobiliaria.ciudad WHERE "
                + "id_provincia_ciudad = "+codigoProvincia
                + " ORDER BY nombre_ciudad;";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            while (rs.next())
                cbLocalidad.addItem(new Objetos.Tripla(rs.getObject(1), null, rs.getObject(2)));
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }          
    }    

    //Actualizar montos alquileres
    /*
    public static boolean actualizarAlquileres(){
        boolean repetir = false;
        String consulta = "SELECT id_contratoalquiler, reajuste_contratoalquiler, tiemporeajuste_contratoalquiler, montoactual_contratoalquiler, \n" +
                " proximoajuste_contratoalquiler, montoactual_contratoalquiler * (1+(reajuste_contratoalquiler)/100) as nuevoMonto \n"+
                " FROM inmobiliaria.contratoalquiler\n" +
                " WHERE estado_contratoalquiler = 'Vigente' AND proximoajuste_contratoalquiler <= proximocobro_contratoalquiler;";
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            while (rs.next()){
                repetir = true;
                float monto = rs.getFloat("montoactual_contratoalquiler") * (1+(rs.getFloat("reajuste_contratoalquiler")/100));
                ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET montoactual_contratoalquiler="+rs.getFloat("nuevoMonto")+", \n" +
                                                         "proximoajuste_contratoalquiler=(proximoajuste_contratoalquiler::date + (tiemporeajuste_contratoalquiler || ' month')::interval)::date\n" +
                                                         "WHERE id_contratoalquiler="+rs.getInt("id_contratoalquiler"));
                
            }
        } catch (SQLException ex) {
            repetir = false;
            Datos.Procedimientos.escribirEnLog(ex.toString());
        }  
        return repetir;
    }
*/
}
