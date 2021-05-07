package htw.berlin.wi.prog2.domain;

import java.util.ArrayList;
import java.util.List;

public class DynamicallyComputedSandwich implements Sandwich {

    private List<Ingredient> neueZutaten;

    public DynamicallyComputedSandwich(List<Ingredient> neueZutaten) {

        this.neueZutaten = new ArrayList<>(neueZutaten);
    }

    @Override
    public double calculatePrice() {
        double preis = 0;

        for (Ingredient ingredient : neueZutaten) {
            preis += ingredient.getPrice();
        }
        return preis;
    }

    @Override
    public int calculateCalories() {
        int kalorien = 0;

        for (Ingredient ingredient : neueZutaten) {
            kalorien += ingredient.getCalories();
        }
        return kalorien;
    }

    @Override
    public List<String> getIngredientNames() {

        List<String> zutatenNamen = new ArrayList<>();

        for (Ingredient ingredient : neueZutaten) {
            zutatenNamen.add(ingredient.getName());
        }
        return zutatenNamen;
    }
}
