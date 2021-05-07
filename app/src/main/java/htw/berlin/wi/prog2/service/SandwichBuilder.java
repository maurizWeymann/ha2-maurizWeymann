package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;

import java.util.ArrayList;
import java.util.List;


public class SandwichBuilder {

    private List <Ingredient> neueZutaten = new ArrayList<>();

    public SandwichBuilder add(Ingredient ingredient) {
        // TODO hier die Annahme von Zutaten implementieren
        neueZutaten.add(ingredient);
        return this;
        // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im SandwichBuilderTest)
        // this ist das aktuelle Objekt, in diesem Fall das Objekt Sandwich Builder
    }

    public Sandwich buildPrecomputed() {
        stelleSicherMinZweiIngredients();

        double preis = 0;
        int kalorien = 0;
        List<String> zutatenNamen = new ArrayList<>();

        for (Ingredient ingredient : neueZutaten) {
            preis += ingredient.getPrice();
            kalorien += ingredient.getCalories();
            zutatenNamen.add(ingredient.getName());
        }
        neueZutaten.clear();

        return new PrecomputedSandwich(preis, kalorien, zutatenNamen);
    }

    public Sandwich buildDynamicallyComputed() {
        stelleSicherMinZweiIngredients();

        DynamicallyComputedSandwich sandwich = new DynamicallyComputedSandwich(neueZutaten);
        neueZutaten.clear();

        return sandwich;
    }

    private void stelleSicherMinZweiIngredients() {
        if(neueZutaten.size() < 2){
            throw new IllegalSandwichException("Needs more than one ingredient!");}
    }

}
