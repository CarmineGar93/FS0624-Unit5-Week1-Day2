package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;


import lombok.Getter;

@Getter
public class Drink extends MenuProduct{
    private double qty;
    public Drink(double price, int calories, double qty) {
        super(price, calories);
        this.qty = qty;
    }
}