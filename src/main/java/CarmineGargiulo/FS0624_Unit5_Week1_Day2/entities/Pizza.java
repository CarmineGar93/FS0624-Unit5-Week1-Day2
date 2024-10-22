package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Pizza extends MenuProduct{
    private List<Topping> toppingList;
    public Pizza(double price, int calories, List<Topping> toppingList) {
        super(price, calories);
        this.toppingList = new ArrayList<>(toppingList);
    }

    public void addTopping(Topping topping){
        this.toppingList.add(topping);
        this.price += topping.price;
        this.calories += topping.calories;
    }

    @Override
    public String toString() {
        return  name + toppingList +
                ", price: " + price;
    }
}
