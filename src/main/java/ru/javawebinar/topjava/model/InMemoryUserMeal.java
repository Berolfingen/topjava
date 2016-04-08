package ru.javawebinar.topjava.model;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserMeal {

    private static final Logger LOG = getLogger(InMemoryUserMeal.class);

    public static final List<UserMeal> initialData = Arrays.asList(
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
    );

    public static Map<Integer, UserMeal> db = new HashMap<>();


    public static Map<Integer, UserMeal> getDb() {
        return db;
    }

    public static void fillingDb() {
        for (UserMeal userMeal : initialData) {
            db.put(userMeal.getId(), userMeal);
        }
    }

    static {
        fillingDb();
    }

}
