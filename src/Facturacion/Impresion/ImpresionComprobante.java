
package Facturacion.Impresion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
/**
 *
 * @author Damian
 */
public class ImpresionComprobante {
    javax.swing.JTable tblProductos;
    float total;
    float neto;
    String fecha;
    String datosPersonales;
    String motivo;
    int cantTipoPagos;    
    String conceptoRecibo;
    String numeroComp;
    
    int cantItems;
    
    public void imprimirDB(int idComprobante){
        try {
            ResultSet rsComp = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_comprobantealquiler, tipo_comprobantealquiler, nro_comprobantealquiler, \n" +
                "       total_comprobantealquiler, fecha_comprobantealquiler, id_contratoalquiler_comprobantealquiler, \n" +
                "       id_vendedor_comprobantealquiler, observacion_comprobantealquiler\n" +
                "  FROM inmobiliaria.comprobantealquiler WHERE id_comprobantealquiler="+idComprobante+";");
            rsComp.next();
            
            String fechaDir = new SimpleDateFormat("ddMMyyyy").format(rsComp.getDate("fecha_comprobantealquiler"));
            String nombre;
            String nombreImagen;
            
            ResultSet rsInquilino = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                "       mail_persona, telefono_persona, direccion_persona, estado_persona, tipo_inmueble, direccion_inmueble\n" +
                "       tipo_persona, id_ciudad_persona, nombre_ciudad, nombre_provincia, direccion_inmueble, tipo_inmueble, piso_departamento, dpto_departamento \n" +
                "   FROM inmobiliaria.contratoalquiler " +
                "   INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler " +
                "   LEFT JOIN inmobiliaria.departamento ON id_inmueble_departamento = id_inmueble " +
                "   INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_contratoalquiler "+
                "   INNER JOIN inmobiliaria.ciudad ON id_ciudad=id_ciudad_persona" +
                "   INNER JOIN inmobiliaria.provincia ON id_provincia=id_provincia_ciudad" +
                "     WHERE id_contratoalquiler="+rsComp.getInt("id_contratoalquiler_comprobantealquiler")+";");
            
            
            ResultSet rsPropietario = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                    "       mail_persona, telefono_persona, direccion_persona, estado_persona, tipo_inmueble, direccion_inmueble\n" +
                    "       tipo_persona, id_ciudad_persona, nombre_ciudad, nombre_provincia, direccion_inmueble, tipo_inmueble, piso_departamento, dpto_departamento \n" +
                    "   FROM inmobiliaria.contratoalquiler " +
                    "   INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler " +
                    "   LEFT JOIN inmobiliaria.departamento ON id_inmueble_departamento = id_inmueble " +
                    "   INNER JOIN inmobiliaria.persona ON id_propietario_inmueble = id_persona \n" +
                    "   INNER JOIN inmobiliaria.ciudad ON id_ciudad=id_ciudad_persona" +
                    "   INNER JOIN inmobiliaria.provincia ON id_provincia=id_provincia_ciudad" +
                    "     WHERE id_contratoalquiler="+rsComp.getInt("id_contratoalquiler_comprobantealquiler")+";");
            
            rsInquilino.next();
            rsPropietario.next();
            
            
            if (rsComp.getString("tipo_comprobantealquiler").equals("Liquidacion")){
                nombre = "Liquidacion-"+this.numeroComp+"-"+fechaDir+".pdf";
                nombreImagen = "liquidacion";
                
                this.total = rsComp.getFloat("total_comprobantealquiler");
                this.numeroComp = "Nº 0001-"+Datos.Procedimientos.completaConCero(rsComp.getString("nro_comprobantealquiler"),8);            
                this.fecha =  new SimpleDateFormat("dd/MM/yyyy").format(rsComp.getDate("fecha_comprobantealquiler"));
                this.datosPersonales = rsInquilino.getString("tipo_inmueble")+" - "+rsInquilino.getString("direccion_inmueble")+(rsInquilino.getString("tipo_inmueble").equals("Departamento") ? " Piso:"+rsInquilino.getString("piso_departamento")+"-"+rsInquilino.getString("dpto_departamento") : "")+"\n";            
                this.datosPersonales += rsPropietario.getString("razonsocial_persona").replace("|", "").trim()+" "+rsPropietario.getString("tipodoc_persona")+": "+rsPropietario.getString("nrodoc_persona")+"\n";
                this.datosPersonales += rsPropietario.getString("nombre_ciudad")+" "+rsPropietario.getString("nombre_provincia");
                
            } else {
                nombre = "ReciboAlquiler-"+this.numeroComp+"-"+fechaDir+".pdf";
                nombreImagen = "titular";

                this.total = rsComp.getFloat("total_comprobantealquiler");
                this.numeroComp = "Nº 0001-"+Datos.Procedimientos.completaConCero(rsComp.getString("nro_comprobantealquiler"),8);            
                this.fecha =  new SimpleDateFormat("dd/MM/yyyy").format(rsComp.getDate("fecha_comprobantealquiler"));
                this.datosPersonales = rsInquilino.getString("tipo_inmueble")+" - "+rsInquilino.getString("direccion_inmueble")+(rsInquilino.getString("tipo_inmueble").equals("Departamento") ? " Piso:"+rsInquilino.getString("piso_departamento")+"-"+rsInquilino.getString("dpto_departamento") : "")+"\n";            
                this.datosPersonales += rsInquilino.getString("razonsocial_persona").replace("|", "").trim()+" "+rsInquilino.getString("tipodoc_persona")+": "+rsInquilino.getString("nrodoc_persona")+"\n";
                this.datosPersonales += "A cuenta y orden de "+rsPropietario.getString("razonsocial_persona").replace("|", "").trim()+" "+rsPropietario.getString("tipodoc_persona")+": "+rsPropietario.getString("nrodoc_persona");
            }
            
            // Se crea el documento
            Document documento = new Document(PageSize.A4, 36.0f, 36.0f, 10.0f, 36.0f); //4° es el margin top
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            String subCarpeta = this.fecha.substring(3, 5)+"-"+this.fecha.substring(6, 10);;
            java.io.File folder = new java.io.File(System.getProperty("user.home") + "/Reportes/Comprobantes/"+subCarpeta);
            if (!folder.isDirectory())
                folder.mkdirs(); 
                    
            FileOutputStream ficheroPdf = new FileOutputStream(System.getProperty("user.home") + "/Reportes/Comprobantes/"+subCarpeta+"/"+nombre);
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            // Se abre el documento.
            documento.open();              
            
            Paragraph original = new Paragraph("ORIGINAL");   
            original.setAlignment(Element.ALIGN_CENTER);
            documento.add(original);
            
            escribirDB(documento, nombreImagen, idComprobante);
            
            int cantidad = this.cantItems;
            if (rsComp.getString("observacion_comprobantealquiler")!= null && !rsComp.getString("observacion_comprobantealquiler").equals("null") && !rsComp.getString("observacion_comprobantealquiler").trim().isEmpty()){
                documento.add(new Paragraph("OBS: "+rsComp.getString("observacion_comprobantealquiler"),FontFactory.getFont("arial", 9)));
                cantidad++;
            }
            if (cantidad>10) {
                documento.newPage();
            } else {
                for (int i=cantidad; i<=7; i++){
                    documento.add(new Paragraph(" ",FontFactory.getFont("arial", 11)));
                }            
                Paragraph firma = new Paragraph("_________________\nFIRMA");
                firma.setAlignment(Element.ALIGN_CENTER);
                documento.add(firma); 
                
                LineSeparator ls = new LineSeparator();
                documento.add(new Chunk(ls));
            }
            //documento.newPage();

            Paragraph duplicado = new Paragraph("DUPLICADO");   
            duplicado.setAlignment(Element.ALIGN_CENTER);
            documento.add(duplicado);
            escribirDB(documento, nombreImagen, idComprobante); 
            if (rsComp.getString("observacion_comprobantealquiler")!= null && !rsComp.getString("observacion_comprobantealquiler").equals("null") && !rsComp.getString("observacion_comprobantealquiler").trim().isEmpty()){
                documento.add(new Paragraph("OBS: "+rsComp.getString("observacion_comprobantealquiler"),FontFactory.getFont("arial", 9)));                
            }
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));            
            Paragraph firma = new Paragraph("_________________\nFIRMA");
            firma.setAlignment(Element.ALIGN_CENTER);
            documento.add(firma); 
            
            documento.close();      
            java.io.File miArchivo = new java.io.File (System.getProperty("user.home") + "/Reportes/Comprobantes/"+subCarpeta+"/"+nombre);
            java.awt.Desktop.getDesktop().open(miArchivo);            
            

        } catch(Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en 112 en imprimirDB de impresionComprobante: "+e.getMessage());
        }
    }   
    private void escribirDB(Document documento, String imagen, int idComprobante){
        try{
            Image foto = Image.getInstance("src/Facturacion/Impresion/"+imagen+".png");
            foto.scaleToFit(524, 100);           
            documento.add(foto);   
            Paragraph nroFecha = new Paragraph(this.numeroComp+"                    "+this.fecha,FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK));   
            nroFecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(nroFecha);
            documento.add(new Paragraph(this.datosPersonales,FontFactory.getFont("arial", 11)));            
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(3);
            float[] medidaCeldas = {0.6f, 1.5f, 1f};
            tabla.setWidths(medidaCeldas);  
            PdfPCell cell = new PdfPCell(new Phrase("Fecha",FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(cell);
            cell.setPhrase(new Phrase("Descripción",FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(cell);
            cell.setPhrase(new Phrase("Monto",FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(cell);
            
            ResultSet rsItems = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_item, descripcion_item, fecha_item, monto_item, id_comprobantealquiler_item\n" +
            "  FROM inmobiliaria.item " +
            "  WHERE id_comprobantealquiler_item="+idComprobante+";"); 
            int i = 0;
            while(rsItems.next()){
                tabla.addCell(new Phrase(String.valueOf(rsItems.getDate("fecha_item")),FontFactory.getFont("arial", 11)));
                tabla.addCell(new Phrase(rsItems.getString("descripcion_item"),FontFactory.getFont("arial", 11)));
                PdfPCell cell1 = new PdfPCell(new Phrase(String.valueOf(rsItems.getFloat("monto_item")),FontFactory.getFont("arial", 11)));
                cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tabla.addCell(cell1);
                i++;
            }
            this.cantItems = i;
            tabla.setWidthPercentage(100);            
            documento.add(tabla);
                       
            Paragraph totales = new Paragraph(armarTotalesDB(idComprobante), FontFactory.getFont("arial", 11, Font.NORMAL, BaseColor.BLACK));   
            totales.setAlignment(Element.ALIGN_RIGHT);
            documento.add(totales);
            totales.add(new Paragraph(" ")); 
        } catch (Exception e){
            Datos.Procedimientos.escribirEnLog("Error en linea 158 en escribirDB de la impresionComprobante: "+e.toString());
        }
    }       
    
    
    private String armarTotalesDB(int idComprobante){
        cantTipoPagos = 3;
        String cadena = "Total: $" + this.total + " - " + "\n";         
        ResultSet rsP = ProcedimientosSQL.SqlMetodo.runQuery("SELECT tipo_pagoalquiler, monto_pagoalquiler\n" +
            "  FROM inmobiliaria.pagoalquiler " +
            "  WHERE id_comprobantealquiler_pagoalquiler="+idComprobante+";"); 
        float totalPago = 0;
        boolean cc = false;
        try {
            while (rsP.next()){
                if (!rsP.getString("tipo_pagoalquiler").equals("Cuenta Corriente")){
                    cadena += rsP.getString("tipo_pagoalquiler")+": $"+rsP.getFloat("monto_pagoalquiler")+" - ";
                    totalPago += rsP.getFloat("monto_pagoalquiler");
                } else {
                    cc = true;
                }
            }
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 269 en armarTotalesDB de la impresionCOmprobante: "+e.toString());
        }
        if (cc){
            cadena += "Cuenta Corriente: $"+(this.total-totalPago);
        }
        return cadena;
    }    
    
    //--------------------------------------------------------------------------
    /*
    public void imprimirRecibo(String concepto, javax.swing.JTable tblPagos, float neto, float total, String nroComprobante, java.util.Date fecha, String datosPersonales){
        try {
            this.conceptoRecibo = concepto;
            this.total = total;
            this.neto = neto;
            this.numeroComp = nroComprobante;
            this.fecha = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
            this.datosPersonales = datosPersonales;
            
            String fechaDir = new SimpleDateFormat("ddMMyyyy").format(fecha);
            String nombre = "Recibo-"+nroComprobante+"-"+fechaDir+".pdf";
            // Se crea el documento
            Document documento = new Document(PageSize.A4, 36.0f, 36.0f, 16.0f, 36.0f); //4° es el margin top
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            String subCarpeta = this.fecha.substring(3, 5)+"-"+this.fecha.substring(6, 10);
            java.io.File folder = new java.io.File(System.getProperty("user.home") + "/Reportes/Comprobantes/"+subCarpeta);
            if (!folder.isDirectory())
                folder.mkdirs(); 
                    
            FileOutputStream ficheroPdf = new FileOutputStream(System.getProperty("user.home") + "/Reportes/Comprobantes/"+subCarpeta+"/"+nombre);
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            // Se abre el documento.
            documento.open();  
            
            Paragraph original = new Paragraph("ORIGINAL");   
            original.setAlignment(Element.ALIGN_CENTER);
            documento.add(original);
            escribirRecibo(documento);
            for (int i=0; i<3-(concepto.length()/79); i++){
                documento.add(new Paragraph(" ",FontFactory.getFont("arial", 11)));
            }           
            LineSeparator ls = new LineSeparator();                
            documento.add(new Chunk(ls));   
            Paragraph duplicado = new Paragraph("DUPLICADO");
            duplicado.setAlignment(Element.ALIGN_CENTER);
            documento.add(duplicado);
            escribirRecibo(documento); 
            
            documento.close();      
            java.io.File miArchivo = new java.io.File (System.getProperty("user.home") + "/Reportes/Comprobantes/"+subCarpeta+"/"+nombre);
            java.awt.Desktop.getDesktop().open(miArchivo);            
        } catch (Exception e){
            Datos.Procedimientos.escribirEnLog("Error en linea 208 en imprimirRecibo de la impresionComprobante: "+e.toString());
        }
        
    }  
    */
    public void imprimirReciboDB(int idComprobante){
        try {
            
            ResultSet rsComp = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_comprobante, tipo_comprobante, nro_comprobante, total_comprobante, \n" +
            "       fecha_comprobante, id_cliente_comprobante, id_vendedor_comprobante, \n" +
            "       observacion_comprobante, estado_comprobante\n" +
            "  FROM inmobiliaria.comprobante WHERE id_comprobante="+idComprobante+";");
            rsComp.next();
            ResultSet rsPersona = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                "       mail_persona, telefono_persona, direccion_persona, estado_persona \n" +
                "   FROM inmobiliaria.persona \n" +
                "   INNER JOIN inmobiliaria.ciudad ON id_ciudad=id_ciudad_persona" +
                "   INNER JOIN inmobiliaria.provincia ON id_provincia=id_provincia_ciudad" +
                "   WHERE id_persona="+rsComp.getInt("id_cliente_comprobante")+";");
            rsPersona.next();
                        
            this.conceptoRecibo = rsComp.getString("observacion_comprobante");
            this.total = rsComp.getFloat("total_comprobante");
            this.neto = rsComp.getFloat("total_comprobante");
            this.numeroComp = rsComp.getString("nro_comprobante");
            this.fecha = new SimpleDateFormat("dd/MM/yyyy").format(rsComp.getDate("fecha_comprobante"));
            if (rsComp.getInt("id_cliente_comprobante")==1){
                this.datosPersonales = "";
            } else {
                this.datosPersonales = rsPersona.getString("razonsocial_persona")+ "  DNI/CUIT: "+rsPersona.getString("nrodoc_persona")+"\n"
                    +rsPersona.getString("direccion_persona");
            }
            
            
            String fechaDir = new SimpleDateFormat("ddMMyyyy").format(rsComp.getDate("fecha_comprobante"));
            String nombre = "Recibo-"+rsComp.getString("nro_comprobante")+"-"+fechaDir+".pdf";
            // Se crea el documento
            Document documento = new Document(PageSize.A4, 36.0f, 36.0f, 16.0f, 36.0f); //4° es el margin top
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            java.io.File folder = new java.io.File(System.getProperty("user.home") + "/Reportes/Comprobantes/"+fechaDir);
            if (!folder.isDirectory())
                folder.mkdirs(); 
                    
            FileOutputStream ficheroPdf = new FileOutputStream(System.getProperty("user.home") + "/Reportes/Comprobantes/"+fechaDir+"/"+nombre);
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            // Se abre el documento.
            documento.open();  
            
            Paragraph original = new Paragraph("ORIGINAL");   
            original.setAlignment(Element.ALIGN_CENTER);
            documento.add(original);
            escribirRecibo(documento, idComprobante);
            for (int i=0; i<3-(conceptoRecibo.length()/79); i++){
                documento.add(new Paragraph(" ",FontFactory.getFont("arial", 11)));
            }           
            LineSeparator ls = new LineSeparator();                
            documento.add(new Chunk(ls));   
            Paragraph duplicado = new Paragraph("DUPLICADO");
            duplicado.setAlignment(Element.ALIGN_CENTER);
            documento.add(duplicado);
            escribirRecibo(documento, idComprobante); 
            
            documento.close();      
            java.io.File miArchivo = new java.io.File (System.getProperty("user.home") + "/Reportes/Comprobantes/"+fechaDir+"/"+nombre);
            java.awt.Desktop.getDesktop().open(miArchivo);    

        } catch (Exception e){
            e.printStackTrace();
        }
        
    }    
    private void escribirRecibo(Document documento, int idComp){
        try{
            Image foto = Image.getInstance("src/Facturacion/Impresion/recibo.png");
            foto.scaleToFit(524, 100);           
            documento.add(foto);   
            Paragraph nroFecha = new Paragraph(this.numeroComp+"                    "+this.fecha,FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK));   
            nroFecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(nroFecha);
            if (this.datosPersonales.isEmpty()){                
                documento.add(new Paragraph("Recibí la suma de "+Datos.NumeroALetra.NumeroALetra(total)));
            } else {
                documento.add(new Paragraph("Recibí de "+this.datosPersonales,FontFactory.getFont("arial", 11)));            
                documento.add(new Paragraph("La suma de "+Datos.NumeroALetra.NumeroALetra(total)));
            }            
            documento.add(new Paragraph("En concepto de:"));
            documento.add(new Paragraph("               "+conceptoRecibo));            
            Paragraph totales = new Paragraph(armarTotalesReciboDB(idComp),FontFactory.getFont("arial", 11, Font.NORMAL, BaseColor.BLACK));   
            totales.setAlignment(Element.ALIGN_RIGHT);
            documento.add(totales);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            Paragraph firma = new Paragraph("_________________\nFIRMA");
            firma.setAlignment(Element.ALIGN_CENTER);
            documento.add(firma);           
        } catch (Exception e){
            Datos.Procedimientos.escribirEnLog("Error en linea 235 en escribirRecibo de la impresionComprobante: "+e.toString());
        }
    }        

    private String armarTotalesReciboDB(int idComprobante){
        cantTipoPagos = 3;
        String cadena = "Total: $" + this.total + " - " + "\n";         
        ResultSet rsP = ProcedimientosSQL.SqlMetodo.runQuery("SELECT tipo_pago, monto_pago\n" +
            "  FROM inmobiliaria.pago" +
            "  WHERE id_comprobante_pago="+idComprobante+";"); 
        float totalPago = 0;
        boolean cc = false;
        try {
            while (rsP.next()){
                if (!rsP.getString("tipo_pagoalquiler").equals("Cuenta Corriente")){
                    cadena += rsP.getString("tipo_pagoalquiler")+": $"+rsP.getFloat("monto_pagoalquiler")+" - ";
                    totalPago += rsP.getFloat("monto_pagoalquiler");
                } else {
                    cc = true;
                }
            }
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 269 en armarTotalesDB de la impresionCOmprobante: "+e.toString());
        }
        if (cc){
            cadena += "Cuenta Corriente: $"+(this.total-totalPago);
        }
        return cadena;
    }
    
}
