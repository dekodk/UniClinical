package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author deko_
 */
public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatarData(Date data) {
        if (data == null) {
            return "";
        }
        return sdf.format(data);
    }
}
