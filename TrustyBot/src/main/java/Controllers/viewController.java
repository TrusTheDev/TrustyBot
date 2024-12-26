package Controllers;
import Models.KeyBtn;
import repository.btnRepository;
import java.util.Scanner;
import static repository.btnRepository.showList;

public class viewController {
    static public Scanner sc = new Scanner(System.in);

    public static String question(String question){
        System.out.println(question);
        return sc.next();
    }

    public static void putKey(String keyId){
        KeyBtn key = new KeyBtn(1000, 0, 5000, "default");
        System.out.println("Creando nuevo btn con identificador: " + keyId);
        key.setName(keyId);
        key.setPressTime(Integer.parseInt(question("Ingresar tiempo de presionado en milisegundos, default: " + key.getPressTime() + ", (" + key.getPressTime()/1000 )));
        key.setKeycode(Integer.parseInt(question("Ingresar keycode de la tecla que desea presionar")));
        key.setDelay(Integer.parseInt(question("Ingresar tiempo de delay, default = 5000")));
        btnRepository.saveKey(key);
        System.out.println("Tecla: " + btnRepository.getKey(0).getName() + " creada con exito");
    }
    
    public static void patchKey(int index){
        String option = "";
        KeyBtn keySave = new KeyBtn(1, 1,1,"");
        while(true){
            option = question("0: Para salir 1:Para guardar cambios 2: Para cambiar el nombre de la tecla 3: Para tiempo de presionado 4: Para la keycode, 5: para el tiempo de delay");

            switch (option){
                case "0":
                    return;
                case "1":
                    btnRepository.updateKey(index, keySave);
                    break;
                case "2":
                    System.out.println("Introduce nombre de la tecla");
                    keySave.setName(sc.next());
                    break;
                case "3":
                    System.out.println("Introduce tiempo de presionado");
                    keySave.setPressTime(sc.nextInt());
                    break;
                case "4":
                    System.out.println("Introduce keycode");
                    keySave.setKeycode(sc.nextInt());
                    break;
                case "5":
                    System.out.println("Introduce delay");
                    keySave.setDelay(sc.nextInt());
            }
        }
    }




}
