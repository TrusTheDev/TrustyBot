package View;
import Controllers.paralelismModeController;
import Controllers.secuencialModeController;
import com.github.kwhat.jnativehook.NativeHookException;
import repository.btnRepository;

import java.awt.*;
import java.util.Scanner;

import static Controllers.viewController.*;
import static repository.btnRepository.showList;

public class view {

    public static void editKey(){
        System.out.println("Ingrese identificador de la tecla");
        showList();
        String keyId = sc.next();
        if(btnRepository.keyNameExists(keyId)){
            patchKey(btnRepository.getKeyIndexByName(keyId));
        }
        else if(!btnRepository.keyNameExists(keyId)){
            putKey(keyId);
        }
    }

    public static void secuencialMode() throws NativeHookException, InterruptedException, AWTException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciando secuencialMode");
        secuencialModeController.init(15000);


    }

    public static void paralelismMode() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciando paralelismMode");
        paralelismModeController.init(15000);
    }

}
