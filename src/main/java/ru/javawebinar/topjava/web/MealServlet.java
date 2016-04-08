package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.impl.UserMealDaoImpl;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private MealDao mealDao = new UserMealDaoImpl();

    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("forward to mealList");
        List<UserMealWithExceed> meals = UserMealsUtil.getAll(mealDao.getMeals());
        request.setAttribute("meals", meals);
        request.getRequestDispatcher("/mealList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("in dopost");

        if (req.getParameter("delete") != null) {
            LOG.debug("in delete");
            int id = Integer.parseInt(req.getParameter("delete"));
            mealDao.deleteMeal(id);
        } else if (req.getParameter("update") != null) {
            LOG.debug("in update");
            UserMeal userMeal = mealDao.getMeal(Integer.parseInt(req.getParameter("update")));
            req.setAttribute("meal",userMeal);
        }

        resp.sendRedirect("meals");
    }
}
