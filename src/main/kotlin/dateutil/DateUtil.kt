package dateutil

import java.time.LocalDate

object DateUtil {
    /**
     * Return true when the given date is on a weekend.
     */
    fun isWeekend(date: LocalDate): Boolean {
        return false
    }

    /**
     * Add the amount of business days to the given date. Weekends and the provided holidays are no business days.
     * When starting on a holiday or a weekend day, only start adding business days from the next business day.
     * The result is expected to be a business day.
     * When adding 0 business days, return the starting date or the next business day when it's on a weekend or holiday.
     *
     *
     * i.e. Adding 3 business days from a saturday should return thursday (without holidays).
     */
    fun addBusinessDays(from: LocalDate?, businessDays: Int, holidays: Set<LocalDate>): LocalDate {
        TODO("implement addBusinessDays")
    }
}
