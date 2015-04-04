import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BuildersTest extends Assert {

    @Test
    public void testTelescopicConstructor() throws Exception {
        telescopic_constructor.NutritionFacts cocaCola = new telescopic_constructor.NutritionFacts(240, 8, 100, 0, 35, 27);
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        telescopic_constructor.NutritionFacts someFood = new telescopic_constructor.NutritionFacts(100, 200);
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));
    }

    @Test
    public void testJavaBeans() throws Exception {
        javabeans.NutritionFacts cocaCola = new javabeans.NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        javabeans.NutritionFacts someFood = new javabeans.NutritionFacts();
        someFood.setServingSize(100);
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getServings(), is(-1));
    }

    @Test
    public void testBuilder() throws Exception {
        builder.NutritionFacts cocaCola = new builder.NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        builder.NutritionFacts someFood = new builder.NutritionFacts.Builder(100, 200).build();
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));
    }
}
