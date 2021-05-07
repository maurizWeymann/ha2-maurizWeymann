package htw.berlin.wi.prog2.domain;

import java.util.List;

public class DynamicallyComputedSandwich implements Sandwich {

    @Override
    public double calculatePrice() {
        //if contains ingridient by name get price
        getIngredientNames();
        return 0;
    }

    @Override
    public int calculateCalories() {
        //if contains ingridient by name get price
        return 0;
    }

    @Override
    public List<String> getIngredientNames() {
        return null;
    }
}
