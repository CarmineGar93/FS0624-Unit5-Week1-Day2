package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean
    public Topping getTomato(){
        Topping topping = new Topping(0.5, 30);
        topping.setName("Tomato");
        return topping;
    }

    @Bean
    public int getCopertoFee(@Value("${menu.coperto}") int coperto){
        return coperto;
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

    @Bean(name = "Pizza Margherita")
    @Scope("prototype")
    public Pizza getPizzaMargherita(){
        Pizza pizza = new Pizza(4.99, 1000, getToppingBase());
        pizza.setName("Pizza Margherita");
        return pizza;
    }

    @Bean(name = "Pizza sausage and mushrooms")
    @Scope("prototype")
    public Pizza getPizzaSalsicciaFunghi(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getMushrooms());
        pizza.addTopping(getSausage());
        pizza.setName("Pizza sausage and mushrooms");
        return pizza;
    }

    @Bean(name = "Pizza diavola")
    @Scope("prototype")
    public Pizza getPizzaDiavola(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getSalame());
        pizza.setName("Pizza diavola");
        return pizza;
    }

    @Bean(name = "Pizza sausage and eggplant")
    @Scope("prototype")
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

   @Bean
    public Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
   }

   @Bean(name = "table1")
    public Table getTable1(){
        Table table = new Table(8);
        return table;
   }

    @Bean(name = "table2")
    public Table getTable2(){
        Table table = new Table(8);
        return table;
    }

    @Bean(name = "table3")
    public Table getTable3(){
        Table table = new Table(4);
        return table;
    }

    @Bean(name = "table4")
    public Table getTable4(){
        Table table = new Table(4);
        return table;
    }

    @Bean(name = "table5")
    public Table getTable5(){
        Table table = new Table(2);
        return table;
    }

    @Bean(name = "table6")
    public Table getTable6(){
        Table table = new Table(2);
        return table;
    }

}
