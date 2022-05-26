package dhbw.projects.data.date;

import java.time.LocalDate;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date(String dateAsString){
        LocalDate date = LocalDate.of(
                Integer.parseInt(dateAsString.substring(0, 4)),
                Integer.parseInt(dateAsString.substring(4, 6)),
                Integer.parseInt(dateAsString.substring(6, 8)));
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();

    }

    public String toString(String seperator) {
        return (year + seperator + (month < 10? "0" + month : month)  + seperator + (day < 10? "0" + day : day));
    }
}
