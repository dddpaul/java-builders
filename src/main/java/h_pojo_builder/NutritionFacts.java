package h_pojo_builder;

import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * <a href="https://github.com/mkarneim/pojobuilder">POJO Builder</a>
 * <p/>
 * Pros:
 * <ul>
 * <li>can be used in conjunction with AutoValue or Lombok
 * <li>is recommended by <a href="http://www.umputun.com/">Umputun</a> :)
 * </ul>
 * Cons:
 * <ul>
 * <li>can't generate getters and setters
 * <li>it's a code generation nevertheless, so it requires something like "mvn compile" before using
 * </ul>
 */
@GeneratePojoBuilder
public class NutritionFacts {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
