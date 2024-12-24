package Controllers;

import Models.KeyBtn;
import repository.btnRepository;

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

    public boolean putkey(){
        KeyBtn key = new KeyBtn(1000, 0, 5000, "default");
        System.out.println("Ingresar identificador de la tecla:");
        key.setName(sc.next());
        System.out.println("Ingresar tiempo de presionado en milisegundos, default: " + key.getPressTime() + ", (" + key.getPressTime()/1000 );
        key.setPressTime(sc.nextInt());
        System.out.println("Ingresar keycode de la tecla que desea presionar");
        key.setKeycode(sc.nextInt());
        System.out.println("Ingresar tiempo de delay, default = 5000");
        key.setDelay(sc.nextInt());
        return btnRepository.saveKey(key);
    }

    public void patchKey(){
        System.out.println("Que boton quieres configurar?");
        for(int i=1; i<btnRepository.keyListSize(); i++){
            System.out.println( i + ": " + btnRepository.getKey(i).getName());
        }
        KeyBtn key = btnRepository.getKey(sc.nextInt());

        System.out.println("1: Para cambiar el nombre de la tecla 2: Para tiempo de presionado 3: Para la keycode, 4: para el tiempo de delay");
        switch (sc.nextInt()){
            case 1:
                System.out.println("Introduce nombre de la tecla");
                key.setName(sc.nextLine());
                break;
            case 2:
                System.out.println("Introduce tiempo de presionado");
                key.setPressTime(sc.nextInt());
                break;
            case 3:
                System.out.println("Introduce keycode");
                key.setKeycode(sc.nextInt());
                break;
            case 4:
                System.out.println("Introduce delay");
                key.setDelay(sc.nextInt());
        }
    }


}
