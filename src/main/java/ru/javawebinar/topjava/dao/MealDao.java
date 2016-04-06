package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;

public interface MealDao {

    public void addMeal(UserMeal userMeal);

    public void deleteMeal(int id);

    public void updateMeal(UserMeal userMeal);

    public UserMeal getMeal(int id);

    public Collection<UserMeal> getMeals();
}
