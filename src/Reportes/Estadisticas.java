/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import static Datos.Procedimientos.escribirEnLog;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import Reportes.RowCopy;
import com.itextpdf.text.BaseColor;
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
import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Damian
 */
public class Estadisticas extends javax.swing.JDialog {
    int tipo;
    /**
     * Creates new form FechasResumenVentas
     */
    public Estadisticas(java.awt.Frame parent, boolean modal, int tipo) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
        this.dtFechaDesde.setDate(new java.util.Date());
        this.dtFechaHasta.setDate(new java.util.Date()); 
        this.tipo = tipo;
    }

    private void estadisticasDeProds(){     
        try {
            btnGenerar.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            int row = 0;
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("src/Reportes/estadisticas/productos.xls"));
            HSSFSheet sheet = workbook.getSheetAt(0);  
            //FECHA
            String fechaD = new SimpleDateFormat("dd/MM/yyyy").format(this.dtFechaDesde.getDate());
            String fechaH = new SimpleDateFormat("dd/MM/yyyy").format(this.dtFechaHasta.getDate());
            sheet.getRow(row).getCell(1).setCellValue("ESTADISTICAS EN VENTAS DESDE "+fechaD+" HASTA "+fechaH);        
            row += 3;
            String consultaProductos = "SELECT descripcion_itemcomprobante, SUM(cantidad_itemcomprobante) as cantidad\n" +
                "FROM inmobiliaria.itemcomprobante \n" +
                "	INNER JOIN inmobiliaria.producto ON id_producto = id_producto_itemcomprobante\n" +
                "	INNER JOIN inmobiliaria.categoria ON id_categoria = id_categoria_producto\n" +
                "	INNER JOIN inmobiliaria.comprobante ON id_comprobante = id_comprobante_itemcomprobante\n" +
                "WHERE tipo_comprobante='Recibo X' AND fecha_comprobante>='"+fechaD.toString()+"' \n"+
                "      AND fecha_comprobante<='"+fechaH.toString()+"' AND estado_comprobante='Aprobado'\n" +
                "GROUP BY descripcion_itemcomprobante\n" +
                "ORDER BY cantidad DESC;";
            java.sql.ResultSet rsProd = ProcedimientosSQL.SqlMetodo.runQuery(consultaProductos);
            while (rsProd.next()){
                RowCopy.copyRow(workbook, sheet, row, row+1);
                HSSFRow fila = sheet.getRow(row);
                fila.getCell(1).setCellValue(rsProd.getString(1));
                fila.getCell(2).setCellValue(rsProd.getInt(2));
                row++;
            }
            row += 4;
            String consultaCategorias = "SELECT nombre_categoria, SUM(cantidad_itemcomprobante) as cantidad, SUM(cantidad_itemcomprobante * preciounitario_itemcomprobante) as total\n" +
                "FROM (((inmobiliaria.itemcomprobante \n" +
                "	INNER JOIN inmobiliaria.producto ON id_producto = id_producto_itemcomprobante)\n" +
                "	INNER JOIN inmobiliaria.categoria ON id_categoria = id_categoria_producto)\n" +
                "	INNER JOIN inmobiliaria.comprobante ON id_comprobante = id_comprobante_itemcomprobante)\n" +
                "WHERE tipo_comprobante='Recibo X' AND fecha_comprobante>='"+fechaD.toString()+"' \n"+
                "      AND fecha_comprobante<='"+fechaH.toString()+"' AND estado_comprobante='Aprobado'\n" +
                "GROUP BY id_categoria\n" +
                "ORDER BY cantidad DESC;";
            java.sql.ResultSet rsCat = ProcedimientosSQL.SqlMetodo.runQuery(consultaCategorias);
            float total=0;
            while (rsCat.next()){
                RowCopy.copyRow(workbook, sheet, row, row+1);
                HSSFRow fila = sheet.getRow(row);
                fila.getCell(1).setCellValue(rsCat.getString(1));
                fila.getCell(2).setCellValue(rsCat.getInt(2));
                fila.getCell(3).setCellValue("$"+rsCat.getFloat(3));
                total += rsCat.getFloat(3);
                row++;
            }
            row+=2;
            sheet.getRow(row).getCell(2).setCellValue("$"+Datos.Procedimientos.truncar(total));

            //GUARDAR
            String fechaDesde = new SimpleDateFormat("ddMMyyyy").format(this.dtFechaDesde.getDate());
            String fechaHasta = new SimpleDateFormat("ddMMyyyy").format(this.dtFechaHasta.getDate());            
            guardarXLS(workbook,"Ventas","EstadisticasProds"+fechaDesde+"-"+fechaHasta+".xls");
            btnGenerar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }  catch (Exception ex){
            ex.printStackTrace();
            Datos.Procedimientos.escribirEnLog("Impresion estads de prods!! \n"+ex.toString());
        }    
    }  
    
    public static void imprimirMovimientos(String datos, JTable tbl){
        try {
            Document documento = new Document(PageSize.A4, 36.0f, 36.0f, 10.0f, 36.0f); //4° es el margin top
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            java.io.File folder = new java.io.File(System.getProperty("user.home") + "/Reportes/Movimientos/");
            if (!folder.isDirectory())
                folder.mkdirs(); 
            String fechaDir = new SimpleDateFormat("ddMMyyyy").format(new java.util.Date());
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
            FileOutputStream ficheroPdf = new FileOutputStream(System.getProperty("user.home") + "/Reportes/Movimientos/"+fechaDir+".pdf");
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            // Se abre el documento.
            documento.open();  
            
            Image foto = Image.getInstance("src/Recursos/sai/sai30.PNG");
            foto.scaleToFit(350, 80);
            foto.setAbsolutePosition(450f, 750f);
            documento.add(foto);            
            
            
            Paragraph pfecha = new Paragraph("MOVIMIENTOS DE CONTRATO  -  "+fecha+"                                        \n ",FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK));   
            pfecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pfecha);
            Paragraph ptitulo = new Paragraph(datos,FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK));
            documento.add(ptitulo);
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(3);
            float[] medidaCeldas = {0.6f, 2f, 0.4f};
            tabla.setWidths(medidaCeldas);
            PdfPCell cell = new PdfPCell(new Phrase("Fecha",FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK)));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(cell);
            cell.setPhrase(new Phrase("Descripción",FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(cell);
            cell.setPhrase(new Phrase("Monto",FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(cell);
            
            for (int i=0; i<tbl.getRowCount(); i++){
                tabla.addCell(new Phrase(tbl.getValueAt(i, 0).toString(),FontFactory.getFont("arial", 11)));
                tabla.addCell(new Phrase(tbl.getValueAt(i, 1).toString(),FontFactory.getFont("arial", 11)));
                PdfPCell cell1 = new PdfPCell(new Phrase(String.format("%.2f",(Float) tbl.getValueAt(i, 2)),FontFactory.getFont("arial", 11)));
                cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tabla.addCell(cell1);                
            }

            tabla.setWidthPercentage(100);            
            documento.add(tabla);             
            documento.close();      
            java.io.File miArchivo = new java.io.File(System.getProperty("user.home") + "/Reportes/Movimientos/"+fechaDir+".pdf");
            java.awt.Desktop.getDesktop().open(miArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede generar, cierre los reportes generados que haya abierto");
            e.printStackTrace();
            Datos.Procedimientos.escribirEnLog(e.toString());
        }        
    }    
    
    public void resumenVentas(){     
        try {
            
            btnGenerar.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            int row = 0;
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("src/Reportes/estadisticas/resumenventas.xls"));
            HSSFSheet sheet = workbook.getSheetAt(0);           
            
            //FECHA
            String fechaD = new SimpleDateFormat("dd/MM/yyyy").format(this.dtFechaDesde.getDate());
            String fechaH = new SimpleDateFormat("dd/MM/yyyy").format(this.dtFechaHasta.getDate());
            
            sheet.getRow(row).getCell(1).setCellValue("RESUMEN DE VENTAS DESDE "+fechaD+" HASTA "+fechaH);           
            
            row += 2;
            String consultaProductos = "SELECT tipo_comprobante, nro_comprobante, total_comprobante, fecha_comprobante, id_comprobante\n" +
                "FROM inmobiliaria.comprobante\n" +
                "WHERE fecha_comprobante>='"+fechaD.toString()+"' AND fecha_comprobante<='"+fechaH.toString()+"' AND estado_comprobante='Aprobado'\n" +
                "ORDER BY fecha_comprobante;";
            java.sql.ResultSet rsProd = ProcedimientosSQL.SqlMetodo.runQuery(consultaProductos);
            float totalF = 0;
            float totalR = 0;
            while (rsProd.next()){
                if (!rsProd.getString(1).equals("Recibo")){
                    RowCopy.copyRow(workbook, sheet, row, row+1);
                    HSSFRow fila = sheet.getRow(row);
                    fila.getCell(1).setCellValue(rsProd.getString(1));
                    fila.getCell(2).setCellValue(rsProd.getString(2));
                    
                    java.sql.ResultSet rsPagos = ProcedimientosSQL.SqlMetodo.runQuery("SELECT tipo_pago, monto_pago\n" +
                        "  FROM inmobiliaria.pago WHERE id_comprobante_pago="+rsProd.getInt(5)+";");
                    while (rsPagos.next()){
                        if (rsPagos.getString(1).equals("Efectivo"))
                            fila.getCell(4).setCellValue("$"+rsPagos.getFloat(2));
                        if (rsPagos.getString(1).equals("Cheque"))
                            fila.getCell(5).setCellValue("$"+rsPagos.getFloat(2));
                        if (rsPagos.getString(1).equals("Tarjeta De Debito"))
                            fila.getCell(6).setCellValue("$"+rsPagos.getFloat(2));
                        if (rsPagos.getString(1).equals("Tarjeta De Credito"))
                            fila.getCell(7).setCellValue("$"+rsPagos.getFloat(2));
                        if (rsPagos.getString(1).equals("Cuenta Corriente"))
                            fila.getCell(8).setCellValue("$"+rsPagos.getFloat(2));                        
                    }
                    
                    if (rsProd.getString(1).equals("Recibo X")){
                        fila.getCell(9).setCellValue("$"+rsProd.getFloat(3));
                        totalF+=rsProd.getFloat(3);
                    } else {
                        fila.getCell(9).setCellValue("$-"+rsProd.getFloat(3));
                        totalR+=rsProd.getFloat(3);
                    }
                    fila.getCell(3).setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(rsProd.getDate(4)));
                    row++;
                }
            }
            row += 2;
                
            sheet.getRow(row).getCell(8).setCellValue("$"+Datos.Procedimientos.truncar(totalF));
            row++;
            sheet.getRow(row).getCell(8).setCellValue("$"+Datos.Procedimientos.truncar(totalR));
            row++;
            sheet.getRow(row).getCell(8).setCellValue("$"+Datos.Procedimientos.truncar((totalF-totalR)));

            //GUARDAR
            String fechaDesde = new SimpleDateFormat("ddMMyyyy").format(this.dtFechaDesde.getDate());
            String fechaHasta = new SimpleDateFormat("ddMMyyyy").format(this.dtFechaHasta.getDate());  
                   
            guardarXLS(workbook,"Ventas","ResumenVentas"+fechaDesde+"-"+fechaHasta+".xls");
        }  catch (Exception ex){
            ex.printStackTrace();
            Datos.Procedimientos.escribirEnLog("Impresion resumen ventas!! \n"+ex.toString());
        }  
        btnGenerar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }    
    
    public static void planillaCaja(Date dtCajaDiaria, JTable tblI, JTable tblE, String totalI, String totalE, String total){              
        try {       
            int row = 0;            
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("src/Reportes/estadisticas/caja.xls"));
            HSSFSheet sheet = workbook.getSheetAt(0);                 

            //FECHA
            String fechaG = new SimpleDateFormat("ddMMyyyy").format(dtCajaDiaria);
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(dtCajaDiaria);
            sheet.getRow(row).getCell(0).setCellValue("CIERRE DE CAJA DE "+fecha);
            
            row += 4;
            
            //INGRESOS
            for (int i=0; i<tblI.getRowCount(); i++){
                RowCopy.copyRow(workbook, sheet, row, row+1);
                HSSFRow fila = sheet.getRow(row);
                fila.getCell(0).setCellValue(""+tblI.getValueAt(i, 0));
                fila.getCell(4).setCellValue(""+(Float)tblI.getValueAt(i, 2));
                row++;
            }
            
            row += 4;
            
            //EGRESOS
            for (int i=0; i<tblE.getRowCount(); i++){
                RowCopy.copyRow(workbook, sheet, row, row+1);
                HSSFRow fila = sheet.getRow(row);
                fila.getCell(0).setCellValue(""+tblE.getValueAt(i, 1));
                fila.getCell(4).setCellValue(""+(String)((Objetos.Tripla)tblE.getValueAt(i, 0)).getTercero());
                row++;
            }
            
            row += 3;            
            sheet.getRow(row).getCell(4).setCellValue(totalI);
            sheet.getRow(row+1).getCell(4).setCellValue(totalE);
            float tot = Float.parseFloat(total);
            sheet.getRow(row+2).getCell(4).setCellValue(""+tot);              
            
            guardarXLS(workbook,"Caja","ResumenCaja"+fechaG+".xls");

        } catch (Exception e){
            e.printStackTrace();
            escribirEnLog("REPORTE -> planillaCaja - "+e.getMessage());
        }
    }   
    
    private void balanceCaja(){     
        try {
            btnGenerar.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            int row = 0;
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("src/Reportes/estadisticas/balanceCaja.xls"));
            HSSFSheet sheet = workbook.getSheetAt(0);  
            //FECHA
            String fechaD = new SimpleDateFormat("dd/MM/yyyy").format(this.dtFechaDesde.getDate());
            String fechaH = new SimpleDateFormat("dd/MM/yyyy").format(this.dtFechaHasta.getDate());
            sheet.getRow(row).getCell(1).setCellValue("BALANCE DE CAJAS DESDE "+fechaD+" HASTA "+fechaH);        
            row += 2;
            String consultaCajas = "SELECT fecha_cajadiaria, apertura_cajadiaria, cierre_cajadiaria\n" +
                "  FROM inmobiliaria.cajadiaria "
                + "WHERE fecha_cajadiaria>='"+fechaD.toString()+"' AND fecha_cajadiaria<='"+fechaH.toString()+"'\n"
                + " ORDER BY fecha_cajadiaria;";
            java.sql.ResultSet rsCaja = ProcedimientosSQL.SqlMetodo.runQuery(consultaCajas);
            float total=0;
            while (rsCaja.next()){
                RowCopy.copyRow(workbook, sheet, row, row+1);
                HSSFRow fila = sheet.getRow(row);
                fila.getCell(1).setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(rsCaja.getDate(1)));
                fila.getCell(2).setCellValue(Datos.Procedimientos.truncar(rsCaja.getFloat(2)));
                fila.getCell(3).setCellValue(Datos.Procedimientos.truncar(rsCaja.getFloat(3)));
                total += (rsCaja.getFloat(3)-rsCaja.getFloat(2));
                fila.getCell(4).setCellValue(Datos.Procedimientos.truncar(rsCaja.getFloat(3)-rsCaja.getFloat(2)));
                row++;
            }
            row += 2;
  
            sheet.getRow(row).getCell(4).setCellValue("$"+Datos.Procedimientos.truncar(total));

            //GUARDAR
            String fechaDesde = new SimpleDateFormat("ddMMyyyy").format(this.dtFechaDesde.getDate());
            String fechaHasta = new SimpleDateFormat("ddMMyyyy").format(this.dtFechaHasta.getDate());            
            guardarXLS(workbook,"Balances","BalanceCaja"+fechaDesde+"-"+fechaHasta+".xls");
            btnGenerar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }  catch (Exception ex){
            ex.printStackTrace();
            Datos.Procedimientos.escribirEnLog("Impresion balance caja!! \n"+ex.toString());
        }    
    }    
    
    private static void guardarXLS(HSSFWorkbook libro, String carpeta, String nombre) {
        try  {
            java.io.File folder = new java.io.File(System.getProperty("user.home") + "/Reportes/"+carpeta);
            if (!folder.isDirectory())
                folder.mkdirs(); 

            FileOutputStream elFichero = new FileOutputStream(System.getProperty("user.home") + "/Reportes/"+carpeta+"/"+nombre);
            libro.write(elFichero);

            elFichero.close();  
            

            java.io.File miArchivo = new java.io.File (System.getProperty("user.home") + "/Reportes/"+carpeta+"/"+nombre);
            java.awt.Desktop.getDesktop().open(miArchivo);
            //miArchivo.setReadOnly();
        
        }catch(Exception ex){
            escribirEnLog(ex.toString());
             JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado",
               "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        panel1 = new org.edisoncor.gui.panel.Panel();
        dtFechaDesde = new org.jdesktop.swingx.JXDatePicker();
        dtFechaHasta = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGenerar = new org.edisoncor.gui.button.ButtonColoredAction();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccione las fechas");
        setResizable(false);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo2.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Indique el intérvalo de fechas que desee");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*");

        btnGenerar.setText("Generar");
        btnGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenerarMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("para el reporte");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMousePressed
        // TODO add your handling code here:
        switch (tipo){
            case 1:  estadisticasDeProds(); break;
            case 2:  resumenVentas(); break;
            case 3:  balanceCaja(); break;
        }
        this.dispose();
    }//GEN-LAST:event_btnGenerarMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Estadisticas dialog = new Estadisticas(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction btnGenerar;
    private org.jdesktop.swingx.JXDatePicker dtFechaDesde;
    private org.jdesktop.swingx.JXDatePicker dtFechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
