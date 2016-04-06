package ru.javawebinar.topjava.dao.impl;

import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.model.InMemoryUserMeal;
import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;
import java.util.Map;

public class UserMealDaoImpl implements MealDao {

    private Map<Integer, UserMeal> db = InMemoryUserMeal.getDb();

    @Override
    public void addMeal(UserMeal userMeal) {
        db.put(userMeal.getId(), userMeal);
    }

    @Override
    public void deleteMeal(int id) {
        db.remove(id);
    }

    @Override
    public void updateMeal(UserMeal userMeal) {
        db.put(userMeal.getId(), userMeal);
    }

    @Override
    public UserMeal getMeal(int id) {
        return db.get(id);
    }

    @Override
    public Collection<UserMeal> getMeals() {
        return db.values();
    }
}
