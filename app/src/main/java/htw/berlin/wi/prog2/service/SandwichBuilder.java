package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;

import htw.berlin.wi.prog2.service.SimpleInputParser;


import java.util.ArrayList;
import java.util.List;


public class SandwichBuilder {

    List <Ingredient> neueZutaten = new ArrayList<>();

    public SandwichBuilder add(Ingredient ingredient) {
        // TODO hier die Annahme von Zutaten implementieren
        neueZutaten.add(ingredient);
        return this;
        // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im SandwichBuilderTest)
        // this ist das aktuelle Objekt, in diesem Fall das Objekt Sandwich Builder
    }

    public Sandwich buildPrecomputed() {
        // TODO hier stattdessen die neue Klasse PrecomputedSandwich verwenden
        return new PrecomputedSandwich(0.03, 3000, List.of("Brot", "Käse"));
    }

    public Sandwich buildDynamicallyComputed() {
        // TODO hier stattdessen die neue Klasse DynamicallyComputedSandwich verwenden
        return new DynamicallyComputedSandwich();
    }
}
