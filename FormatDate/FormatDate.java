import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
    if (dateTime == null) return null;

    // Le 22 août de l'an 2021 à 13h25m et 46s
    return String.format(
        "Le %1$td %1$tB de l'an %1$tY à %1$tHh%1$tMm et %1$tSs",
        dateTime
    );
}


    public static String formatSimple(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALIAN);

        return date.format(formatter);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;

        // Format: HH:mm:ss.nnnnnnnnn
        // The sample output shows 9-digit nanoseconds with leading zeros
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnn");

        return time.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
        System.out.println(formatSimple(LocalDate.of(2022, 2, 13)));
        System.out.println(formatIso(LocalTime.of(16, 18, 56, 8495847)));
    }
}