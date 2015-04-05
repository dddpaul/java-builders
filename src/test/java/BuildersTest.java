import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalInt;

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

    @Test
    public void testElegantBuilder() throws Exception {
        elegant_builder.NutritionFacts cocaCola = elegant_builder.NutritionFacts.builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        elegant_builder.NutritionFacts someFood = elegant_builder.NutritionFacts.builder(100, 200).build();
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));

        // Side effect - builder methods change existing instance, so don't reuse the same builder
        elegant_builder.NutritionFacts.Builder builder = elegant_builder.NutritionFacts.builder(100, 200);
        someFood = builder.build();
        assertThat(someFood.getCalories(), is(0));
        builder.calories(300);
        assertThat(someFood.getCalories(), is(300));
    }

    @Test
    public void testIdeaInnerBuilder() throws Exception {
        idea_innerbuilder.NutritionFacts cocaCola = idea_innerbuilder.NutritionFacts.newBuilder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        idea_innerbuilder.NutritionFacts someFood = idea_innerbuilder.NutritionFacts.newBuilder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));
    }

    @Test
    public void testAutoValue() throws Exception {
        auto_value.NutritionFacts cocaCola = auto_value.NutritionFacts.builder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.servingSize(), is(240));
        assertThat(cocaCola.carbohydrate(), is(27));
        assertThat(cocaCola.toString(), is("NutritionFacts{servingSize=240, servings=8, calories=100, fat=0, sodium=35, carbohydrate=27}"));

        auto_value.NutritionFacts someFood = auto_value.NutritionFacts.builder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(someFood.servingSize(), is(100));
        assertThat(someFood.calories(), is(0));

        auto_value.NutritionFacts moreFood = auto_value.NutritionFacts.builder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(moreFood, is(someFood)); // overridden equals() makes his job
    }

    @Test
    public void testImmutables() throws Exception {
        immutables.NutritionFacts cocaCola = immutables.ImmutableNutritionFacts.builder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.servingSize(), is(240));
        assertThat(cocaCola.carbohydrate(), is(OptionalInt.of(27)));
        assertThat(cocaCola.toString(), is("NutritionFacts{servingSize=240, servings=8, calories=OptionalInt[100], fat=OptionalInt.empty, sodium=OptionalInt[35], carbohydrate=OptionalInt[27]}"));

        immutables.NutritionFacts someFood = immutables.ImmutableNutritionFacts.builder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(someFood.servingSize(), is(100));
        assertThat(someFood.calories(), is(OptionalInt.empty()));

        immutables.ImmutableNutritionFacts moreFood = immutables.ImmutableNutritionFacts.builder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(moreFood, is(someFood)); // overridden equals() makes his job

        immutables.ImmutableNutritionFacts muchMoreFood = moreFood.withServingSize(300);
        assertThat(muchMoreFood.servingSize(), is(300));
        assertThat(muchMoreFood.servings(), is(200));
    }
}
