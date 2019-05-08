package com.luismosquera93.picoyplaca;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Luis Mosquera
 */
public class Parameters {
    private static final SimpleDateFormat formatGeneral = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
    
    private static boolean started=false;
    private static String firstDay;
    private static ArrayList<Date[]> hours = new ArrayList<Date[]>();
    private static ArrayList<Date> holidays = new ArrayList<Date>();
    
    public static void loadParameters() throws ParserConfigurationException, SAXException, IOException, ParseException {
        File archivo = new File("Parameters.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(archivo);
        document.getDocumentElement().normalize();
        firstDay = document.getElementsByTagName("begin").item(0).getTextContent();
        NodeList hours = document.getElementsByTagName("hours");
        NodeList holidays = document.getElementsByTagName("holiday");
        for (int temp = 0; temp < holidays.getLength(); temp++) {
            Parameters.getHolidays().add(getDateFormat(holidays.item(temp).getTextContent(), getFormatGeneral()));
        }
        for (int temp = 0; temp < hours.getLength(); temp++) {
            Node nodo = hours.item(temp);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;
                Date[] hourTemp = {
                    getDateFormat(element.getElementsByTagName("timestart").item(0).getTextContent(), getFormatTime()),
                    getDateFormat(element.getElementsByTagName("timeend").item(0).getTextContent(), getFormatTime())
                };
                Parameters.hours.add(hourTemp);
            }
        }
        started=true;
    }

    /**
     * @param date specefic day in format yyyy-mm-dd
     */
    public static Date getDateFormat(String date, SimpleDateFormat format) throws ParseException{
        Date answer = new Date();
        answer = format.parse(date);
        if(format.equals(formatTime)){
            String[] temp = date.split(":");
            if(Integer.parseInt(temp[0])>24 || Integer.parseInt(temp[1])>59)
                throw new ParseException("Bad time format", 0);
        }
        return answer;
    }   

    /**
     * @return the firstDay
     */
    public static Date getFirstDay() throws ParseException{
        return getDateFormat(firstDay, getFormatGeneral());
    }

    /**
     * @return the holidays
     */
    public static ArrayList<Date> getHolidays() {
        return holidays;
    }

    /**
     * @return the hours
     */
    public static ArrayList<Date[]> getHours() {
        return hours;
    }

    /**
     * @return the formatGeneral
     */
    public static SimpleDateFormat getFormatGeneral() {
        return formatGeneral;
    }

    /**
     * @return the formatTime
     */
    public static SimpleDateFormat getFormatTime() {
        return formatTime;
    }

    /**
     * @return the started
     */
    public static boolean isStarted() {
        return started;
    }
}
