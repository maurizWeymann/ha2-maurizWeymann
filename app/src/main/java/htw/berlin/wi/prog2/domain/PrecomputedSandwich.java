package htw.berlin.wi.prog2.domain;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.List;

public class PrecomputedSandwich implements Sandwich{

    private double preis;
    private int kalorien;
    private List<String> zutatenNamen;

    public PrecomputedSandwich(double preis, int kalorien, List<String> zutatenNamen) {
        this.preis = preis;
        this.kalorien = kalorien;
        this.zutatenNamen = zutatenNamen;
    }

    @Override
    public double calculatePrice() {return preis; }

    @Override
    public int calculateCalories() { return kalorien; }

    @Override
    public List<String> getIngredientNames() { return zutatenNamen; }
}
