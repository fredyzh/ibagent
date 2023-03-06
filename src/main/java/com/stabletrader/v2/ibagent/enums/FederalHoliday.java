package com.stabletrader.v2.ibagent.enums;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.util.Objects.requireNonNull;

/**
 * Represents the public holidays as declared in Federal law (5 U.S.C. 6103). All dates listed in section (a) are
 * enumerated. Inauguration day, which is described in section (c) is not enumerated, but is accounted for in the
 * static {@link #observancesForYear} and {@link #isObserved(LocalDate)} methods.
 * <p>
 * Fixed holidays that fall on specific days each year (e.g. Christmas) are observed on the nearest work day. If the
 * actual holiday is on a Saturday, the observance occurs on the Friday before; if the holiday is on a Sunday, the
 * observance occurs on the Monday after. The dates used for such fixed holidays will be the observed dates and not
 * the actual ones.
 * <p>
 * This method does not account for historical changes in Federal law regarding Holidays and should not be used to
 * determine holidays in the past, such as Martin Luther King Jr.'s birthday for years prior to 1983, when the
 * observance was formally adopted.
 *
 * @see <a href="https://www.opm.gov/policy-data-oversight/snow-dismissal-procedures/federal-holidays/#url=Overview">
 *     Federal Holidays - OPM Web site</a>
 * @see <a href="https://www.law.cornell.edu/uscode/text/5/6103">5 U.S. Code Â§ 6103 - Holidays</a>
 */
public enum FederalHoliday {

    NEW_YEARS("New Year's Day", year -> LocalDate.of(year, JANUARY, 1)),

    MLK_JR_BIRTHDAY("Birthday of Martin Luther King, Jr.", year -> nthDayOfWeek(3, MONDAY, JANUARY, year)),

    WASHINGTON_BIRTHDAY("Washington's Birthday", year -> nthDayOfWeek(3, MONDAY, FEBRUARY, year)),

    MEMORIAL_DAY("Memorial Day", year -> nthDayOfWeek(-1, MONDAY, MAY, year)),

    INDEPENDENCE_DAY("Independence Day", year -> LocalDate.of(year, JULY, 4)),

    LABOR_DAY("Labor Day", year -> nthDayOfWeek(1, MONDAY, SEPTEMBER, year)),

    COLUMBUS_DAY("Columbus Day", year -> nthDayOfWeek(2, MONDAY, OCTOBER, year)),

    VETERANS_DAY("Veterans Day", year -> LocalDate.of(year, NOVEMBER, 11)),

    THANKSGIVING("Thanksgiving Day", year -> nthDayOfWeek(4, THURSDAY, NOVEMBER, year)),

    CHRISTMAS("Christmas Day", year -> LocalDate.of(year, DECEMBER, 25));

    private static final MonthDay INAUGURATION_DATE = MonthDay.of(JANUARY, 20);

    private final String legalName;
    private final Function<Integer, LocalDate> onDate;

    FederalHoliday(String legalName, Function<Integer, LocalDate> onDate) {
        this.legalName = legalName;
        this.onDate = onDate;
    }

    /**
     * Returns the official, legal name of the Holiday as designated by the Federal government.
     *
     * @return the Holiday's legal name
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * Returns the observed date of this Holiday for the given year. Fixed date holidays are adjusted so that they fall
     * on a working date. If the fixed date falls on Saturday, it is moved to the preceding Friday; if Sunday, it is
     * moved to the following Monday.
     * <p>
     * Note: if New Year's Day falls on a Saturday on the year provided, the year of returned date will be December 31st
     * of the previous year. This most recently happened in 2011.
     *
     * @param year the calendar year
     * @return the date of this holiday observance for that year
     */
    public LocalDate forYear(int year) {
        return adjustForWeekends(onDate.apply(year));
    }

    /**
     * Returns the date that falls on the nth day of the week for the given year. For example, the fourth Friday
     * in the month of October, 2018 is October 26th, 2018.
     */
    private static LocalDate nthDayOfWeek(int n, DayOfWeek dayOfWeek, Month month, int year) {
        return LocalDate.of(year, month, 1).with(TemporalAdjusters.dayOfWeekInMonth(n, dayOfWeek));
    }

    /**
     * Adjusts the date, if necessary, so that it does not fall on a weekend. If the date is on a Saturday, returns
     * the previous Friday; if it's on a Sunday, returns the following Monday.
     */
    private static LocalDate adjustForWeekends(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case SATURDAY:
                return date.minusDays(1);
            case SUNDAY:
                return date.plusDays(1);
            default:
                return date;
        }
    }

    /**
     * For the purposes of this class it is assumed 1965 itself is an inauguration year.
     */
    private static boolean isInaugurationYear(int year) {
        return (year - 1965) % 4 == 0;
    }

    /**
     * According to Federal law (5 U.S.C. 6103):
     * <p>
     * "January 20 of each fourth year after 1965, Inauguration Day, is a legal public holiday for the purpose of
     * statutes relating to pay and leave of employees...employed by the government of the District of Columbia employed
     * in the District of Columbia, Montgomery and Prince Georges Counties in Maryland, Arlington and Fairfax Counties
     * in Virginia, and the cities of Alexandria and Falls Church in Virginia. When January 20 of any fourth year after
     * 1965 falls on Sunday, the next succeeding day selected for the public observance of the inauguration of the
     * President is a legal public holiday for the purpose of this subsection."
     * <p>
     * If the given year is an inauguration year, January 20th of that year (adjusted for weekends) will be returned.
     * Otherwise, the returned optional will be empty
     *
     * @param year some calendar year, e.g. 2018
     * @return an empty optional if the given year did not have an inauguration day
     */
    public static Optional<LocalDate> inaugurationDay(int year) {
        return Optional.ofNullable(
                isInaugurationYear(year) ? adjustForWeekends(INAUGURATION_DATE.atYear(year)) : null
        );
    }

    /**
     * Returns all Federal Holidays for the given calendar year. For years like 2011, where New Years Day was observed
     * on December 31st, 2010, the returned list will include that 2010 date.
     * <p>
     * If the year happens to be the year of an inauguration, then the list will also include the date of the
     * inauguration, provided the observed inauguration date that year does not coincide with Martin Luther King Jr.'s
     * Birthday, as it did in 2013.
     *
     * @param year some calendar year, e.g. 2018
     * @return a chronologically ordered set of the observed Federal Holidays that fall within that year.
     */
    public static SortedSet<LocalDate> observancesForYear(int year) {
        // supplies a TreeSet for collecting our holiday dates
        Supplier<SortedSet<LocalDate>> setSupplier = () -> new TreeSet<>(inaugurationDay(year)
                .map(Arrays::asList) // seed the TreeSet with a single-element collection containing inauguration day
                .orElseGet(ArrayList::new)); // or seed the TreeSet with an empty list when there's no inauguration day
        return Stream.of(values())
                .map(holiday -> holiday.forYear(year))
                .collect(Collectors.toCollection(setSupplier));
    }

    /**
     * Indicates if the given date is an observed Federal holiday, including inauguration days.
     *
     * @param date cannot be null
     * @return true only when the provided date is the observance of a Federal holiday, including inauguration days
     */
    public static boolean isObserved(LocalDate date) {
        requireNonNull(date);
        return IntStream.of(0, 1) // sometimes a date is a holiday in the subsequent year
                .map(i -> date.getYear() + i) // so look at holidays within both the current and subsequent year
                .mapToObj(FederalHoliday::observancesForYear)
                .flatMap(SortedSet::stream)
                .anyMatch(date::equals);
    }

    /**
     * Indicates if the given date falls on the weekend (i.e. is a Saturday or Sunday).
     *
     * @param date cannot be null
     * @return true if the given date is a Saturday or Sunday
     */
    public static boolean isWeekend(LocalDate date) {
        requireNonNull(date);
        return date.getDayOfWeek() == SUNDAY || date.getDayOfWeek() == SATURDAY;
    }

    /**
     * Indicates if the given date is a Saturday, Sunday, or an observed Federal holiday (inauguration days included).
     * <p>
     * Generally, this method should not be used for determining historic non-workdays. The rules currently implemented
     * within this class have not always been in effect (e.g. Columbus Day was not a holiday until 1968). Furthermore,
     * this method does not take into account days where Federal offices closed due to weather or shutdown reasons.
     * <p>
     * Caution should also be used when using this method for dates in the far future as laws or circumstances may
     * change between now and that date, causing the rules currently implemented to be inapplicable at that time.
     *
     * @param date cannot be null
     * @return true when the date is a weekend or observed Federal holiday, inauguration days included
     */
    public static boolean isNonWorkday(LocalDate date) {
        requireNonNull(date);
        return isWeekend(date) || isObserved(date);
    }
}
