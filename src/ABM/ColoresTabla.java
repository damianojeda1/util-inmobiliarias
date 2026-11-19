package ABM;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColoresTabla extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent
    (JTable table, Object value, boolean selected, boolean focused, int row, int column)  {
        String nom = (String) table.getValueAt(row, 0);
        boolean condicion = nom.equals("Casa") || nom.equals("Local") 
                || nom.equals("Departamento") || nom.equals("Campo") || nom.equals("Cochera") || nom.equals("Galpón");
        
        if (condicion){  
            setBackground(Color.lightGray);
        }else 
            setBackground(Color.white);

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }
 }