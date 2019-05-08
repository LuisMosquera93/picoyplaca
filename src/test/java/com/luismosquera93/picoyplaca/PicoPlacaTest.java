package com.luismosquera93.picoyplaca;

import java.text.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Luis Mosquera
 */
public class PicoPlacaTest {
    
    @Test
    public void testConsultarFalseTrue() {
        try{     
            assertEquals(true, PicoPlaca.consultar("2009-04-25", "PJY00431", "08:13"));
            assertEquals(true, PicoPlaca.consultar("2009-05-25", "ABC1421", "12:01"));
            assertEquals(false, PicoPlaca.consultar("2019-04-24", "pjy0005", "07:23"));
            assertEquals(false, PicoPlaca.consultar("2019-04-24", "PJY0006", "07:52"));
            assertEquals(true, PicoPlaca.consultar("2019-05-01", "PJY0005", "07:43"));
            assertEquals(true, PicoPlaca.consultar("2019-05-01", "PJY0006", "07:21"));
            assertEquals(false, PicoPlaca.consultar("2019-04-24", "PJY0005", "07:00"));
            assertEquals(false, PicoPlaca.consultar("2019-05-13", "PJY0001", "07:44"));
            assertEquals(true, PicoPlaca.consultar("2019-05-13", "PJY0001", "12:05"));
            assertEquals(false, PicoPlaca.consultar("2019-05-13", "PJY0002", "07:51"));
            assertEquals(true, PicoPlaca.consultar("2019-05-13", "PJY0002", "12:34"));
            assertEquals(false, PicoPlaca.consultar("2019-05-14", "PJY0003", "07:32"));
            assertEquals(true, PicoPlaca.consultar("2019-05-14", "PJY0003", "12:32"));
            assertEquals(false, PicoPlaca.consultar("2019-05-14", "PJY0004", "07:24"));
            assertEquals(true, PicoPlaca.consultar("2019-05-14", "PJY0004", "12:42"));
            assertEquals(false, PicoPlaca.consultar("2019-05-15", "PJY0005", "07:33"));
            assertEquals(true, PicoPlaca.consultar("2019-05-15", "PJY0005", "12:47"));
            assertEquals(false, PicoPlaca.consultar("2019-05-15", "PJY0006", "07:16"));
            assertEquals(true, PicoPlaca.consultar("2019-05-15", "PJY0006", "12:29"));
            assertEquals(false, PicoPlaca.consultar("2019-05-16", "PJY0007", "07:34"));
            assertEquals(true, PicoPlaca.consultar("2019-05-16", "PJY0007", "12:16"));
            assertEquals(false, PicoPlaca.consultar("2019-05-16", "PJY0008", "07:56"));
            assertEquals(true, PicoPlaca.consultar("2019-05-16", "PJY0008", "12:45"));
            assertEquals(false, PicoPlaca.consultar("2019-05-17", "PJY0009", "07:59"));
            assertEquals(true, PicoPlaca.consultar("2019-05-17", "PJY0009", "12:56"));
            assertEquals(false, PicoPlaca.consultar("2019-05-17", "PJY0000", "07:41"));
            assertEquals(true, PicoPlaca.consultar("2019-05-17", "PJY0000", "11:12"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    @Test
    public void testConsultarException() {
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("asdfwer", "PJY0005", "07:00");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJ100050", "07:00");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJ1000", "07:00");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJ1000", "kahlk");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJ10005", "07:00");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJY0E05", "07:00");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJY0005", "26:00");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJY0005", "07:60");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("2019-04-24", "PJY0005", "7:61");
        });
        assertThrows(Exception.class, () -> {
            PicoPlaca.consultar("", "", "");
        });
    }
    
}
