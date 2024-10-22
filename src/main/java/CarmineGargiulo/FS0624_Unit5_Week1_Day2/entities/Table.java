package CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.TableState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {
    @Setter(AccessLevel.NONE)
    private int tableNr;
    private int maxCapacity;
    private TableState tableState = TableState.FREE;
    private static int count = 1;

    public Table(int nrCopertiMax){
        this.tableNr = count;
        count++;
        this.maxCapacity = nrCopertiMax;
    }
}
