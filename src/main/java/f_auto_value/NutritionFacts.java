package f_auto_value;

import com.google.auto.value.AutoValue;

/**
 * Google <a href="https://github.com/google/auto/tree/master/value">AutoValue</a>
 * <p>
 * Pros:
 * <ul>
 * <li>no boilerplate at all;
 * <li>automatic equals(), hasCode() and toString() methods generation.
 * </ul>
 *
 * <p>
 * Cons:
 * <ul>
 * <li>it's a code generation nevertheless, so it requires something like "mvn compile" before using
 * <li>c_builder support is experimental (you must use latest version from GitHub).
 * </ul>
 */
@AutoValue
public abstract class NutritionFacts {

    public static Builder builder() {
        return new AutoValue_NutritionFacts.Builder()
                .calories(0)
                .fat(0)
                .sodium(0)
                .carbohydrate(0);
    }

    // Mandatory
    public abstract int servingSize();
    public abstract int servings();

    // Optional, default values specified in c_builder
    public abstract int calories();
    public abstract int fat();
    public abstract int sodium();
    public abstract int carbohydrate();

    @AutoValue.Builder
    public interface Builder {
        Builder servingSize(int val);
        Builder servings(int val);
        Builder calories(int val);
        Builder fat(int val);
        Builder sodium(int val);
        Builder carbohydrate(int val);
        NutritionFacts build();
    }
}
