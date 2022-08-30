package pl.coderslab.model;

public class RecipePlanDetails {
    private int    recipePlanId;
    private String mealName;
    private String dayName;
    private String ingredients;
    private int    recipeId;
    private String recipeName;
    private String recipeDescription;
    private String planName;
    private String planDescription;
    private int    planId;

    @Override
    public String toString() {
        return "RecipePlanDetails{" +
                "mealName='" + mealName + '\'' +
                ", dayName='" + dayName + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                ", planName='" + planName + '\'' +
                ", planDescription='" + planDescription + '\'' +
                '}';
    }


    public RecipePlanDetails() {
    }

    public RecipePlanDetails(String mealName, String dayName, String recipeName, String ingredients, String recipeDescription, String planName, String planDescription) {
        this.mealName = mealName;
        this.dayName = dayName;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.recipeDescription = recipeDescription;
        this.planName = planName;
        this.planDescription = planDescription;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getRecipePlanId() {
        return recipePlanId;
    }

    public void setRecipePlanId(int recipePlanId) {
        this.recipePlanId = recipePlanId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }
}
