package pl.coderslab.dao;

import pl.coderslab.model.DayName;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DayNameDao {

    private static final String FIND_ALL_QUERY = "SELECT * FROM day_name";
    private static final String FIND_DAYS_BY_RECIPE_PLAN_ID_QUERY = "select recipe_plan.day_name_id, day_name.name ,day_name.display_order from " +
            "recipe_plan join day_name on recipe_plan.day_name_id=day_name.id where plan_id=?  group by day_name_id order by day_name_id ";
          

    public List<DayName> findAll() {
        List<DayName> dayNameList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DayName dayName = new DayName();
                dayName.setId(resultSet.getInt("id"));
                dayName.setName(resultSet.getString("name"));
                dayName.setDisplayOrder(resultSet.getInt("display_order"));

                dayNameList.add(dayName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayNameList;
    }
    public List<DayName> findDaysByPlanId(int planId) {
        List<DayName> dayList = new ArrayList<>();
        
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_DAYS_BY_RECIPE_PLAN_ID_QUERY)) {
            statement.setInt(1, planId);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                DayName dayName = new DayName();
                dayName.setId(rs.getInt("day_name_id"));
                dayName.setName(rs.getString("name"));
              
                dayList.add(dayName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayList;
        
    }
}
