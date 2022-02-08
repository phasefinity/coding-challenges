package dateutil;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dateutil.DateUtil.addBusinessDays;
import static dateutil.DateUtil.isWeekend;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTest {
    private final static Set<LocalDate> holidays = Set.of(
            date("15.04.2022"), // Karfreitag
            date("17.04.2022"), // Ostersonntag
            date("18.04.2022"), // Ostermontag
            date("25.04.2022"), // Sechseläuten
            date("01.05.2022"), // 1. Mai
            date("26.05.2022") // Auffahrt
    );

    @Test
    public void testIsWeekend() {
        assertFalse(isWeekend(date("14.02.2022"))); // monday
        assertFalse(isWeekend(date("15.02.2022"))); // tuesday
        assertFalse(isWeekend(date("16.02.2022"))); // wednesday
        assertFalse(isWeekend(date("17.02.2022"))); // thursday
        assertFalse(isWeekend(date("18.02.2022"))); // friday
        assertTrue(isWeekend(date("19.02.2022"))); // saturday
        assertTrue(isWeekend(date("20.02.2022"))); // sunday
    }

    @Test
    public void testAddThreeBusinessDaysIgnoringHolidays() {
        // Add 3 business days and ignore holidays
        assertEquals(date("14.04.2022"), addBusinessDays(date("11.04.2022"), 3, emptySet()));
        assertEquals(date("15.04.2022"), addBusinessDays(date("12.04.2022"), 3, emptySet()));
        assertEquals(date("18.04.2022"), addBusinessDays(date("13.04.2022"), 3, emptySet()));
        assertEquals(date("19.04.2022"), addBusinessDays(date("14.04.2022"), 3, emptySet()));
        assertEquals(date("20.04.2022"), addBusinessDays(date("15.04.2022"), 3, emptySet()));
        assertEquals(date("21.04.2022"), addBusinessDays(date("16.04.2022"), 3, emptySet()));
        assertEquals(date("21.04.2022"), addBusinessDays(date("17.04.2022"), 3, emptySet()));
        assertEquals(date("21.04.2022"), addBusinessDays(date("18.04.2022"), 3, emptySet()));
        assertEquals(date("22.04.2022"), addBusinessDays(date("19.04.2022"), 3, emptySet()));
    }

    @Test
    public void testAddZeroBusinessDaysUsingHolidays() {
        // Add 2 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("11.04.2022"), addBusinessDays(date("11.04.2022"), 0, holidays));
        assertEquals(date("12.04.2022"), addBusinessDays(date("12.04.2022"), 0, holidays));
        assertEquals(date("13.04.2022"), addBusinessDays(date("13.04.2022"), 0, holidays));
        assertEquals(date("14.04.2022"), addBusinessDays(date("14.04.2022"), 0, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("15.04.2022"), 0, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("16.04.2022"), 0, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("17.04.2022"), 0, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("18.04.2022"), 0, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("19.04.2022"), 0, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("20.04.2022"), 0, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("21.04.2022"), 0, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("22.04.2022"), 0, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("23.04.2022"), 0, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("24.04.2022"), 0, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("25.04.2022"), 0, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("26.04.2022"), 0, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("27.04.2022"), 0, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("28.04.2022"), 0, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("29.04.2022"), 0, holidays));
        assertEquals(date("02.05.2022"), addBusinessDays(date("30.04.2022"), 0, holidays));
        assertEquals(date("02.05.2022"), addBusinessDays(date("01.05.2022"), 0, holidays));
        assertEquals(date("02.05.2022"), addBusinessDays(date("02.05.2022"), 0, holidays));
        assertEquals(date("03.05.2022"), addBusinessDays(date("03.05.2022"), 0, holidays));
    }

    @Test
    public void testAddOneBusinessDayUsingHolidays() {
        // Add 1 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("12.04.2022"), addBusinessDays(date("11.04.2022"), 1, holidays));
        assertEquals(date("13.04.2022"), addBusinessDays(date("12.04.2022"), 1, holidays));
        assertEquals(date("14.04.2022"), addBusinessDays(date("13.04.2022"), 1, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("14.04.2022"), 1, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("15.04.2022"), 1, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("16.04.2022"), 1, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("17.04.2022"), 1, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("18.04.2022"), 1, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("19.04.2022"), 1, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("20.04.2022"), 1, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("21.04.2022"), 1, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("22.04.2022"), 1, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("23.04.2022"), 1, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("24.04.2022"), 1, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("25.04.2022"), 1, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("26.04.2022"), 1, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("27.04.2022"), 1, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("28.04.2022"), 1, holidays));
        assertEquals(date("02.05.2022"), addBusinessDays(date("29.04.2022"), 1, holidays));
        assertEquals(date("03.05.2022"), addBusinessDays(date("30.04.2022"), 1, holidays));
        assertEquals(date("03.05.2022"), addBusinessDays(date("01.05.2022"), 1, holidays));
        assertEquals(date("03.05.2022"), addBusinessDays(date("02.05.2022"), 1, holidays));
        assertEquals(date("04.05.2022"), addBusinessDays(date("03.05.2022"), 1, holidays));
    }

    @Test
    public void testAddTwoBusinessDaysUsingHolidays() {
        // Add 2 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("13.04.2022"), addBusinessDays(date("11.04.2022"), 2, holidays));
        assertEquals(date("14.04.2022"), addBusinessDays(date("12.04.2022"), 2, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("13.04.2022"), 2, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("14.04.2022"), 2, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("15.04.2022"), 2, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("16.04.2022"), 2, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("17.04.2022"), 2, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("18.04.2022"), 2, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("19.04.2022"), 2, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("20.04.2022"), 2, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("21.04.2022"), 2, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("22.04.2022"), 2, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("23.04.2022"), 2, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("24.04.2022"), 2, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("25.04.2022"), 2, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("26.04.2022"), 2, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("27.04.2022"), 2, holidays));
        assertEquals(date("02.05.2022"), addBusinessDays(date("28.04.2022"), 2, holidays));
        assertEquals(date("03.05.2022"), addBusinessDays(date("29.04.2022"), 2, holidays));
        assertEquals(date("04.05.2022"), addBusinessDays(date("30.04.2022"), 2, holidays));
        assertEquals(date("04.05.2022"), addBusinessDays(date("01.05.2022"), 2, holidays));
        assertEquals(date("04.05.2022"), addBusinessDays(date("02.05.2022"), 2, holidays));
        assertEquals(date("05.05.2022"), addBusinessDays(date("03.05.2022"), 2, holidays));
    }

    @Test
    public void testAddThreeBusinessDaysUsingHolidays() {
        // Add 3 business days with holidays on
        // 15.04.2022 (friday)
        // 17.04.2022 (sunday)
        // 18.04.2022 (monday)
        // 25.04.2022 (monday)
        // 01.05.2022 (sunday)
        // 26.05.2022 (thursday)
        assertEquals(date("14.04.2022"), addBusinessDays(date("11.04.2022"), 3, holidays));
        assertEquals(date("19.04.2022"), addBusinessDays(date("12.04.2022"), 3, holidays));
        assertEquals(date("20.04.2022"), addBusinessDays(date("13.04.2022"), 3, holidays));
        assertEquals(date("21.04.2022"), addBusinessDays(date("14.04.2022"), 3, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("15.04.2022"), 3, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("16.04.2022"), 3, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("17.04.2022"), 3, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("18.04.2022"), 3, holidays));
        assertEquals(date("22.04.2022"), addBusinessDays(date("19.04.2022"), 3, holidays));
        assertEquals(date("26.04.2022"), addBusinessDays(date("20.04.2022"), 3, holidays));
        assertEquals(date("27.04.2022"), addBusinessDays(date("21.04.2022"), 3, holidays));
        assertEquals(date("28.04.2022"), addBusinessDays(date("22.04.2022"), 3, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("23.04.2022"), 3, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("24.04.2022"), 3, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("25.04.2022"), 3, holidays));
        assertEquals(date("29.04.2022"), addBusinessDays(date("26.04.2022"), 3, holidays));
        assertEquals(date("02.05.2022"), addBusinessDays(date("27.04.2022"), 3, holidays));
        assertEquals(date("03.05.2022"), addBusinessDays(date("28.04.2022"), 3, holidays));
        assertEquals(date("04.05.2022"), addBusinessDays(date("29.04.2022"), 3, holidays));
        assertEquals(date("05.05.2022"), addBusinessDays(date("30.04.2022"), 3, holidays));
        assertEquals(date("05.05.2022"), addBusinessDays(date("01.05.2022"), 3, holidays));
        assertEquals(date("05.05.2022"), addBusinessDays(date("02.05.2022"), 3, holidays));
        assertEquals(date("06.05.2022"), addBusinessDays(date("03.05.2022"), 3, holidays));
    }

    @Test
    public void testAddALotOfBusinessDays() {
        var from = date("11.04.2022");
        assertEquals(date("11.04.2023"), addBusinessDays(from, 257, holidays));
        assertEquals(date("08.09.2023"), addBusinessDays(from, 365, holidays));
    }

    //    @Disabled
    @Test
    public void testAddALotALotALotOfBusinessDays() {
        assertEquals(date("01.02.2022").plusYears(3_833_070), addBusinessDays(date("11.04.2022"), 1_000_000_000, emptySet()));
    }

    //    @Disabled
    @Test
    public void testAddALotALotALotOfBusinessDaysWithALotOfHolidays() {
        var holidays = IntStream.range(0, 10_000)
                .parallel()
                .mapToObj(yearsToAdd ->
                        List.of(
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
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertEquals(date("09.07.2022").plusYears(383_553), addBusinessDays(date("11.04.2022"), 100_000_000, new HashSet<>(holidays)));
    }

    private static LocalDate date(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
