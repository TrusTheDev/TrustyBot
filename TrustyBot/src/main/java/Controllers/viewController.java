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
        System.out.println("Creating new btn with name: " + keyId);
        key.setName(keyId);
        key.setPressTime(Integer.parseInt(question("Enter time pressing, default: " + key.getPressTime() + ", (" + key.getPressTime()/1000 )));
        key.setKeycode(Integer.parseInt(question("Enter keycode")));
        key.setDelay(Integer.parseInt(question("Enter delay time")));
        btnRepository.saveKey(key);
        System.out.println("Key: " + btnRepository.getKey(0).getName() + " created successfully");
    }
    
    public static void patchKey(int index){
        String option = "";
        KeyBtn keySave = new KeyBtn(1, 1,1,"");
        while(true){
            option = question("0: Leave 1: Save changes 2: Change key name 3: change pressed time 4: change keycode, 5: change delay time");

            switch (option){
                case "0":
                    return;
                case "1":
                    btnRepository.updateKey(index, keySave);
                    break;
                case "2":
                    System.out.println("Enter key name");
                    keySave.setName(sc.next());
                    break;
                case "3":
                    System.out.println("Enter key pressed time");
                    keySave.setPressTime(sc.nextInt());
                    break;
                case "4":
                    System.out.println("Enter keycode");
                    keySave.setKeycode(sc.nextInt());
                    break;
                case "5":
                    System.out.println("Enter delay");
                    keySave.setDelay(sc.nextInt());
            }
        }
    }
}
