package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Getter
@Component
public class Menu {
    @Autowired
    private List<MenuProduct> productList;


    private void printSpaces(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
    }

    public void stampaMenu(){
        int distanzaPizzaCalorie = 90;
        int distanzaCaloriePrezzo = 20;
        String pizzas = "Pizzas";
        String calories = "Calories";
        String price = "Price";
        String toppings = "Toppings";
        String drinks = "Drinks";
        System.out.println();
        System.out.print(pizzas);
        printSpaces(distanzaPizzaCalorie - pizzas.length());
        System.out.print(calories);
        printSpaces(distanzaCaloriePrezzo - calories.length());
        System.out.print(price);
        List<MenuProduct> pizzaList = productList.stream().filter(menuProduct -> menuProduct instanceof Pizza).toList();
        pizzaList.forEach(menuProduct -> {
            System.out.println();
            System.out.print(menuProduct.getName() + ((Pizza) menuProduct).getToppingList().toString());
            printSpaces(distanzaPizzaCalorie - menuProduct.getName().length() - ((Pizza) menuProduct).getToppingList().toString().length());
            System.out.print(menuProduct.getCalories());
            printSpaces(distanzaCaloriePrezzo -Integer.toString(menuProduct.getCalories()).length());
            System.out.print(menuProduct.getPrice());
        });
        System.out.println();
        System.out.println();
        System.out.print(toppings);
        printSpaces(distanzaPizzaCalorie - toppings.length());
        System.out.print(calories);
        printSpaces(distanzaCaloriePrezzo - calories.length());
        System.out.print(price);
        List<MenuProduct> toppingList = productList.stream().filter(menuProduct -> menuProduct instanceof Topping).toList();
        toppingList.forEach(menuProduct -> {
            System.out.println();
            System.out.print(menuProduct.getName());
            printSpaces(distanzaPizzaCalorie - menuProduct.getName().length());
            System.out.print(menuProduct.getCalories());
            printSpaces(distanzaCaloriePrezzo -Integer.toString(menuProduct.getCalories()).length());
            System.out.print(menuProduct.getPrice());
        });
        System.out.println();
        System.out.println();
        System.out.print(drinks);
        printSpaces(distanzaPizzaCalorie - drinks.length());
        System.out.print(calories);
        printSpaces(distanzaCaloriePrezzo - calories.length());
        System.out.print(price);
        List<MenuProduct> drinkList = productList.stream().filter(menuProduct -> menuProduct instanceof Drink).toList();
        drinkList.forEach(menuProduct -> {
            System.out.println();
            System.out.print(menuProduct.getName() + " (" + ((Drink) menuProduct).getQty() + " l)");
            printSpaces(distanzaPizzaCalorie - menuProduct.getName().length() - 5 - Double.toString(((Drink) menuProduct).getQty()).length());
            System.out.print(menuProduct.getCalories());
            printSpaces(distanzaCaloriePrezzo -Integer.toString(menuProduct.getCalories()).length());
            System.out.print(menuProduct.getPrice());
        });
        System.out.println();
    }
}
