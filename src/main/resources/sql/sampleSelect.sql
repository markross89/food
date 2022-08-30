-- SQL pobierający szczegóły posiłków w określonym planie
SELECT day_name.name as day_name, meal_name, recipe.name as recipe_name, recipe.description as recipe_description
FROM `recipe_plan`
JOIN day_name on day_name.id=day_name_id
JOIN recipe on recipe.id=recipe_id WHERE plan_id = 6 -- zamiast 6 należy wstawić id planu do pobrania --
ORDER by day_name.display_order, recipe_plan.display_order;


-- SQL - pobiera najnowszy plan dla zadanego użytkownika (tabela admins)
SELECT day_name.name as day_name, meal_name,  recipe.name as recipe_name, recipe.description as recipe_description
FROM `recipe_plan`
JOIN day_name on day_name.id=day_name_id
JOIN recipe on recipe.id=recipe_id WHERE
recipe_plan.plan_id =  (SELECT MAX(id) from plan WHERE admin_id = 1) -- zamiast 1 należy wstawić id użytkownika (tabela admins) --
ORDER by day_name.display_order, recipe_plan.display_order;