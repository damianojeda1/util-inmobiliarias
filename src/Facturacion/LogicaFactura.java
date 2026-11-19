package Facturacion;
import Objetos.Comprobante;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.util.LinkedList;

/**
 *
 * @author Damian
 */
public class LogicaFactura {
    private  Comprobante objComp;
    private String query;
    
    public LogicaFactura(Comprobante objetoComprobante){
       objComp = objetoComprobante;
       query = null;
    }
    
//----------COMPROBANTE ALQUILER----------    
    
    private void guardarComprobanteAlquiler(){        
        String query = "INSERT INTO inmobiliaria.comprobantealquiler(\n" +
                       " tipo_comprobantealquiler, nro_comprobantealquiler, total_comprobantealquiler, \n" + 
                       " fecha_comprobantealquiler, id_contratoalquiler_comprobantealquiler, \n" +
                       " id_vendedor_comprobantealquiler, observacion_comprobantealquiler)\n" +
                       " VALUES ('"+objComp.getTipoComprobante()+"', '"+objComp.getNumeroComprobante()+"', "+objComp.getTotalComprobante()+", \n" +
                       " '"+objComp.getFechaComprobante()+ "', "+objComp.getClienteComprobante()+", "+Datos.Macros.getID_PERSONA()+", '"+objComp.getObservacion()+"');";
        SqlMetodo.runQuery(query);        
        objComp.setIdComprobante(Datos.Procedimientos.obtenerUltimo("id_comprobantealquiler", "comprobantealquiler"));
        if (objComp.getTotalComprobante() < 0)
            SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET saldo_contratoalquiler="+objComp.getTotalComprobante()*-1+" WHERE id_contratoalquiler="+objComp.getClienteComprobante());
    }
    
    private void guardarPagos(){
        for (int i = 0; i < objComp.getPagoComprobante().size(); i++){
            query="INSERT INTO inmobiliaria.pagoalquiler(" +
                   "id_comprobantealquiler_pagoalquiler, tipo_pagoalquiler, monto_pagoalquiler, " +
                   "fecha_pagoalquiler) " +
                   "VALUES ( "+objComp.getIdComprobante()+", '"+objComp.getPagoComprobante().get(i).getPrimero().toString()+"', "+Float.valueOf(objComp.getPagoComprobante().get(i).getSegundo().toString())+", '" +
                   objComp.getFechaComprobante().toString()+"');";
            SqlMetodo.runQuery(query);
        }
    }    
    
    private void guardarItemComprobante(){
        LinkedList<Tripla> itemComp = objComp.getItemComprobante();
        query="INSERT INTO inmobiliaria.item(\n" +
            "   descripcion_item, fecha_item, monto_item, id_comprobantealquiler_item)\n" +
              "VALUES ";
        int i = 0;
        for(i = 0; i < itemComp.size(); i++){
            System.out.println(itemComp.get(i).getSegundo().toString());
            if (itemComp.get(i).getSegundo().toString().equals("Bonificacion saldo anterior"))
                
                SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET saldo_contratoalquiler=saldo_contratoalquiler + ("+itemComp.get(i).getTercero()+") "
                        +          "WHERE id_contratoalquiler= (SELECT id_contratoalquiler_comprobantealquiler FROM inmobiliaria.comprobantealquiler WHERE id_comprobantealquiler="+objComp.getIdComprobante()+")");
            query = query + " ('" + itemComp.get(i).getSegundo() + "', '" + itemComp.get(i).getPrimero() + "', " +
                    itemComp.get(i).getTercero() + ", " + objComp.getIdComprobante() + " ";
            if ((i + 1) == itemComp.size())
                query = query + ");";
            else
                query = query + "),";       
        }
        SqlMetodo.runQuery(query);   
    }    
    
    private void guardarServicios(){
        LinkedList<Tripla> servicios = objComp.getServicios();
        query=" INSERT INTO inmobiliaria.serviciocomprobante(\n" +
              "            id_servicio_serviciocomprobante, id_comprobante_serviciocomprobante, \n" +
              "            estado_serviciocomprobante)\n" +
              " VALUES ";
        int i = 0;
        for(i = 0; i < servicios.size(); i++){
            query = query + " (" + servicios.get(i).getSegundo() + ", " + objComp.getIdComprobante() + ", " +
                    servicios.get(i).getPrimero() + " ";
            
            if ((i + 1) == servicios.size())
                query = query + ");";
            else
                query = query + "), ";       
        }
        SqlMetodo.runQuery(query);   
    }    
    
    private void actualizarProximoCobro(){
        SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET proximocobro_contratoalquiler = proximocobro_contratoalquiler + INTERVAL '1 MONTH'"+
                " WHERE id_contratoalquiler="+objComp.getClienteComprobante());
        SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET estado_contratoalquiler = 'Finalizado' "+
                " WHERE proximocobro_contratoalquiler > fin_contratoalquiler AND id_contratoalquiler="+objComp.getClienteComprobante());
        SqlMetodo.runQuery("UPDATE inmobiliaria.inmueble SET estado_inmueble = 'Finalizado' "+
                " WHERE id_inmueble=(SELECT MAX(id_inmueble_contratoalquiler) FROM inmobiliaria.contratoalquiler \n" +
                "                    WHERE proximocobro_contratoalquiler > fin_contratoalquiler AND id_contratoalquiler="+objComp.getClienteComprobante()+")");
        
    }
    
    public void guardarFactura(){
        this.guardarComprobanteAlquiler();
        this.guardarPagos();
        this.guardarItemComprobante();
        this.guardarServicios();
        this.actualizarProximoCobro();
    }    
    
    
//------------RECIBO----------    
    
    private void guardarPagoRecibo(){        
        for (int i = 0; i < objComp.getPagoComprobante().size(); i++){
            query="INSERT INTO inmobiliaria.pago(" +
                   "id_comprobante_pago, tipo_pago, monto_pago, " +
                   "fecha_pago) " +
                   "VALUES ( "+objComp.getIdComprobante()+", '"+objComp.getPagoComprobante().get(i).getPrimero().toString()+"', "+Float.valueOf(objComp.getPagoComprobante().get(i).getSegundo().toString())+", '" +
                   objComp.getFechaComprobante().toString()+"');";
            SqlMetodo.runQuery(query);
        }
    }

    public void guardarRecibo(){
        String query = "INSERT INTO inmobiliaria.comprobante(\n" +
                       " tipo_comprobante, nro_comprobante, total_comprobante, \n" +
                       " fecha_comprobante, id_cliente_comprobante, id_vendedor_comprobante, observacion_comprobante)\n" +
                       " VALUES ('"+objComp.getTipoComprobante()+"', '"+objComp.getNumeroComprobante()+"', "+objComp.getTotalComprobante()+", \n" +
                       " '"+objComp.getFechaComprobante()+ "', "+objComp.getClienteComprobante()+", "+Datos.Macros.getID_PERSONA()+", '"+objComp.getObservacion()+"');";
        SqlMetodo.runQuery(query);
        objComp.setIdComprobante(Datos.Procedimientos.obtenerUltimo("id_comprobante", "comprobante"));
        this.guardarPagoRecibo();
    }
    
//------------LIQUIDACION----------    
    public void guardarLiquidacion(int idCompAlquiler, int idCompRelacionado){
        String query = "INSERT INTO inmobiliaria.comprobantealquiler(\n" +
                       " tipo_comprobantealquiler, nro_comprobantealquiler, total_comprobantealquiler, \n" + 
                       " fecha_comprobantealquiler, id_contratoalquiler_comprobantealquiler, \n" +
                       " id_vendedor_comprobantealquiler, observacion_comprobantealquiler)\n" +
                       " VALUES ('"+objComp.getTipoComprobante()+"', '"+objComp.getNumeroComprobante()+"', "+objComp.getTotalComprobante()+", \n" +
                       " '"+objComp.getFechaComprobante()+ "', "+objComp.getClienteComprobante()+", "+Datos.Macros.getID_PERSONA()+", '"+objComp.getObservacion()+"');";
        SqlMetodo.runQuery(query);
        objComp.setIdComprobante(Datos.Procedimientos.obtenerUltimo("id_comprobantealquiler", "comprobantealquiler"));
        SqlMetodo.runQuery("UPDATE inmobiliaria.comprobantealquiler SET id_comprobante_liquidacion="+objComp.getIdComprobante()+" WHERE id_comprobantealquiler="+idCompRelacionado);
        
        this.guardarPagos();
        this.guardarItemComprobante();        
    }  
}
