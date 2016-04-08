package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {

    public static List<UserMealWithExceed> getAll(Collection<UserMeal> mealList) {
        return getFilteredMealsWithExceeded(mealList, LocalTime.MIN, LocalTime.MAX, 2000);
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(Collection<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream().collect(Collectors.groupingBy(um -> um.getDateTime().toLocalDate(),
                Collectors.summingInt(UserMeal::getCalories)));

        return mealList.stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime().toLocalTime(), startTime, endTime))
                .map(um -> new UserMealWithExceed(um.getId(), um.getDateTime(), um.getDescription(), um.getCalories(),
                        caloriesSumByDate.get( um.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceededByCycle(Collection<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesSumPerDate = new HashMap<>();
        for (UserMeal meal : mealList) {
            LocalDate mealDate = meal.getDateTime().toLocalDate();
            caloriesSumPerDate.put(mealDate, caloriesSumPerDate.merge(mealDate, 0, (oldValue, newValue) -> oldValue + newValue));

        }

        System.out.println(caloriesSumPerDate.toString());

        List<UserMealWithExceed> mealExceeded = new ArrayList<>();
        for (UserMeal meal : mealList) {
            LocalDateTime dateTime = meal.getDateTime();
            if (TimeUtil.isBetween(dateTime.toLocalTime(), startTime, endTime)) {
                mealExceeded.add(new UserMealWithExceed(meal.getId(),dateTime, meal.getDescription(), meal.getCalories(),
                        caloriesSumPerDate.get(dateTime.toLocalDate()) > caloriesPerDay));
            }
        }
        return mealExceeded;
    }
}
