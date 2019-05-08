package com.luismosquera93.picoyplaca;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Luis Mosquera
 */
public class PicoPlaca{
    
    /**
     * @param date specefic day in format yyyy-mm-dd
     * @param car the car to evaluate in 'Pico y Placa'
     */
    public static boolean consultar(String dateString, String platenumber, String timeString) throws IOException,ParseException, Exception{
        double digit = new Car(platenumber).getLastnumber();
        Date date = Parameters.getDateFormat(dateString, Parameters.getFormatGeneral());
        Date time = Parameters.getDateFormat(timeString, Parameters.getFormatTime());
        double day = getDayOfWeek(date);
        if(!Parameters.isStarted())
            Parameters.loadParameters();
        if(date.after(Parameters.getFirstDay())){
            if(Math.ceil(digit/2)+1==day){
                if(!Parameters.getHolidays().contains(date)){
                    for (int i = 0; i < Parameters.getHours().size(); i++) {
                        if(time.after(Parameters.getHours().get(i)[0]) & time.before(Parameters.getHours().get(i)[1])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * @param date specefic day in format yyyy-mm-dd
     */
    public static int getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
