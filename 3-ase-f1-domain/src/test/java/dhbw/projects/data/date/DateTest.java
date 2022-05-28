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
        Object object = new Object();

        assertEquals(date, correctDate);
        assertNotEquals(date, wrongDate);
        assertNotEquals(object, date);

    }

    @Test
    public void dateToString(){
        Date date = new Date("12341212");
        Date date1 = new Date("12340101");
        assertEquals(date.toString("-"), "1234-12-12");
        assertEquals(date1.toString("-"), "1234-01-01");
    }

    @Test
    public void hashCodeTest(){
        Date date  = new Date("20220202");
        assertEquals(1972997, date.hashCode());

    }

}