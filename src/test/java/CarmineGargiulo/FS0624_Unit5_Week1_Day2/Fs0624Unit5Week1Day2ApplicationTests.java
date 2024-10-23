package CarmineGargiulo.FS0624_Unit5_Week1_Day2;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities.Menu;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities.Order;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities.Table;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.enums.TableState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day2.exceptions.OccupiedOrUnmatchableTableException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
	void copertoUguale2(){
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

}
