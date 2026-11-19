/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcedimientosSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlMetodo {   
    
    public static ResultSet runQuery(String sentence){
        System.out.println("CONSULTA:\n"+sentence+"\n----------------");
        ResultSet res = null;      
        try {
            Statement sent = (Statement) Conexion.getInstance().createStatement();  
            res = sent.executeQuery(sentence);
        }
        catch (SQLException ex){
            System.out.println("EN RUN QUERY : "+ex.toString());
            if (!ex.toString().contains("org.postgresql.util.PSQLException: La consulta no retornó ningún resultado"))
                Datos.Procedimientos.escribirEnLog("CONSULTA:\n"+sentence+"\n----------------ERROR SqlMetodo.java: "+ex.toString());
            try {
                Statement sent = (Statement) Conexion.getInstance().createStatement(); 
                res = sent.executeQuery("SELECT '"+ex.getSQLState()+"';");
            } catch (SQLException ex1) {
                System.out.println("Problemas con conexion - "+ex1.toString());
                Datos.Procedimientos.escribirEnLog("Problemas con conexion - linea 29 runQuery en SqlMetodo.java "+ex1.toString());
            }
        }
        return res;
    }

    public static ResultSet runQueryRemoto(String sentence){
        System.out.println("CONSULTA:\n"+sentence+"\n----------------");
        ResultSet res = null;      
        try {
            Statement sent = (Statement) ConexionRemota.getInstance().createStatement();  
            res = sent.executeQuery(sentence);
        }
        catch (SQLException ex){
            System.out.println("EN RUN QUERY : "+ex.toString());
            Datos.Procedimientos.escribirEnLog("EN RUN QUERY linea 44 runQuery SqlMetodo.java: "+ex.toString());
            try {
                Statement sent = (Statement) ConexionRemota.getInstance().createStatement(); 
                res = sent.executeQuery("SELECT '"+ex.getSQLState()+"';");
            } catch (SQLException ex1) {
                System.out.println("Problemas con conexion - "+ex1.toString());
                Datos.Procedimientos.escribirEnLog("Problemas con conexion - linea 50 runQuery en SqlMetodo.java "+ex1.toString());
            }
        }
        catch (Exception e){
            System.out.println("EN RUN QUERY : "+e.toString());
            Datos.Procedimientos.escribirEnLog("EN RUN QUERY linea 55 runQuery SqlMetodo.java: "+e.toString());
            return null;
        }
        return res;
    }
    
    public String runUpdate(String sentence){
        try {
            Statement stm = (Statement) Conexion.getInstance().createStatement();
            stm.executeUpdate(sentence);
            return "0";
        }
        catch  (SQLException ex){
            System.out.println("ex : "+ex.toString());
            Datos.Procedimientos.escribirEnLog("runUpdate linea 69 en SqlMetodo.java"+ex.toString());
            return ex.getSQLState();
        }
    }    

    public String newRecord(String table, String[] columns, String[] allValues){
        String values = "";
        String columnNames = "";
        int i = 0;
        while (i != columns.length){
            values += (values.equals(""))? "'"+allValues[i]+"'" : ", '" + allValues[i]+"'";
            columnNames += (columnNames.equals(""))? columns[i] : ", " + columns[i];
             i++;
        }
        String command = "INSERT INTO " + table + " (" + columnNames + ") VALUES (" + values +")";
        System.out.println(command);
        return runUpdate(command);
    }

    public void create(java.sql.PreparedStatement stm) {
        try {
            stm.executeUpdate();
        }
        catch  (Exception ex){
            Datos.Procedimientos.escribirEnLog("Error en create en SqlMetodo.java: "+ex.toString());
        }
    }
    
    public String update(String tableName, String[] columns, String values[], String where){
           int i = 0;
           String strValues = ""; 
           while (i != columns.length){
                strValues += (strValues.equals(""))? columns[i]+"='"+values[i]+"'" : ", "+columns[i]+"='"+values[i]+"'";
                i++;
           }
           String command = "UPDATE " + tableName + " set " + strValues + " WHERE " + where + ";";
           System.out.println(command);
           return runUpdate(command);
   }    

    public int destroy(String tableName, String columnName, String id){
      String query = "DELETE from "+ tableName +" Where " + columnName + "= \'" + id + "\';";
      String resultado = runUpdate(query);
      if (resultado.compareTo("0")==0) return 0; else return -1;    
    }
    
    public ResultSet showAllOrder(String tableName, String orderBy){
        ResultSet result = null;
        String query = "SELECT * from " + tableName + " ORDER BY "+orderBy+";";
        System.out.println(query);
        result = runQuery( query );  
        return result;   
    }
    
    public ResultSet showOrderLike(String tableName, String orderBy, String field, String like){
        ResultSet result = null;
        String query = "SELECT * FROM " + tableName + " WHERE " + field + " ILIKE '" + like + "%' ORDER BY "+orderBy+";";
        System.out.println(query);
        result = runQuery( query );  
        return result;   
    }    
       
    public ResultSet showAll(String tableName){
     ResultSet result;
     
     String query = "SELECT * from " + tableName + ";";
     System.out.println(query);
     result = runQuery( query );  
     return result;
    }   

    public ResultSet getByWhere(String tableName, String where){
        ResultSet result;
        String query = "SELECT * from " + tableName + " WHERE " + where + ";";
        result = runQuery(query);
        return result;
    }     
    
    public ResultSet getByField(String tableName, String fieldName, String value){
        ResultSet result = null;
        String query = "SELECT * from " + tableName + " WHERE " + fieldName + "= \'" + value + "\';";
        System.out.println(query);
        result = runQuery( query );       
        return result;
    }
    
    public ResultSet getByFieldLike(String tableName, String fieldName, String value){
        ResultSet result = null;
        String query = "SELECT * from " + tableName + " WHERE " + fieldName + " like '%" + value + "%';";
        System.out.println(query);
        result = runQuery( query );
        return result;
    }
    
    public static void insertarExcepcion(Exception e, int idUsuario){
        String query = "INSERT INTO sistemaintegral.reporteserrores(\n" +
             "id_usuario_reporteserrores, fecha_reporteserrores, \n" +
             "mensaje_reporteserrores, localizacion_reporteserrores) \n" +
             "VALUES (" + idUsuario + ", now(), '" + e.getMessage() + "', '" + e.getLocalizedMessage() + "');";
        System.out.println(query);
        runQuery(query);
    }
    
}
