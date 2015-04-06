package lombok;

/**
 * Project Lombok <a href="http://projectlombok.org/features/Builder.html">Builder</a>
 * <p>
 * Pros:
 * <ul>
 * <li>shortest declaration.
 * </ul>
 *
 * <p>
 * Cons:
 * <ul>
 * <li>it's an <a href="http://notatube.blogspot.ru/2010/11/project-lombok-trick-explained.html">AST manipulation</a> i.e. the real magic :)
 * <li>plugin for IDE is required.
 * </ul>
 */
@Builder
public class NutritionFacts {
    public int servingSize;
    public int servings;
    public int calories;
    public int fat;
    public int sodium;
    public int carbohydrate;
}
