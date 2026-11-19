/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;



/**
 *
 * @author Damian
 */
public class Macros {
        
    //Datos de Usuario logeado
    private static Integer ID_USUARIO;
    private static Integer ID_PERSONA;
    private static String TIPO_USUARIO;
    private static String RAZON_SOCIAL;
        
    //Datos Personales Para La Factura
    private static String CUIT_PROPIO;
    private static String CALLE; 
    private static String CIUDAD;
    private static String PROVINCIA;
    private static String TELEFONO;
    
//Cambiar a la que provee la base de datos
    private static String RUTA_CERTIFICADO = System.getProperty("user.dir");
    
    private static final String PATH_PGDUMP = "C:\\Program Files\\PostgreSQL\\9.4\\bin\\pg_dump";
    private static final String PATH_PGDUMP86 = "C:\\Program Files(x86)\\PostgreSQL\\9.4\\bin\\pg_dump";

    public static String getPATH_PGDUMP() {
        return PATH_PGDUMP;
    }
    
    public static String getPATH_PGDUMP86() {
        return PATH_PGDUMP86;
    }
    
    public static String getRazonSocial() {
        return RAZON_SOCIAL;
    }

    public static void setRazonSocial(String rSocial) {
        Macros.RAZON_SOCIAL = rSocial;
    }
    
    
    public static String getCalle() {
        return CALLE;
    }

    public static void setCalle(String Calle) {
        Macros.CALLE = Calle;
    }

    public static String getCiudad() {
        return CIUDAD;
    }

    public static void setCiudad(String Ciudad) {
        Macros.CIUDAD = Ciudad;
    }

    public static String getProvincia() {
        return PROVINCIA;
    }

    public static void setProvincia(String Provincia) {
        Macros.PROVINCIA = Provincia;
    }

    public static String getTelefono() {
        return TELEFONO;
    }

    public static void setTelefono(String Telefono) {
        Macros.TELEFONO = Telefono;
    }    

    public static Integer getID_USUARIO() {
        return ID_USUARIO;
    }

    public static void setID_USUARIO(Integer ID_USARIO) {
        Macros.ID_USUARIO = ID_USARIO;
    }

    public static Integer getID_PERSONA() {
        return ID_PERSONA;
    }

    public static void setID_PERSONA(Integer ID_VENDEDOR) {
        Macros.ID_PERSONA = ID_VENDEDOR;
    }

    public static String getTIPO_USUARIO() {
        return TIPO_USUARIO;
    }

    public static void setTIPO_USUARIO(String TIPO_USUARIO) {
        Macros.TIPO_USUARIO = TIPO_USUARIO;
    }

    public static String getCUIT_PROPIO() {
        return CUIT_PROPIO;
    }

    public static void setCUIT_PROPIO(String CUIT_PROPIO) {
        Macros.CUIT_PROPIO = CUIT_PROPIO;
    }
    
    public static String getRUTA_CERTIFICADO() {
        return RUTA_CERTIFICADO;
    }

    public static void setRUTA_CERTIFICADO(String RUTA_CERTIFICADO) {
        Macros.RUTA_CERTIFICADO = RUTA_CERTIFICADO;
    }    
    
}
