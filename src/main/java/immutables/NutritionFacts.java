package immutables;

import org.immutables.value.Value;

import java.util.OptionalInt;

/**
 * <a href="http://immutables.org">Immutables</a>
 * <p>
 * Pros:
 * <ul>
 * <li>boilerplate is gone completely;
 * <li>automatic equals(), hasCode() and toString() methods generation;
 * <li>automatic withXXX() methods generation;
 * <li>uses Java 8 features (Optional etc.)
 * </ul>
 *
 * <p>
 * Cons:
 * <ul>
 * <li>it's a code generation nevertheless.
 * </ul>
 */
@Value.Immutable
public interface NutritionFacts {
    // mandatory
    int servingSize();
    int servings();

    // optional
    OptionalInt calories();
    OptionalInt fat();
    OptionalInt sodium();
    OptionalInt carbohydrate();
}
