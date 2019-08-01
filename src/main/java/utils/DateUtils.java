package utils;

import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Log4j2
public class DateUtils {

    /**
     * Used to check the dates on the details pages
     *
     * @param dateString date in 'M/d/yyyy' format
     * @return date in 'MM/dd/yyyy' format
     */
    public static String convertDate(String dateString) {
        return convertDate(dateString, "M/d/yyyy", "MM/dd/yyyy");
    }

    /**
     * @param date
     * @param inPattern  format of input date, e.g. M/d/yyyy
     * @param outPattern format of output, e.g. MM-dd-yyyy
     * @return
     */
    public static String convertDate(String date, String inPattern, String outPattern) {
        if (StringUtils.isNotBlank(date)) {
            Date inputDate = null;
            SimpleDateFormat inputPattern = new SimpleDateFormat(inPattern);
            SimpleDateFormat outputPattern = new SimpleDateFormat(outPattern);
            try {
                inputDate = inputPattern.parse(date);
            } catch (ParseException e) {
                log.error(e.getMessage());
            }
            return outputPattern.format(inputDate);
        } else {
            return "";
        }
    }

    /**
     * @param countDays  - number of days to be added or discarded, e.g. -5 (5 days ago) or 365 (one year in the future)
     * @param outPattern - output format of the date
     * @return
     */
    public static String getDate(long countDays, String outPattern) {
        return convertDate(LocalDate.now().plusDays(countDays).toString(), "yyyy-MM-dd", outPattern);
    }

    /**
     * @param startDate - the date from which the countdown begins
     * @param endDate - the date of completion
     * @return - the number of days from the start date to the end date
     */
    public static long getPastDaysCount(String startDate, String endDate) {
        return DAYS.between(LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MMM d, yyyy")),
                LocalDate.parse(endDate, DateTimeFormatter.ofPattern("MMM d, yyyy")));
    }

    public static long getPastDaysInFormatCount(String startDate, String endDate) {
        return DAYS.between(LocalDate.parse(startDate, DateTimeFormatter.ofPattern("M/d/yyyy")),
                LocalDate.parse(endDate, DateTimeFormatter.ofPattern("M/d/yyyy")));
    }
}
