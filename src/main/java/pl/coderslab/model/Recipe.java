package pl.coderslab.model;


import java.sql.Date;
import java.util.Objects;

public class Recipe {
    int id;
    String name;
    String ingredients;
    String description;
    Date created;
    Date updated;

    public Recipe() {
    }

    int preparationTime;
    String preparation;
    int adminId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getId() == recipe.getId() && getPreparationTime() == recipe.getPreparationTime() && getAdminId() == recipe.getAdminId() && Objects.equals(getName(), recipe.getName()) && Objects.equals(getIngredients(), recipe.getIngredients()) && Objects.equals(getDescription(), recipe.getDescription()) && Objects.equals(getCreated(), recipe.getCreated()) && Objects.equals(getUpdated(), recipe.getUpdated()) && Objects.equals(getPreparation(), recipe.getPreparation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIngredients(), getDescription(), getCreated(), getUpdated(), getPreparationTime(), getPreparation(), getAdminId());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparationTime=" + preparationTime +
                ", preparation='" + preparation + '\'' +
                ", adminId=" + adminId +
                '}';
    }

    public Recipe(String name, String ingredients, String description, Date created, Date updated, int preparationTime, String preparation, int adminId) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.preparationTime = preparationTime;
        this.preparation = preparation;
        this.adminId = adminId;
    }

    public Recipe(int id, String name, String ingredients, String description, Date created, Date updated, int preparationTime, String preparation, int adminId) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.preparationTime = preparationTime;
        this.preparation = preparation;
        this.adminId = adminId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
