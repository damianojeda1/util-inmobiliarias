package Listados;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColoresTablaContratoA extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent
    (JTable table, Object value, boolean selected, boolean focused, int row, int column) {        
        try {  
            setBackground(Color.white);            
            Date finContrato = new SimpleDateFormat("dd/MM/yyyy").parse(table.getValueAt(row, 9).toString());
            Date hoy = new Date();                  
            if (hoy.compareTo(finContrato)>0){
                setBackground(new Color(255, 170, 170));
            } else if (difDias(hoy, finContrato)<31){
                setBackground(new Color(255, 200, 65));
            } else {
                if (column==4){
                    Date debe = new SimpleDateFormat("MM/yyyy").parse(table.getValueAt(row, column).toString());                
                    if (hoy.compareTo(debe)>=0){
                        setBackground(new Color(255, 170, 170));                
                    }
                }                
            }            
            if (column==6){
                if (table.getValueAt(row, 6).toString().equals("DEBE")){
                    setBackground(new Color(255, 200, 200));     
                } else {
                    setBackground(new Color(200, 255, 200));     
                }
            }           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    super.getTableCellRendererComponent(table, value, selected, focused, row, column);
    return this;
    }
    
    
    private long difDias(Date a, Date b){
        
        return (b.getTime()/(1000*60*60*24)) - (a.getTime()/(1000*60*60*24))  ;
    }
 }

