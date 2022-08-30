package pl.coderslab.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {
    // ZAPYTANIA SQL
    private static final String CREATE_RECIPE_QUERY = "INSERT INTO recipe(name, ingredients, description, created, updated, preparation_time, preparation, admin_id) VALUES (?,?,?,?,?,?,?,?);";
    private static final String DELETE_RECIPE_QUERY = "DELETE FROM recipe where id = ?;";
    private static final String FIND_ALL_RECIPES_QUERY = "SELECT * FROM recipe order by created desc ;";
    private static final String FIND_ALL_USER_RECIPES_QUERY = "SELECT * FROM recipe WHERE admin_id = ?";
    private static final String FIND_AMOUNT_OF_USER_RECIPES_QUERY = "SELECT COUNT(*) as count FROM recipe WHERE admin_id = ?";
    private static final String READ_RECIPE_QUERY = "SELECT * from recipe where id = ?;";
    private static final String READ_RECIPE_BY_NAME_QUERY = "SELECT * from recipe where name = ?;";
    private static final String UPDATE_RECIPE_QUERY = "UPDATE recipe SET" +
            " name = ?," +
            " ingredients = ?," +
            " description = ?," +
            " created = ?," +
            " updated = ?," +
            " preparation_time = ?," +
            " preparation = ?," +
            " admin_id = ?"+
            " WHERE	id = ?;";

    /**
     * Get book by id
     *
     * @param recipeId
     * @return
     */
    public Recipe read(Integer recipeId) {
        Recipe recipe = new Recipe();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_QUERY)
        ) {
            statement.setInt(1, recipeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    recipe.setId(resultSet.getInt("id"));
                    recipe.setName(resultSet.getString("name"));
                    recipe.setIngredients(resultSet.getString("ingredients"));
                    recipe.setDescription(resultSet.getString("description"));
                    recipe.setCreated(resultSet.getDate("created"));
                    recipe.setUpdated(resultSet.getDate("updated"));
                    recipe.setPreparationTime(resultSet.getInt("preparation_time"));
                    recipe.setPreparation(resultSet.getString("preparation"));
                    recipe.setAdminId(resultSet.getInt("admin_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipe;
    }
    public Recipe readByName(String name) {
        Recipe recipe = new Recipe();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_BY_NAME_QUERY)
        ) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    recipe.setId(resultSet.getInt("id"));
                    recipe.setName(resultSet.getString("name"));
                    recipe.setIngredients(resultSet.getString("ingredients"));
                    recipe.setDescription(resultSet.getString("description"));
                    recipe.setCreated(resultSet.getDate("created"));
                    recipe.setUpdated(resultSet.getDate("updated"));
                    recipe.setPreparationTime(resultSet.getInt("preparation_time"));
                    recipe.setPreparation(resultSet.getString("preparation"));
                    recipe.setAdminId(resultSet.getInt("admin_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipe;
    }

    /**
     * Return all books
     *
     * @return
     */
    public List<Recipe> findAll() {
        List<Recipe> recipeList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_RECIPES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Recipe recipeToAdd = new Recipe();
                recipeToAdd.setId(resultSet.getInt("id"));
                recipeToAdd.setName(resultSet.getString("name"));
                recipeToAdd.setIngredients(resultSet.getString("ingredients"));
                recipeToAdd.setDescription(resultSet.getString("description"));
                recipeToAdd.setCreated(resultSet.getDate("created"));
                recipeToAdd.setUpdated(resultSet.getDate("updated"));
                recipeToAdd.setPreparationTime(resultSet.getInt("preparation_time"));
                recipeToAdd.setPreparation(resultSet.getString("preparation"));
                recipeToAdd.setAdminId(resultSet.getInt("admin_id"));
                recipeList.add(recipeToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    /**
     * Create book
     *
     * @param recipe
     * @return
     */
    public Recipe create(Recipe recipe) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_RECIPE_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, recipe.getName());
            insertStm.setString(2, recipe.getIngredients());
            insertStm.setString(3, recipe.getDescription());
            insertStm.setDate(4, recipe.getCreated());
            insertStm.setDate(5, recipe.getUpdated());
            insertStm.setInt(6, recipe.getPreparationTime());
            insertStm.setString(7, recipe.getPreparation());
            insertStm.setInt(8, recipe.getAdminId());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    recipe.setId(generatedKeys.getInt(1));
                    return recipe;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Remove book by id
     *
     * @param recipeId
     */
    public void delete(Integer recipeId) throws NotAvailableException {
        try (Connection connection = DbUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_RECIPE_QUERY)) {
            statement.setInt(1, recipeId);
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


    /**
     * Update book
     *
     * @param recipe
     */
    public void update(Recipe recipe) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RECIPE_QUERY)) {

            statement.setInt(9, recipe.getId());
            statement.setString(1, recipe.getName());
            statement.setString(2, recipe.getIngredients());
            statement.setString(3, recipe.getDescription());
            statement.setDate(4, recipe.getCreated());
            statement.setDate(5, recipe.getUpdated());
            statement.setInt(6, recipe.getPreparationTime());
            statement.setString(7, recipe.getPreparation());
            statement.setInt(8, recipe.getAdminId());
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int amountOfRecipesOfUser(int adminId) {
       try (Connection connection = DbUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_AMOUNT_OF_USER_RECIPES_QUERY)) {

           statement.setInt(1, adminId);
           ResultSet rs = statement.executeQuery();
           if (rs.next()) {
                return rs.getInt("count");
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
       return 0;
    }
    public List<Recipe> findAllByUser(int adminId) {
        List<Recipe> recipeList = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_USER_RECIPES_QUERY)) {
            statement.setInt(1, adminId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Recipe recipeToAdd = new Recipe();
                recipeToAdd.setId(rs.getInt("id"));
                recipeToAdd.setName(rs.getString("name"));
                recipeToAdd.setIngredients(rs.getString("ingredients"));
                recipeToAdd.setDescription(rs.getString("description"));
                recipeToAdd.setCreated(rs.getDate("created"));
                recipeToAdd.setUpdated(rs.getDate("updated"));
                recipeToAdd.setPreparationTime(rs.getInt("preparation_time"));
                recipeToAdd.setPreparation(rs.getString("preparation"));
                recipeToAdd.setAdminId(rs.getInt("admin_id"));
                recipeList.add(recipeToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;

    }

}