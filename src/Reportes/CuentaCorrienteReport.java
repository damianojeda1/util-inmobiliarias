/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Vane
 */
public class CuentaCorrienteReport {
    public static void generar(String nombre, String direccion, String telefono, Date fecE, Date fecD, Date fecH, java.math.BigDecimal saldoI){     
        try {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream ("src/Reportes/cuentaCorrienteReport.jrxml");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                Datos.Procedimientos.escribirEnLog(ex.toString());
            }
                java.io.File folder = new java.io.File(System.getProperty("user.home") + "/Reportes/Cuentas Corrientes");
                if (!folder.isDirectory())
                    folder.mkdirs();
                JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                HashMap params = new HashMap();
                params.put("razonSocial",nombre);
                params.put("domicilio",direccion);
                params.put("telefono",telefono);
                params.put("fechaEmision",fecE);
                if (fecD == null && fecH == null){
                    fecD = new java.sql.Date(19000101);
                    fecH = Calendar.getInstance().getTime();
                }
                    
                params.put("fecDesde",fecD);
                params.put("fecHasta",fecH);
                params.put("saldoInicial",saldoI);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ProcedimientosSQL.Conexion.getInstance());
                String nombrePDF = System.getProperty("user.home") + 
                        "/Reportes/Cuentas Corrientes/cuentaCorriente-"+nombre+".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, nombrePDF);
                java.io.File miArchivo = new java.io.File (nombrePDF);
                java.awt.Desktop.getDesktop().open(miArchivo);
            } catch (Exception e) {
                Datos.Procedimientos.escribirEnLog("Error en la linea 62 en generar en CuentaCorrienteReport.java en Reportes: "+e.toString());
            }
       }
}
