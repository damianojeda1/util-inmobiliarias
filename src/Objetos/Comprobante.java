package Objetos;

import java.util.Date;
import java.util.LinkedList;

public class Comprobante {
   
    
    private int idComprobante=0;
    
    private int numeroComprobante;					
    private java.util.Date fechaComprobante;				
    private float totalComprobante;			
    private Integer clienteComprobante;	   
    private String tipoComprobante;
    private String observacion;
    private LinkedList<Tripla> itemComprobante;
    private LinkedList<Tripla> pagoComprobante;
    
    private LinkedList<Tripla> servicios;
    
    
    
    public Comprobante(){}

    public Comprobante(int numeroComprobante, Date fechaComprobante, float totalComprobante, Integer clienteComprobante, String tipoComprobante, String observacion, LinkedList<Tripla> itemComprobante, LinkedList<Tripla> pagoComprobante) {
        this.numeroComprobante = numeroComprobante;
        this.fechaComprobante = fechaComprobante;
        this.totalComprobante = totalComprobante;
        this.clienteComprobante = clienteComprobante;
        this.tipoComprobante = tipoComprobante;
        this.observacion = observacion;
        this.itemComprobante = itemComprobante;
        this.pagoComprobante = pagoComprobante;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }
    
    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(int numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public float getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(float totalComprobante) {
        this.totalComprobante = totalComprobante;
    }

    public Integer getClienteComprobante() {
        return clienteComprobante;
    }

    public void setClienteComprobante(Integer clienteComprobante) {
        this.clienteComprobante = clienteComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LinkedList<Tripla> getItemComprobante() {
        return itemComprobante;
    }

    public void setItemComprobante(LinkedList<Tripla> itemComprobante) {
        this.itemComprobante = itemComprobante;
    }

    public LinkedList<Tripla> getPagoComprobante() {
        return pagoComprobante;
    }

    public void setPagoComprobante(LinkedList<Tripla> pagoComprobante) {
        this.pagoComprobante = pagoComprobante;
    }

    public LinkedList<Tripla> getServicios() {
        return servicios;
    }

    public void setServicios(LinkedList<Tripla> servicios) {
        this.servicios = servicios;
    }
    
    
    

}
