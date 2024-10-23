package CarmineGargiulo.FS0624_Unit5_Week1_Day2;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities.*;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.TableState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.exceptions.OccupiedOrUnmatchableTableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Fs0624Unit5Week1Day2ApplicationTests {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Fs0624Unit5Week1Day2Application.class);
	@Test
	void contextLoads() {
	}


	@Test
	void tableNotNull(){
		Table table = (Table) ctx.getBean("table1");
		assertNotNull(table);
	}

	@Test
	void listMenuNotNull(){
		Menu menu = ctx.getBean(Menu.class);
		assertNotNull(menu.getProductList());
	}

	@Test
	void copertoEquals2(){
		int coperto = ctx.getBean(Integer.class);
		assertEquals(2, coperto);
	}

	@Test
	void OccupiedTableException(){
		Table table = (Table) ctx.getBean("table6");
		int coperto = ctx.getBean(Integer.class);
		table.setTableState(TableState.OCCUPIED);
		assertThrows(OccupiedOrUnmatchableTableException.class, () -> new Order(table, 1, coperto));
	}

	@Test
	void NotEnoughTableSeatsException(){
		Table table = (Table) ctx.getBean("table6");
		int coperto = ctx.getBean(Integer.class);
		assertThrows(OccupiedOrUnmatchableTableException.class, () -> new Order(table, 3, coperto));
	}

	@ParameterizedTest
	@CsvSource({"1, 5.49","2, 5.99","3, 6.49","4, 4.99"})
	void addingToppingPizzaPriceChanges(int choice, double price){
		Pizza pizzaMargherita = (Pizza) ctx.getBean("Pizza Margherita");
		Topping topping = (Topping) ctx.getBean("getCheese");
		Topping topping2 = (Topping) ctx.getBean("getSausage");
		if(choice == 1) {
			pizzaMargherita.addTopping(topping);
		} else if (choice == 2) {
			pizzaMargherita.addTopping(topping2);
		} else if (choice == 3) {
			pizzaMargherita.addTopping(topping);
			pizzaMargherita.addTopping(topping2);
		}
		assertEquals(price, pizzaMargherita.getPrice());
	}

}
