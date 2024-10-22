package CarmineGargiulo.FS0624_Unit5_Week1_Day2;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities.*;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.OrderState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.TableState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private Menu menu;
    @Autowired
    private List<Table> tableList;
    @Autowired
    private Scanner scanner;
    @Autowired
    private int copertoPrice;
    @Override
    public void run(String... args) throws Exception {
        menu.stampaMenu();
        while (true){
            List<MenuProduct> menuList = new ArrayList<>(menu.getProductList());
            System.out.println("Welcome how many people u are ?");
            int number = verifyInput();
            List<Table> availableTables = tableList.stream().filter(table -> table.getTableState().equals(TableState.FREE) && table.getMaxCapacity() > number).toList();
            if(availableTables.isEmpty()) {
                System.out.println("Sorry no tables available at the moment");
                break;
            } else {
                System.out.println("Please choose on table");
                availableTables.forEach(table -> System.out.println("Table number " + table.getTableNr()));
                int tablenr;
                while (true){
                    tablenr = verifyInput();
                    if(tablenr <= 0 || tablenr > availableTables.size()) System.out.println("Wrong input");
                    else break;
                }
                Table table = tableList.get(tablenr - 1);
                List<MenuProduct> productsList = new ArrayList<>();
                while (true){
                    System.out.println("Which pizza would you like to order");
                    List<MenuProduct> pizzaList =menuList.stream().filter(menuProduct -> menuProduct instanceof Pizza).toList();
                    pizzaList.forEach(System.out::println);
                    int pizzanr;
                    while (true){
                        pizzanr = verifyInput();
                        if(pizzanr <= 0 || pizzanr > pizzaList.size()) System.out.println("Wrong input");
                        else break;
                    }
                    Pizza pizza = (Pizza) pizzaList.get(pizzanr - 1);
                    while (true) {
                        System.out.println("Would you like to put extra toppings on it ?");
                        int scelta;
                        while (true){
                            scelta = verifyInput();
                            if(scelta <= 0 || scelta > 2) System.out.println("Wrong input");
                            else break;
                        }
                        if(scelta == 1){
                            System.out.println("Choose a topping");
                            List<MenuProduct> toppingList =menuList.stream().filter(menuProduct -> menuProduct instanceof Topping).toList();
                            toppingList.forEach(System.out::println);
                            int toppingNr;
                            while (true){
                                toppingNr = verifyInput();
                                if(toppingNr <= 0 || toppingNr > toppingList.size()) System.out.println("Wrong input");
                                else break;
                            }
                            pizza.addTopping((Topping) toppingList.get(toppingNr - 1));
                            productsList.add(pizza);
                            System.out.println("Would you like to put another topping? ");
                            int scelta2;
                            while (true){
                                scelta2 = verifyInput();
                                if(scelta2 <= 0 || scelta2 > 2) System.out.println("Wrong input");
                                else break;
                            }
                            if(scelta2 == 2) break;
                        } else {
                            productsList.add(pizza);
                            break;
                        }
                    }
                    System.out.println("Would you like another pizza?");
                    int scelta2;
                    while (true){
                        scelta2 = verifyInput();
                        if(scelta2 <= 0 || scelta2 > 2) System.out.println("Wrong input");
                        else break;
                    }
                    if(scelta2 == 2) break;
                }
                while (true) {
                    System.out.println("Which drink you would like to take");
                    List<MenuProduct> drinkList =menuList.stream().filter(menuProduct -> menuProduct instanceof Drink).toList();
                    drinkList.forEach(System.out::println);
                    int drinknr;
                    while (true){
                        drinknr = verifyInput();
                        if(drinknr <= 0 || drinknr > drinkList.size()) System.out.println("Wrong input");
                        else break;
                    }
                    Drink drink = (Drink) drinkList.get(drinknr - 1);
                    productsList.add(drink);
                    System.out.println("Would you like another drink? ");
                    int scelta;
                    while (true){
                        scelta = verifyInput();
                        if(scelta <= 0 || scelta > 2) System.out.println("Wrong input");
                        else break;
                    }
                    if (scelta == 2) break;
                }
                Order order = new Order(table, productsList, number, copertoPrice);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Order ready!");
                order.setOrderState(OrderState.READY);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                order.setOrderState(OrderState.SERVED);
                System.out.println("Bon apeti");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Your order: ");
                System.out.println(order);
                System.out.println("Do you wish to do it again?");
                int scelta;
                while (true){
                    scelta = verifyInput();
                    if(scelta <= 0 || scelta > 2) System.out.println("Wrong input");
                    else break;
                }
                if (scelta == 2) break;
            }
        }
    }

    private int verifyInput(){
        int number;
        while(true){
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e){
                System.out.println("Insert a number");
            }
        }
        return number;
    }
}
