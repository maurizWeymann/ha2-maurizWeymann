package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.Sandwich;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SandwichBuilderTest {

    private final SandwichBuilder builder  = new SandwichBuilder();

    private final Ingredient kaese = new Ingredient("Käse", 0.01, 2000);
    private final Ingredient brot = new Ingredient("Brot", 0.02, 1000);

    @Test
    @DisplayName("can build a precomputed sandwich with two ingredients")
    void buildASandwich() {
        Sandwich sandwich = builder.add(brot).add(kaese).buildPrecomputed();

        assertEquals(List.of("Brot", "Käse"), sandwich.getIngredientNames());
        assertEquals(0.03, sandwich.calculatePrice());
        assertEquals(3000, sandwich.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed sandwiches after another without mixing things up")
    void buildTwoSandwiches() {
        Sandwich sandwich1 = builder.add(brot).add(kaese).buildPrecomputed();
        Sandwich sandwich2 = builder.add(brot).add(brot).buildPrecomputed();

        assertEquals(List.of("Brot", "Käse"), sandwich1.getIngredientNames());
        assertEquals(List.of("Brot", "Brot"), sandwich2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed sandwich with two ingredients")
    void buildASandwichDynamically() {
        Sandwich sandwich = builder.add(brot).add(kaese).buildDynamicallyComputed();

        assertEquals(List.of("Brot", "Käse"), sandwich.getIngredientNames());
        assertEquals(0.03, sandwich.calculatePrice());
        assertEquals(3000, sandwich.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed sandwiches after another without mixing things up")
    void buildTwoSandwichesDynamically() {
        Sandwich sandwich1 = builder.add(brot).add(kaese).buildDynamicallyComputed();
        Sandwich sandwich2 = builder.add(brot).add(brot).buildDynamicallyComputed();

        assertEquals(List.of("Brot", "Käse"), sandwich1.getIngredientNames());
        assertEquals(List.of("Brot", "Brot"), sandwich2.getIngredientNames());
    }

    // Diese folgenden Tests sind keine typischen Tests, da sie testen, wie Sie etwas im Detail implementiert haben
    @Test
    @DisplayName("a dynamically computed sandwich should have only one field, which is the list of ingredients")
    void buildDynamicallyComputed() {
        Sandwich sandwich = builder.add(brot).add(kaese).buildDynamicallyComputed();

        var clazz = sandwich.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(1, fields.length);
        assertEquals("java.util.List<htw.berlin.wi.prog2.domain.Ingredient>", fields[0].getGenericType().getTypeName());
    }

    @Test
    @DisplayName("a precomputed sandwich should have three field for the precomputed values")
    void buildPrecomputed() {
        Sandwich sandwich = builder.add(brot).add(kaese).buildPrecomputed();

        var clazz = sandwich.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(3, fields.length);
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(int.class));
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(double.class));
    }

    // TODO hier mind. einen Test hinzufügen, der das korrekte Werfen der IllegalSandwichException testet (assertThrows)
}