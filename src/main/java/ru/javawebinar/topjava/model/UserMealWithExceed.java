package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

public class UserMealWithExceed {
    protected final LocalDateTime dateTime;

    protected final String description;

    protected final int calories;

    protected final boolean exceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMealWithExceed that = (UserMealWithExceed) o;

        if (calories != that.calories) return false;
        if (exceed != that.exceed) return false;
        if (!dateTime.equals(that.dateTime)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = dateTime.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + calories;
        result = 31 * result + (exceed ? 1 : 0);
        return result;
    }
}
