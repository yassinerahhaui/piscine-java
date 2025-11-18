
import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        return LocalDateTime.parse(stringDate, DateTimeFormatter.ISO_DATE_TIME);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive() // <-- accept "monday", "Monday", "MONDAY"
                .appendPattern("EEEE d MMMM yyyy")
                .toFormatter(Locale.ENGLISH); // <-- required for English month/day names

        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        String[] parts = stringDate.split("[^0-9]+");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);

        boolean isEvening = stringDate.toLowerCase().contains("evening");
        boolean isMorning = stringDate.toLowerCase().contains("morning");

        if (isEvening && hour < 12) hour += 12;
        if (isMorning && hour == 12) hour = 0;
        return LocalTime.of(hour,minute,second);
    }
    // public static void main(String[] args) {
    //     System.out.println(parseIsoFormat("2022-04-25T20:51:28.709039322"));
    //     System.out.println(parseFullTextFormat("monday 25 april 2022"));
    //     System.out.println(parseTimeFormat("09 hours in the evening, 07 minutes and 23 seconds"));
    // }
}
