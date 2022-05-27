package dhbw.projects.data.date;


import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void assignAttributesOfDate(){
        assertThrows(DateTimeException.class, () -> new Date("22222222"));
        assertThrows(StringIndexOutOfBoundsException.class, () -> new Date("2222111"));
    }

    @Test
    public void compareObjects(){
        Date date  = new Date("20220202");
        Date correctDate  = new Date("20220202");
        Date wrongDate  = new Date("20220203");

        assertEquals(date, correctDate);
        assertNotEquals(date, wrongDate);
    }

    @Test
    public void dateToString(){
        Date date = new Date("12341212");
        assertEquals(date.toString("-"), "1234-12-12");
    }

    /*@Test
    public void assignAttributesOfDate(){
        Date date = new Date(1234,12,31);
        assertEquals(date.getYear(), 1234);
        assertEquals(date.getMonth(), 12);
        assertEquals(date.getDay(), 31);

    }

    @Test
    public void compareObjects(){
        Date date  = new Date(2022,02,02);
        Date correctDate  = new Date(2022,02,02);
        Date wrongDate  = new Date(2022,02,03);

        assertEquals(date, correctDate);
        assertNotEquals(date, wrongDate);
    }*/

}