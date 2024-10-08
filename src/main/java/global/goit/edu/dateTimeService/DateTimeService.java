package global.goit.edu.dateTimeService;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeService {
    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss z";
    private static final String DEFAULT_TIME_ZONE = "UTC+3";

    private static Date date = Date.from(Instant.now());

    public static String get() {

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
                .withZone(ZoneId.of(DEFAULT_TIME_ZONE));

        String result = dateTimeFormat.format(date.toInstant());

        return result;
    }

    public static String get(String utc) {
        String result = "Invalid timezone";
        String timeZone = formatTimeZone(utc);

        try {
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
                    .withZone(ZoneId.of(timeZone));

            result = dateTimeFormat.format(date.toInstant());
        } catch (DateTimeException e) {

        }

        return result;
    }

    public static String setTimeToHTMLPage(String content, String time) {
        //System.out.println(content);
        StringBuilder result = new StringBuilder(content);

        result.replace((result.indexOf("h3") + 3), (result.indexOf("/h3") - 1), time);

        //System.out.println(result);

        return result.toString();
    }

    public static String formatTimeZone(String utc) {

        StringBuilder timeZone = new StringBuilder(utc.trim());
        timeZone.setCharAt(timeZone.indexOf("C") + 1, '+');

        System.out.println(timeZone);

        return timeZone.toString();
    }
}
