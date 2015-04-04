package elegant_builder;

/**
 * Elegant builder pattern, see <a href="http://habrahabr.ru/post/244521/">Java elegant builder</a>
 * <p>
 * Pros:
 * <ul>
 * <li>less boilerplate.
 * </ul>
 *
 * <p>
 * Cons:
 * <ul>
 * <li>builder methods change existing instance, so don't reuse the same builder
 * <li>properties are non-final, so object is mutable, see <a href="http://stackoverflow.com/a/10301179/981083">Is this a safe publication of object?</a>
 * </ul>
 *
 * If you mark the field as <b>final</b> then the constructor is guaranteed to finish initialization
 * as part of the constructor. Otherwise you will have to synchronize on a lock before using it.
 */
public class NutritionFacts {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public static Builder builder(int servingSize, int servings) {
        return new NutritionFacts().new Builder(servingSize, servings);
    }

    public class Builder {

        private Builder(int servingSize, int servings) {
            NutritionFacts.this.servingSize = servingSize;
            NutritionFacts.this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return NutritionFacts.this;
        }
    }

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
}
