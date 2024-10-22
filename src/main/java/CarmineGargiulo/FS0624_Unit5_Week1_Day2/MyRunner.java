package CarmineGargiulo.FS0624_Unit5_Week1_Day2;

import CarmineGargiulo.FS0624_Unit5_Week1_Day2.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private Menu menu;
    @Override
    public void run(String... args) throws Exception {
        menu.stampaMenu();
    }
}
