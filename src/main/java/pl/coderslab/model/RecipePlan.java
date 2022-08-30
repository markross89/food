package pl.coderslab.model;

import java.util.Objects;

public class RecipePlan {
    private int id;
    private int recipeId;


    private String mealName;
    private int displayOrder;
    private int dayNameId;
    private int planId;

    public RecipePlan() {
    }

    public RecipePlan(int id, int recipeId, String mealName, int displayOrder, int dayNameId, int planId) {
        this.id = id;
        this.recipeId = recipeId;
        this.mealName = mealName;
        this.displayOrder = displayOrder;
        this.dayNameId = dayNameId;
        this.planId = planId;
    }

    public RecipePlan(int recipeId, String mealName, int displayOrder, int dayNameId, int planId) {
        this.recipeId = recipeId;
        this.mealName = mealName;
        this.displayOrder = displayOrder;
        this.dayNameId = dayNameId;
        this.planId = planId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipePlan that = (RecipePlan) o;
        return getId() == that.getId() && getRecipeId() == that.getRecipeId() && getDisplayOrder() == that.getDisplayOrder() && getDayNameId() == that.getDayNameId() && getPlanId() == that.getPlanId() && Objects.equals(getMealName(), that.getMealName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRecipeId(), getMealName(), getDisplayOrder(), getDayNameId(), getPlanId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getDayNameId() {
        return dayNameId;
    }

    public void setDayNameId(int dayNameId) {
        this.dayNameId = dayNameId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }
}
