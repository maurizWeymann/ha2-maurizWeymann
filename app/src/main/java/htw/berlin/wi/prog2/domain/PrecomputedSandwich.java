package htw.berlin.wi.prog2.domain;

import java.util.List;

public  class PrecomputedSandwich implements Sandwich{

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public int calculateCalories() {
        return 0;
    }

    @Override
    public List<String> getIngredientNames() {
        return null;
    }
}
