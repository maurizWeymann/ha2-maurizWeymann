package htw.berlin.wi.prog2.domain;

import java.util.List;

public interface Sandwich {
    double calculatePrice();
    int calculateCalories();
    List<String> getIngredientNames();
}
