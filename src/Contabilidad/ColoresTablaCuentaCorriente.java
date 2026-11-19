package Contabilidad;

import Listados.*;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColoresTablaCuentaCorriente extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent
    (JTable table, Object value, boolean selected, boolean focused, int row, int column) {        
        try {      
            if (table.getValueAt(row, 1).toString().equals("Recibo de Alquiler")){
                setBackground(Color.WHITE);      
            } else {
                setBackground(new Color(229, 255, 255));     
            }
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }
    
 }

