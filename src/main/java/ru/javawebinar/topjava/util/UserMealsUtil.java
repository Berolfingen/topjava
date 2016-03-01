package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserMealsUtil {

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        //todo make in one stream
        Map<LocalDate, Integer> caloriesPerDate = mealList.stream()
                .collect(Collectors.groupingBy(m -> m.getDateTime().toLocalDate(), Collectors.summingInt(m -> m.getCalories())));

        List<UserMealWithExceed> result = mealList.stream().
                filter(m -> (TimeUtil.isBetween(m.getDateTime().toLocalTime(), startTime, endTime)))
                .map(userMeal -> new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(),
                        caloriesPerDate.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay)).
                        collect(Collectors.toList());

        return result;
    }
}
