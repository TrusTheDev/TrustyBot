package View;
import repository.btnRepository;
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

    public static void secuencialMode(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Modo secuencial: \n 1: Iniciar programa \n 2: Agregar tecla/editar tecla" );
    }

}
