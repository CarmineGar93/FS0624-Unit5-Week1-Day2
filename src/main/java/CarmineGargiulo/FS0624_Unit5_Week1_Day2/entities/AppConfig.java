package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public Topping getTomato(){
        Topping topping = new Topping(0.5, 30);
        topping.setName("Tomato");
        return topping;
    }

    @Bean
    public Topping getCheese(){
        Topping topping = new Topping(0.5, 80);
        topping.setName("Cheese");
        return topping;
    }

    @Bean
    public Topping getSausage(){
        Topping topping = new Topping(1, 100);
        topping.setName("Sausage");
        return topping;
    }

    @Bean
    public Topping getMushrooms(){
        Topping topping = new Topping(1, 40);
        topping.setName("Mushrooms");
        return topping;
    }

    @Bean
    public Topping getSalame(){
        Topping topping = new Topping(0.5, 70);
        topping.setName("Spicy salame");
        return topping;
    }

    @Bean
    public Topping getMelanzane(){
        Topping topping = new Topping(0.5, 20);
        topping.setName("Eggplant");
        return topping;
    }

    @Bean
    public List<Topping> getToppingBase(){
        List<Topping> base = new ArrayList<>();
        base.add(getCheese());
        base.add(getTomato());
        return base;
    }

    @Bean
    @Scope("prototype")
    public Pizza getPizzaMargherita(){
        Pizza pizza = new Pizza(4.99, 1000, getToppingBase());
        pizza.setName("Pizza Margherita");
        return pizza;
    }

    @Bean
    public Pizza getPizzaSalsicciaFunghi(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getMushrooms());
        pizza.addTopping(getSausage());
        pizza.setName("Pizza sausage and mushrooms");
        return pizza;
    }

    @Bean
    public Pizza getPizzaDiavola(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getSalame());
        pizza.setName("Pizza diavola");
        return pizza;
    }

    @Bean
    public Pizza getPizzaMelanzaneSalsiccia(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getMelanzane());
        pizza.addTopping(getSausage());
        pizza.setName("Pizza sausage and eggplant");
        return pizza;
    }

    @Bean
    public Drink getCocaCola(){
        Drink drink = new Drink(2, 150, 0.5);
        drink.setName("Coca cola");
        return drink;
    }

    @Bean
    public Drink getWater(){
        Drink drink = new Drink(1, 0, 1);
        drink.setName("Water");
        return drink;
    }

    @Bean
    public Drink getFanta(){
        Drink drink = new Drink(1.5, 120, 0.33);
        drink.setName("Fanta");
        return drink;
    }

    @Bean
    public Drink getBeer(){
        Drink drink = new Drink(3, 250, 0.66);
        drink.setName("Beer");
        return drink;
    }

    @Bean(name = "menu")
    public Menu getMenu(List<MenuProduct> menuProductList){
        Menu menu = new Menu(menuProductList);
        return menu;
    }
}
