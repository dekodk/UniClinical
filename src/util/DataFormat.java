package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormat {
    
    public static String formatarData(Date data) {
        if (data != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.format(data);
        }
        return ""; // ou null, dependendo do seu caso
    }
    
    public static String formatarDataParaSql(Date data) {
        if (data != null) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            return formato.format(data);
        }
        return "";
    }
}
