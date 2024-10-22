package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.OrderState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    @Setter(AccessLevel.NONE)
    private int orderId;
    @Setter(AccessLevel.NONE)
    private Table table;
    @Setter(AccessLevel.NONE)
    private List<MenuProduct> orderList;
    private OrderState orderState = OrderState.ONGOING;
    @Setter(AccessLevel.NONE)
    private LocalTime orderTime = LocalTime.now();
    private int coverChargeNr;
    private double totAmount;
    private static int count = 1;

    public Order(Table table, List<MenuProduct> orderList, int coverChargeNr, @Value("${menu.coperto}") int coperto){
        this.table = table;
        this.orderList = new ArrayList<>(orderList);
        this.coverChargeNr = coverChargeNr;
        this.totAmount = orderList.stream().mapToDouble(MenuProduct::getPrice).sum() + (coverChargeNr * coperto);
        this.orderId = count;
        count++;
    }

    public void addElementsToOrder(List<MenuProduct> productsToAdd){
        this.orderList.addAll(productsToAdd);
        setTotAmount(totAmount + productsToAdd.stream().mapToDouble(MenuProduct::getPrice).sum());
    }
}
