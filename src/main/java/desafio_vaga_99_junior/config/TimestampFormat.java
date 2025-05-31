package desafio_vaga_99_junior.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampFormat {
    public static String timestampFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy  HH'h' : mm'min' : ss's'");
        Date data = new Date();

        return simpleDateFormat.format(data);
    }
}
