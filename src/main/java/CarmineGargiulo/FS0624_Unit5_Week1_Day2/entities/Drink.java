package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;


import lombok.Getter;
import lombok.ToString;

@Getter
public class Drink extends MenuProduct{
    private double qty;
    public Drink(double price, int calories, double qty) {
        super(price, calories);
        this.qty = qty;
    }

    @Override
    public String toString() {
        return name +
                " (" + qty +
                "l), price: " + price;
    }
}
