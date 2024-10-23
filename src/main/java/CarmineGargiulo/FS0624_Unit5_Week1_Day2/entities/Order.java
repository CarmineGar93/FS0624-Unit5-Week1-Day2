package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.OrderState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.TableState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.exceptions.OccupiedOrUnmatchableTableException;
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

    public Order(Table table, int coverChargeNr, int coperto){
        if(table.getMaxCapacity() < coverChargeNr || table.getTableState().equals(TableState.OCCUPIED)) throw new OccupiedOrUnmatchableTableException();
        this.table = table;
        this.table.setTableState(TableState.OCCUPIED);
        this.orderList = new ArrayList<>();
        this.coverChargeNr = coverChargeNr;
        this.totAmount = coverChargeNr * coperto;
        this.orderId = count;
        count++;
    }

    public void addElementsToOrder(List<MenuProduct> productsToAdd){
        this.orderList.addAll(productsToAdd);
        setTotAmount(totAmount + productsToAdd.stream().mapToDouble(MenuProduct::getPrice).sum());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", table=" + table.getTableNr() +
                ", orderList=" + orderList +
                ", orderState=" + orderState +
                ", orderTime=" + orderTime +
                ", totAmount=" + totAmount +
                '}';
    }
}
