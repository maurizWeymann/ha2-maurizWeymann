package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}

    public static Map<Integer, Ingredient> buns = Map.of(
            1, new Ingredient("Vollkorn", 0.6, 120),
            2, new Ingredient("Ciabatta", 0.7, 100));
    public static Map<Integer, Ingredient> meat = Map.of(
            3, new Ingredient("Salami", 0.9, 90),
            4, new Ingredient("Schinken", 0.9, 80));
    public static Map<Integer, Ingredient> salads = Map.of(
            5, new Ingredient("Eisbergsalat", 0.4, 20),
            6, new Ingredient("Rucolasalat", 0.6, 20));
    public static Map<Integer, Ingredient> veggies = Map.of(
            7, new Ingredient("Tomate", 0.6, 40),
            8, new Ingredient("Gurke", 0.3, 20));
    public static Map<Integer, Ingredient> sauces = Map.of(
            9, new Ingredient("Mayo", 0.3, 20));

    public static Map<Integer, Ingredient> getAllArticles() {
        Map<Integer, Ingredient> articles = new HashMap<>();
        articles.putAll(buns);
        articles.putAll(meat);
        articles.putAll(salads);
        articles.putAll(veggies);
        articles.putAll(sauces);
        return articles;
    }

    public static List<String> getAllArticleNames() {
        Collection<Ingredient> articles = getAllArticles().values();
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles) names.add(art.getName());
        return names;
    }
}
