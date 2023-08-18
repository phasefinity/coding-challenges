package dateutil

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DateUtilTest {
    @Test
    fun `test isWeekend`() {
        assertFalse(DateUtil.isWeekend(date("14.02.2022"))) // monday
        assertFalse(DateUtil.isWeekend(date("15.02.2022"))) // tuesday
        assertFalse(DateUtil.isWeekend(date("16.02.2022"))) // wednesday
        assertFalse(DateUtil.isWeekend(date("17.02.2022"))) // thursday
        assertFalse(DateUtil.isWeekend(date("18.02.2022"))) // friday
        assertTrue(DateUtil.isWeekend(date("19.02.2022"))) // saturday
        assertTrue(DateUtil.isWeekend(date("20.02.2022"))) // sunday
    }

    @Test
    fun `test add 3 business days ignoring holidays`() {
        // Add 3 business days and ignore holidays
        assertEquals(date("14.04.2022"), DateUtil.addBusinessDays(date("11.04.2022"), 3, emptySet()))
        assertEquals(date("15.04.2022"), DateUtil.addBusinessDays(date("12.04.2022"), 3, emptySet()))
        assertEquals(date("18.04.2022"), DateUtil.addBusinessDays(date("13.04.2022"), 3, emptySet()))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("14.04.2022"), 3, emptySet()))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("15.04.2022"), 3, emptySet()))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("16.04.2022"), 3, emptySet()))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("17.04.2022"), 3, emptySet()))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("18.04.2022"), 3, emptySet()))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("19.04.2022"), 3, emptySet()))
    }

    @Test
    fun `test add 0 business days using holidays`() {
        // Add 2 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("11.04.2022"), DateUtil.addBusinessDays(date("11.04.2022"), 0, holidays))
        assertEquals(date("12.04.2022"), DateUtil.addBusinessDays(date("12.04.2022"), 0, holidays))
        assertEquals(date("13.04.2022"), DateUtil.addBusinessDays(date("13.04.2022"), 0, holidays))
        assertEquals(date("14.04.2022"), DateUtil.addBusinessDays(date("14.04.2022"), 0, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("15.04.2022"), 0, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("16.04.2022"), 0, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("17.04.2022"), 0, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("18.04.2022"), 0, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("19.04.2022"), 0, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("20.04.2022"), 0, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("21.04.2022"), 0, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("22.04.2022"), 0, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("23.04.2022"), 0, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("24.04.2022"), 0, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("25.04.2022"), 0, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("26.04.2022"), 0, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("27.04.2022"), 0, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("28.04.2022"), 0, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("29.04.2022"), 0, holidays))
        assertEquals(date("02.05.2022"), DateUtil.addBusinessDays(date("30.04.2022"), 0, holidays))
        assertEquals(date("02.05.2022"), DateUtil.addBusinessDays(date("01.05.2022"), 0, holidays))
        assertEquals(date("02.05.2022"), DateUtil.addBusinessDays(date("02.05.2022"), 0, holidays))
        assertEquals(date("03.05.2022"), DateUtil.addBusinessDays(date("03.05.2022"), 0, holidays))
    }

    @Test
    fun `test add one business day using holidays`() {
        // Add 1 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("12.04.2022"), DateUtil.addBusinessDays(date("11.04.2022"), 1, holidays))
        assertEquals(date("13.04.2022"), DateUtil.addBusinessDays(date("12.04.2022"), 1, holidays))
        assertEquals(date("14.04.2022"), DateUtil.addBusinessDays(date("13.04.2022"), 1, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("14.04.2022"), 1, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("15.04.2022"), 1, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("16.04.2022"), 1, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("17.04.2022"), 1, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("18.04.2022"), 1, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("19.04.2022"), 1, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("20.04.2022"), 1, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("21.04.2022"), 1, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("22.04.2022"), 1, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("23.04.2022"), 1, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("24.04.2022"), 1, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("25.04.2022"), 1, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("26.04.2022"), 1, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("27.04.2022"), 1, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("28.04.2022"), 1, holidays))
        assertEquals(date("02.05.2022"), DateUtil.addBusinessDays(date("29.04.2022"), 1, holidays))
        assertEquals(date("03.05.2022"), DateUtil.addBusinessDays(date("30.04.2022"), 1, holidays))
        assertEquals(date("03.05.2022"), DateUtil.addBusinessDays(date("01.05.2022"), 1, holidays))
        assertEquals(date("03.05.2022"), DateUtil.addBusinessDays(date("02.05.2022"), 1, holidays))
        assertEquals(date("04.05.2022"), DateUtil.addBusinessDays(date("03.05.2022"), 1, holidays))
    }

    @Test
    fun `test add two business days using holidays`() {
        // Add 2 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("13.04.2022"), DateUtil.addBusinessDays(date("11.04.2022"), 2, holidays))
        assertEquals(date("14.04.2022"), DateUtil.addBusinessDays(date("12.04.2022"), 2, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("13.04.2022"), 2, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("14.04.2022"), 2, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("15.04.2022"), 2, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("16.04.2022"), 2, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("17.04.2022"), 2, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("18.04.2022"), 2, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("19.04.2022"), 2, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("20.04.2022"), 2, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("21.04.2022"), 2, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("22.04.2022"), 2, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("23.04.2022"), 2, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("24.04.2022"), 2, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("25.04.2022"), 2, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("26.04.2022"), 2, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("27.04.2022"), 2, holidays))
        assertEquals(date("02.05.2022"), DateUtil.addBusinessDays(date("28.04.2022"), 2, holidays))
        assertEquals(date("03.05.2022"), DateUtil.addBusinessDays(date("29.04.2022"), 2, holidays))
        assertEquals(date("04.05.2022"), DateUtil.addBusinessDays(date("30.04.2022"), 2, holidays))
        assertEquals(date("04.05.2022"), DateUtil.addBusinessDays(date("01.05.2022"), 2, holidays))
        assertEquals(date("04.05.2022"), DateUtil.addBusinessDays(date("02.05.2022"), 2, holidays))
        assertEquals(date("05.05.2022"), DateUtil.addBusinessDays(date("03.05.2022"), 2, holidays))
    }

    @Test
    fun `test add three business days using holidays`() {
        // Add 3 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("14.04.2022"), DateUtil.addBusinessDays(date("11.04.2022"), 3, holidays))
        assertEquals(date("19.04.2022"), DateUtil.addBusinessDays(date("12.04.2022"), 3, holidays))
        assertEquals(date("20.04.2022"), DateUtil.addBusinessDays(date("13.04.2022"), 3, holidays))
        assertEquals(date("21.04.2022"), DateUtil.addBusinessDays(date("14.04.2022"), 3, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("15.04.2022"), 3, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("16.04.2022"), 3, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("17.04.2022"), 3, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("18.04.2022"), 3, holidays))
        assertEquals(date("22.04.2022"), DateUtil.addBusinessDays(date("19.04.2022"), 3, holidays))
        assertEquals(date("26.04.2022"), DateUtil.addBusinessDays(date("20.04.2022"), 3, holidays))
        assertEquals(date("27.04.2022"), DateUtil.addBusinessDays(date("21.04.2022"), 3, holidays))
        assertEquals(date("28.04.2022"), DateUtil.addBusinessDays(date("22.04.2022"), 3, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("23.04.2022"), 3, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("24.04.2022"), 3, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("25.04.2022"), 3, holidays))
        assertEquals(date("29.04.2022"), DateUtil.addBusinessDays(date("26.04.2022"), 3, holidays))
        assertEquals(date("02.05.2022"), DateUtil.addBusinessDays(date("27.04.2022"), 3, holidays))
        assertEquals(date("03.05.2022"), DateUtil.addBusinessDays(date("28.04.2022"), 3, holidays))
        assertEquals(date("04.05.2022"), DateUtil.addBusinessDays(date("29.04.2022"), 3, holidays))
        assertEquals(date("05.05.2022"), DateUtil.addBusinessDays(date("30.04.2022"), 3, holidays))
        assertEquals(date("05.05.2022"), DateUtil.addBusinessDays(date("01.05.2022"), 3, holidays))
        assertEquals(date("05.05.2022"), DateUtil.addBusinessDays(date("02.05.2022"), 3, holidays))
        assertEquals(date("06.05.2022"), DateUtil.addBusinessDays(date("03.05.2022"), 3, holidays))
    }

    @Test
    fun `test add a lot of business days`() {
        val from = date("11.04.2022")
        assertEquals(date("11.04.2023"), DateUtil.addBusinessDays(from, 257, holidays))
        assertEquals(date("08.09.2023"), DateUtil.addBusinessDays(from, 365, holidays))
    }

    //    @Disabled
    @Test
    fun `test add a lot a lot a lot of business days`() {
        assertEquals(date("01.02.2022").plusYears(3833070), DateUtil.addBusinessDays(date("11.04.2022"), 1000000000, emptySet()))
    }

    //    @Disabled
    @Test
    fun `test add a lot a lot a lot of business days with a lot of holidays`() {
        val holidays = (0L..10000L)
            .flatMap { yearsToAdd ->
                listOf(
                    date("01.01.2022").plusYears(yearsToAdd),
                    date("02.02.2022").plusYears(yearsToAdd),
                    date("03.03.2022").plusYears(yearsToAdd),
                    date("04.04.2022").plusYears(yearsToAdd),
                    date("05.05.2022").plusYears(yearsToAdd),
                    date("06.06.2022").plusYears(yearsToAdd),
                    date("07.07.2022").plusYears(yearsToAdd),
                    date("08.08.2022").plusYears(yearsToAdd),
                    date("09.09.2022").plusYears(yearsToAdd)
                )
            }
        assertEquals(date("09.07.2022").plusYears(383553), DateUtil.addBusinessDays(date("11.04.2022"), 100000000, HashSet(holidays)))
    }

    private val holidays = setOf(
        date("15.04.2022"),  // Karfreitag
        date("17.04.2022"),  // Ostersonntag
        date("18.04.2022"),  // Ostermontag
        date("25.04.2022"),  // Sechseläuten
        date("01.05.2022"),  // 1. Mai
        date("26.05.2022") // Auffahrt
    )

    private fun date(date: String): LocalDate {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }
}
