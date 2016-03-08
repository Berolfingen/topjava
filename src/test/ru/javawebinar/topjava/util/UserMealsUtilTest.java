package ru.javawebinar.topjava.util;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserMealsUtilTest {
    private List<UserMeal> mealList;

    @Before
    public void initialize() {
        mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
    }

    @Test
    public void testGetFilteredMealsWithExceeded() {
        List<UserMealWithExceed> actual = UserMealsUtil.getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        List<UserMealWithExceed> expected = Arrays.asList(new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500, false),
                new UserMealWithExceed(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000, true));

        assertEquals(actual, expected);
    }

    @Test
    public void testEmptyList() {
        List<UserMealWithExceed> actual = UserMealsUtil.getFilteredMealsWithExceeded(mealList, LocalTime.of(1, 0), LocalTime.of(2, 0), 2000);
        assertEquals(actual, Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorretTimePeriod() {
        List<UserMealWithExceed> actual = UserMealsUtil.getFilteredMealsWithExceeded(mealList, LocalTime.of(15, 0), LocalTime.of(2, 0), 2000);
    }
}