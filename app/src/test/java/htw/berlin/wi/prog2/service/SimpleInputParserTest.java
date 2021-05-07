package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInputParserTest {

    @Test
    @DisplayName("can detect ingredients in text input")
    void ingredientsFromInput() {
        // System under test (SUT)
        InputParser parser = new SimpleInputParser();

        // Test-Daten
        String input = "Ich hätte gerne ein Sandwich mit Ciabatta-Brot, Salami, Eisbergsalat und Mayo.";
        Ingredient ciabatta = Menu.buns.get(2);
        Ingredient salami = Menu.meat.get(3);
        Ingredient eisbergsalat = Menu.salads.get(5);
        Ingredient mayo = Menu.sauces.get(9);

        List<Ingredient> expected = List.of(ciabatta, salami, eisbergsalat, mayo);
        List<Ingredient> actual = parser.ingredientsFromInput(input);

        assertEquals(expected, actual);
    }
}