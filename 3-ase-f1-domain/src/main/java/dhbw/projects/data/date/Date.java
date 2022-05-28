package dhbw.projects.data.date;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year && month == date.month && day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

}
