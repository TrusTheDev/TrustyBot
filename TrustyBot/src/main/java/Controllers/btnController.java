package Controllers;

import Models.KeyBtn;
import repository.keycodeRepository;

import java.awt.*;
import java.util.Scanner;

public class btnController {
    Scanner sc = new Scanner(System.in);
    public void initProgram() throws AWTException, InterruptedException {}

    public void addKey(){
        System.out.println("1: Ingresar teclas 2: editar teclas");
        String option = sc.nextLine();
        if(option == "1"){
            ();
        }
    }

    public KeyBtn putkey(){
        KeyBtn key = new KeyBtn(1000, 0, 5000);
        System.out.println("Ingresar tiempo de presionado en milisegundos, default: " + key.getPressTime() + ", (" + key.getPressTime()/1000 );
        key.setPressTime(sc.nextInt());
        System.out.println("Ingresar tecla que desea presionar");
        
    }


}
