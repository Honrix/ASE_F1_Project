package dhbw.projects.data.date;


import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void throwExceptionWhenStringIsInvalid(){
        assertThrows(DateTimeException.class, ()-> new Date("22222222"));
        assertThrows(StringIndexOutOfBoundsException.class, ()-> new Date("1111111"));
        // TODO: do anything to fix this shit - assertThrows(DateTimeException.class, ()-> new Date("111111111"));
    }

    @Test
    public void assignAttributesOfDate(){
        Date date = new Date("12341231");
        assertEquals(date.getYear(), 1234);
        assertEquals(date.getMonth(), 12);
        assertEquals(date.getDay(), 31);

    }

    @Test
    public void compareObjects(){
        Date date  = new Date("20220202");
        Date correctDate  = new Date("20220202");
        Date wrongDate  = new Date("20220203");

        assertEquals(date, correctDate);
        assertNotEquals(date, wrongDate);
    }

}