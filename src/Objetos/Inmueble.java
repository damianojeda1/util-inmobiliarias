/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import static Datos.Procedimientos.obtenerUltimo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian
 */
public class Inmueble {
    int id=-1;
    LinkedList<String> tipos;
    String tipoContrato;
    float montoVenta;
    float montoAlquiler;
    boolean luz;
    boolean agua;
    boolean gas;
    boolean cloaca;
    boolean pavimento;
    boolean telefonia;
    float montoEMOS;
    float montoMunicipal;
    float montoExpensas;
    String direccion;
    int idCiudad;
    int sector;
    float dimension;
    int idPropietario;
    String observacion;
    
    boolean disponible=true;
    String estadoActual;

    public Inmueble(){
        
    }
    
    public Inmueble(LinkedList<String> tipos, String tipoContrato, float montoVenta, float montoAlquiler, 
            boolean luz, boolean agua, boolean gas, boolean cloaca, boolean tel, boolean pav, String direccion,
            int idCiudad, int sector, float dimension, int idPropietario,
            float montoEMOS, float montoMunicipal, float montoExpensas) {
        this.tipos = tipos;
        this.tipoContrato = tipoContrato;
        this.montoVenta = montoVenta;
        this.montoAlquiler = montoAlquiler;
        this.luz = luz;
        this.agua = agua;
        this.gas = gas;
        this.cloaca = cloaca;
        pavimento = pav;
        telefonia = tel;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
        this.sector = sector;
        this.dimension = dimension;
        this.idPropietario = idPropietario;
        this.observacion = "";
        this.montoEMOS = montoEMOS;
        this.montoMunicipal = montoMunicipal;
        this.montoExpensas = montoExpensas;
        if (estadoActual==null)
            this.estadoActual = "";
       
    }

    public LinkedList<String> getTipos() {
        return tipos;
    }

    public void setTipos(LinkedList<String> tipos) {
        this.tipos = tipos;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
    

    public float getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(float montoVenta) {
        this.montoVenta = montoVenta;
    }

    public float getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(float montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    public boolean isLuz() {
        return luz;
    }

    public void setLuz(boolean luz) {
        this.luz = luz;
    }

    public boolean isAgua() {
        return agua;
    }
    
    public void setPavimento(boolean pav) {
        pavimento = pav;
    }

    public boolean isPavimento() {
        return pavimento;
    }
    
    public void setTelefono(boolean tel) {
        telefonia = tel;
    }

    public boolean isTelefono() {
        return telefonia;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public boolean isCloaca() {
        return cloaca;
    }

    public void setCloaca(boolean cloaca) {
        this.cloaca = cloaca;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public float getDimension() {
        return dimension;
    }

    public void setDimension(float dimension) {
        this.dimension = dimension;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void insertarInmueble(){
        int ultimo = obtenerUltimo("id_inmueble","inmueble");
        ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.inmueble(\n" +
        "            valoralquiler_inmueble, valorventa_inmueble, direccion_inmueble, \n" +
        "            observacion_inmueble, dimension_inmueble, id_sector_inmueble, \n" +
        "            estado_inmueble, gas_inmueble, agua_inmueble, cloaca_inmueble, telefono_inmueble, pavimento_inmueble,\n" +
        "            luz_inmueble, id_propietario_inmueble, id_ciudad_inmueble, tipo_inmueble,\n" +
        "            montoEMOS_inmueble, montoExpensas_inmueble, montoMunicipal_inmueble)\n" +
        "    VALUES ("+this.getMontoAlquiler()+", "+this.getMontoVenta()+", '"+this.getDireccion()+"', \n" +
        "            '"+getObservacion()+"', "+this.getDimension()+", "+this.getSector()+", \n" +
        "            '"+getTipoContrato()+"', "+this.isGas()+", "+this.isAgua()+", "+this.isCloaca()+", "+isTelefono()+", "+isPavimento()+", \n" +
        "            "+this.isLuz()+", "+this.getIdPropietario()+", "+this.getIdCiudad()+", '"+tipoInmueble()+"',\n" +
        "            "+montoEMOS+", "+montoExpensas+", "+montoMunicipal+");");
        int nuevo = obtenerUltimo("id_inmueble","inmueble");   
        if (ultimo==nuevo){
            id = -1;
        } else {
            id = nuevo;
        }
    }
    
    public void actualizarDB(){
        String estado="estado_inmueble";
        if (!disponible){
            if (!this.estadoActual.equals("Vigente")){
                estado = "'No disponible'";
            }
        } else if (this.estadoActual.equals("No disponible")) {
            estado="'"+tipoContrato+"'";
        }
        ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.inmueble\n" +
        "   SET valoralquiler_inmueble="+this.getMontoAlquiler()+", valorventa_inmueble="+this.getMontoVenta()+", \n" +
        "       direccion_inmueble='"+this.getDireccion()+"', observacion_inmueble='"+getObservacion()+"', dimension_inmueble="+this.getDimension()+", \n" +
        "       id_sector_inmueble="+this.getSector()+", gas_inmueble="+this.isGas()+", agua_inmueble="+this.isAgua()+", \n" +
        "       cloaca_inmueble="+this.isCloaca()+", luz_inmueble="+this.isLuz()+", telefono_inmueble="+isTelefono()+", pavimento_inmueble="+isPavimento()+", id_propietario_inmueble="+this.getIdPropietario()+", \n" +
        "       id_ciudad_inmueble="+this.getIdCiudad()+", estado_inmueble="+estado+", tipo_inmueble='"+tipoInmueble()+"',\n" +  
        "       montoExpensas_inmueble="+montoExpensas+", montoMunicipal_inmueble="+montoMunicipal+", montoEMOS_inmueble="+montoEMOS+"\n" +
        " WHERE id_inmueble="+this.id+";");                
    }
    
    public void acomodarTipos(){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery(
                "SELECT 'Casa' FROM inmobiliaria.casa WHERE id_inmueble_casa = "+this.id+" UNION \n"+
                "SELECT 'Departamento' FROM inmobiliaria.departamento WHERE id_inmueble_departamento = "+this.id+" UNION \n"+
                "SELECT 'Local' FROM inmobiliaria.local WHERE id_inmueble_local = "+this.id+" UNION \n"+
                "SELECT 'Cochera' FROM inmobiliaria.cochera WHERE id_inmueble_cochera = "+this.id+" UNION \n"+
                "SELECT 'Campo' FROM inmobiliaria.campo WHERE id_inmueble_campo = "+this.id+" UNION \n"+
                "SELECT 'Galpon' FROM inmobiliaria.galpon WHERE id_inmueble_galpon = "+this.id);
        try {
            while (rs.next()){                
                if (!pertenece(rs.getString(1),this.tipos)){
                    ProcedimientosSQL.SqlMetodo.runQuery("DELETE FROM inmobiliaria."+rs.getString(1)+" WHERE id_inmueble_"+rs.getString(1)+"="+this.id);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean pertenece(String item, LinkedList<String> lista){
        for (int i=0; i<lista.size(); i++){
            if (item.equals(lista.get(i))){
                return true;
            }
        }        
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion += observacion+" ";
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    private String tipoInmueble() {
        String tipo = "";
        for (int i = 0; i < getTipos().size(); i++)
            if (i == getTipos().size() - 1)
                tipo=tipo + getTipos().get(i);
            else
                tipo=tipo + getTipos().get(i) + " - ";
        return tipo;
    }
}
