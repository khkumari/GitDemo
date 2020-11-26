package practice;

import java.text.*;
import java.util.Date;

public class Dateformat {
    public static void main(String[] args)
    {
        System.out.println(changeDateFormat("E,dd MMM yyyy","10/07/1991"));
    }
    public static String changeDateFormat(String dateformat, String date)
    {
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt= dateFormat.parse(date);
            DateFormat destformat= new SimpleDateFormat(dateformat);
            date= destformat.format(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }
}
