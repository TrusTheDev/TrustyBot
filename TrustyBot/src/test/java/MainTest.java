import Models.KeyBtn;
import org.w3c.dom.ls.LSOutput;
import repository.btnRepository;
import repository.keycodeRepository;

import java.awt.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainTest {
    public static void main(String[] args) throws AWTException, InterruptedException {
        KeyBtn key1 = new KeyBtn(1000, 2, 1000, "Apretar1");
        KeyBtn key2 = new KeyBtn(100, 45, 234, "Press2");
        KeyBtn key3 = new KeyBtn(100, 423, 2354, "Press3");

       long startime = System.currentTimeMillis();
       long tiempoTranscurrido = 0;

       while (tiempoTranscurrido < 15000){
           System.out.println("Hola mundo");
           Thread.sleep(10);
           tiempoTranscurrido = System.currentTimeMillis() - startime;
       }

        System.out.println(tiempoTranscurrido);

    }
}
