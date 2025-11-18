
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "'Le' d MMMM 'de l''an' yyyy 'à' HH'h'mm'm' 'et' ss's'",
                Locale.FRENCH
        );

        return dateTime.format(formatter);
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALIAN);

        return date.format(formatter);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }

        // Format: HH:mm:ss.nnnnnnnnn
        // The sample output shows 9-digit nanoseconds with leading zeros
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnn");

        return time.format(formatter);
    }

    // public static void main(String[] args) {
    //     System.out.println(formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
    //     System.out.println(formatSimple(LocalDate.of(2022, 2, 13)));
    //     System.out.println(formatIso(LocalTime.of(16, 18, 56, 8495847)));
    // }
}
