package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class MenuProduct {
    protected String name;
    protected double price;
    protected int calories;

    public MenuProduct(double price, int calories){
        this.price = price;
        this.calories = calories;
    }


}
