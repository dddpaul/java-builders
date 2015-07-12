import immutables.NutritionFacts;
import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalInt;

import static org.hamcrest.core.Is.is;

public class BuildersTest extends Assert {

    @Test
    public void testTelescopicConstructor() throws Exception {
        a_telescopic_constructor.NutritionFacts cocaCola = new a_telescopic_constructor.NutritionFacts(240, 8, 100, 0, 35, 27);
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        a_telescopic_constructor.NutritionFacts someFood = new a_telescopic_constructor.NutritionFacts(100, 200);
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));
    }

    @Test
    public void testJavaBeans() throws Exception {
        b_javabeans.NutritionFacts cocaCola = new b_javabeans.NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        b_javabeans.NutritionFacts someFood = new b_javabeans.NutritionFacts();
        someFood.setServingSize(100);
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getServings(), is(-1));
    }

    @Test
    public void testBuilder() throws Exception {
        c_builder.NutritionFacts cocaCola = new c_builder.NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        c_builder.NutritionFacts someFood = new c_builder.NutritionFacts.Builder(100, 200).build();
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));
    }

    @Test
    public void testElegantBuilder() throws Exception {
        d_elegant_builder.NutritionFacts cocaCola = d_elegant_builder.NutritionFacts.builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        d_elegant_builder.NutritionFacts someFood = d_elegant_builder.NutritionFacts.builder(100, 200).build();
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));

        // Side effect - builder methods change existing instance, so don't reuse the same builder
        d_elegant_builder.NutritionFacts.Builder builder = d_elegant_builder.NutritionFacts.builder(100, 200);
        someFood = builder.build();
        assertThat(someFood.getCalories(), is(0));
        builder.calories(300);
        assertThat(someFood.getCalories(), is(300));
    }

    @Test
    public void testIdeaInnerBuilder() throws Exception {
        e_idea_innerbuilder.NutritionFacts cocaCola = e_idea_innerbuilder.NutritionFacts.newBuilder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));

        e_idea_innerbuilder.NutritionFacts someFood = e_idea_innerbuilder.NutritionFacts.newBuilder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(someFood.getServingSize(), is(100));
        assertThat(someFood.getCalories(), is(0));
    }

    @Test
    public void testAutoValue() throws Exception {
        f_auto_value.NutritionFacts cocaCola = f_auto_value.NutritionFacts.builder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.servingSize(), is(240));
        assertThat(cocaCola.carbohydrate(), is(27));
        assertThat(cocaCola.toString(), is("NutritionFacts{servingSize=240, servings=8, calories=100, fat=0, sodium=35, carbohydrate=27}"));

        f_auto_value.NutritionFacts someFood = f_auto_value.NutritionFacts.builder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(someFood.servingSize(), is(100));
        assertThat(someFood.calories(), is(0));

        f_auto_value.NutritionFacts moreFood = f_auto_value.NutritionFacts.builder()
                .servingSize(100)
                .servings(200)
                .build();
        assertThat(moreFood, is(someFood)); // overridden equals() makes his job
    }

    @Test
    public void testLombok() throws Exception {
        g_lombok.NutritionFacts cocaCola = g_lombok.NutritionFacts.builder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.servingSize, is(240));
        assertThat(cocaCola.carbohydrate, is(27));
     }

    @Test
    public void testPojoBuilder() throws Exception {
        h_pojo_builder.NutritionFacts cocaCola = new h_pojo_builder.NutritionFactsBuilder()
                .withServingSize(240)
                .withServings(8)
                .withCalories(100)
                .withSodium(35)
                .withCarbohydrate(27)
                .build();
        assertThat(cocaCola.getServingSize(), is(240));
        assertThat(cocaCola.getCarbohydrate(), is(27));
    }

    @Test
    public void testImmutables() throws Exception {
        NutritionFacts cocaCola = immutables.ImmutableNutritionFacts.builder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertThat(cocaCola.servingSize(), is(240));
        assertThat(cocaCola.carbohydrate(), is(OptionalInt.of(27)));
        assertThat(cocaCola.toString(), is("NutritionFacts{servingSize=240, servings=8, calories=OptionalInt[100], fat=OptionalInt.empty, sodium=OptionalInt[35], carbohydrate=OptionalInt[27]}"));

        NutritionFacts someFood = immutables.ImmutableNutritionFacts.builder()
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
