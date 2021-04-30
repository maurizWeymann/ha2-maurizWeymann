package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.Sandwich;
import htw.berlin.wi.prog2.service.SimpleInputParser;
import htw.berlin.wi.prog2.service.SandwichBuilder;

import java.util.*;

public class CommandLineUI {
    private final UserInputWrapper input;
    private final SandwichBuilder builder;
    private final SimpleInputParser parser;

    public CommandLineUI(UserInputWrapper uiw, SandwichBuilder sb, SimpleInputParser ip) {
        input = uiw;
        builder = sb;
        parser = ip;
    }

    public String launch() {
        String inputLine = input.ask("Willkommen beim Sandwichbot! Was möchtest du gerne bestellen?");
        while (!(inputLine.equals("Bestellung abschliessen") || inputLine.equals("Auf Wiedersehen"))) {
            List<Ingredient> ingredients = parser.ingredientsFromInput(inputLine);
            if(ingredients.isEmpty()) {
                inputLine = input.ask("Entschuldigung, ich habe dich nicht verstanden. Wähle aus folgenden Zutaten: "
                        + Menu.getAllArticleNames());
            } else {
                for (Ingredient ing : ingredients) builder.add(ing);
                Sandwich sandwich = builder.buildPrecomputed();
                inputLine = input.ask("In Ordnung. Dein Sandwich mit " + sandwich.getIngredientNames() +
                        " kostet " + sandwich.calculatePrice() + " Euro. Willst du die Bestellung abschliessen?");
            }
        }
        return inputLine;
    }
}
