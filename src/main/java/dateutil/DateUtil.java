package dateutil;

import java.time.LocalDate;
import java.util.Set;

public class DateUtil {
    /**
     * Return true when the given date is on a weekend.
     */
    public static boolean isWeekend(LocalDate date) {
        return false;
    }

    /**
     * Add the amount of business days to the given date. Weekends and the provided holidays are no business days.
     * When starting on a holiday or a weekend day, only start adding business days from the next business day.
     * The result is expected to be a business day.
     * When adding 0 business days, return the starting date or the next business day when it's on a weekend or holiday.
     * <p>
     * i.e. Adding 3 business days from a saturday should return thursday (without holidays).
     */
    public static LocalDate addBusinessDays(LocalDate from, int businessDays, Set<LocalDate> holidays) {
        return null;
    }
}
