package pl.coderslab.dao;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import pl.coderslab.exception.NotFoundException;

import pl.coderslab.model.Plan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PlanDao {
	
	private static final String READ_PLAN_QUERY = "SELECT * from plan where id = ?;";
	private static final String FIND_ALL_PLAN_QUERY = "SELECT * FROM plan;";
	private static final String FIND_ALL_PLAN_USER_QUERY = "SELECT * FROM plan WHERE admin_id = ?;";
	private static final String CREATE_PLAN_QUERY = "INSERT INTO plan (name, description, created, admin_id) VALUES (?,?,?,?);";
	private static final String DELETE_PLAN_QUERY = "DELETE FROM plan where id = ?;";
	private static final String UPDATE_PLAN_QUERY = "UPDATE	plan SET name = ?, description = ?, created = ?, admin_id= ? WHERE id = ?";
	private static final String READ_PLAN_SUM = "SELECT count(admin_id) AS plan_no FROM plan WHERE admin_id = ?;";
	private static final String LAST_ADDED_PLAN_QUERY = "SELECT * FROM plan WHERE admin_id = ? ORDER BY created DESC LIMIT 1;";

	public Plan read(Integer planId) {
		Plan plan = new Plan();
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(READ_PLAN_QUERY)
		) {
			statement.setInt(1, planId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					plan.setId(resultSet.getInt("id"));
					plan.setName(resultSet.getString("name"));
					plan.setCreated(resultSet.getDate("created"));
					plan.setDescription(resultSet.getString("description"));
					plan.setAdminId(resultSet.getInt("admin_id"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}
	
	public List<Plan> findAll() {
		List<Plan> planList = new ArrayList<>();
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(FIND_ALL_PLAN_QUERY);
			 ResultSet resultSet = statement.executeQuery()) {
			
			while (resultSet.next()) {
				Plan planToAdd = new Plan();
				planToAdd.setId(resultSet.getInt("id"));
				planToAdd.setName(resultSet.getString("name"));
				planToAdd.setDescription(resultSet.getString("description"));
				planToAdd.setCreated(resultSet.getDate("created"));
				planToAdd.setAdminId(resultSet.getInt("admin_id"));
				planList.add(planToAdd);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planList;
	}

	public List<Plan> findAllByUser(int adminId) {
		List<Plan> planList = new ArrayList<>();
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(FIND_ALL_PLAN_USER_QUERY)) {
			statement.setInt(1, adminId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Plan planToAdd = new Plan();
				planToAdd.setId(resultSet.getInt("id"));
				planToAdd.setName(resultSet.getString("name"));
				planToAdd.setDescription(resultSet.getString("description"));
				planToAdd.setCreated(resultSet.getDate("created"));
				planToAdd.setAdminId(resultSet.getInt("admin_id"));
				planList.add(planToAdd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planList;
	}

	public Plan create(Plan plan) {
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement insertStm = connection.prepareStatement(CREATE_PLAN_QUERY,
					 PreparedStatement.RETURN_GENERATED_KEYS)) {
			insertStm.setString(1, plan.getName());
			insertStm.setString(2, plan.getDescription());
			insertStm.setDate(3, plan.getCreated());
			insertStm.setInt(4, plan.getAdminId());
			int result = insertStm.executeUpdate();
			
			if (result != 1) {
				throw new RuntimeException("Execute update returned " + result);
			}
			
			try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					plan.setId(generatedKeys.getInt(1));
					return plan;
				} else {
					throw new RuntimeException("Generated key was not found");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(Integer planId) throws NotAvailableException {
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_PLAN_QUERY)) {
			statement.setInt(1, planId);
			statement.executeUpdate();

			boolean deleted = statement.execute();
			if (!deleted) {
				throw new NotFoundException("Recipe not found");
			}
		} catch(MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new NotAvailableException("Recipe is used in other plans");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Plan plan) {
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(UPDATE_PLAN_QUERY)) {
			statement.setInt(5, plan.getId());
			statement.setString(1, plan.getName());
			statement.setString(2, plan.getDescription());
			statement.setDate(3, plan.getCreated());
			statement.setInt(4, plan.getAdminId());
			
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int planCount(Integer adminId) {
		int sum = 0;
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(READ_PLAN_SUM)
		) {
			statement.setInt(1, adminId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					sum = resultSet.getInt("plan_no");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	public Plan lastAddedPlan(int adminId) {
		Plan plan = new Plan();
		try (Connection connection = DbUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(LAST_ADDED_PLAN_QUERY)
		) {
			statement.setInt(1, adminId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				plan.setId(resultSet.getInt("id"));
				plan.setName(resultSet.getString("name"));
				plan.setCreated(resultSet.getDate("created"));
				plan.setDescription(resultSet.getString("description"));
				plan.setAdminId(resultSet.getInt("admin_id"));
				return plan;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plan;
	}

}
