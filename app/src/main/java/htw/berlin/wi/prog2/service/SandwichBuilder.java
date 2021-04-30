package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.DummySandwichImpl;
import htw.berlin.wi.prog2.domain.Sandwich;

public class SandwichBuilder {

    public SandwichBuilder add(Ingredient ingredient) {
        // TODO hier die Annahme von Zutaten implementieren
        return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im SandwichBuilderTest)
    }

    public Sandwich buildPrecomputed() {
        // TODO hier stattdessen die neue Klasse PrecomputedSandwich verwenden
        return new DummySandwichImpl();
    }

    public Sandwich buildDynamicallyComputed() {
        // TODO hier stattdessen die neue Klasse DynamicallyComputedSandwich verwenden
        return new DummySandwichImpl();
    }
}
