package idea_innerbuilder;

/**
 * IntelliJ IDEA <a href="https://github.com/analytically/innerbuilder">InnerBuilder</a> plugin
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        private Builder() {
        }

        public Builder servingSize(final int servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public Builder servings(final int servings) {
            this.servings = servings;
            return this;
        }

        public Builder calories(final int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(final int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(final int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(final int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
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
