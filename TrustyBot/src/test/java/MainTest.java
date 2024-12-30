import Models.KeyBtn;
import org.w3c.dom.ls.LSOutput;
import repository.btnRepository;
import repository.keycodeRepository;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainTest {
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        KeyBtn key1 = new KeyBtn(1000, 2, 1000, "Apretar1");
        KeyBtn key2 = new KeyBtn(100, 45, 234, "Press2");
        KeyBtn key3 = new KeyBtn(100, 423, 2354, "Press3");

       long startime = System.currentTimeMillis();
       long tiempoTranscurrido = 0;
        //Hace un procedo en un determinado tiempo
//       while (tiempoTranscurrido <= 15500){
//           listener list = new listener();
//           list.keyPressed();
//           Thread.sleep(10);
//           tiempoTranscurrido = System.currentTimeMillis() - startime;
//       }
//
//        System.out.println(tiempoTranscurrido);


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (line.equalsIgnoreCase("quit") == false) {
            line = in.readLine();
            System.out.println(line);
            //do something
        }

        in.close();


//        for(int i=1; i<=Double.POSITIVE_INFINITY; i++){
//            System.out.println(i);
//        }








    }




}
