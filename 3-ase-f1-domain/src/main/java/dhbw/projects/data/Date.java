package dhbw.projects.data;

import java.time.LocalDate;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) throws Exception{
        LocalDate date = LocalDate.of(year, month, day);
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }

    public Date(String dateAsString){       //YYYYMMDD
        if(dateAsString.matches("^\\d{8}$")){
            LocalDate date = LocalDate.of(
                    Integer.parseInt(dateAsString.substring(0, 4)),
                    Integer.parseInt(dateAsString.substring(4, 6)),
                    Integer.parseInt(dateAsString.substring(6, 8))
            );
            this.year = date.getYear();
            this.month = date.getMonthValue();
            this.day = date.getDayOfMonth();

        } else {
            throw new IllegalArgumentException("Wrong Date Format: " + dateAsString);
        }

    }

    public String toString() {
        return (year + "" + (month < 10? "0" + month : month)  + "" + (day < 10? "0" + day : day));
    }

    public String toFormatedString() {
        return (year + "-" + (month < 10? "0" + month : month)  + "-" + (day < 10? "0" + day : day));
    }
}
