package View;
import Controllers.InitMode.ParallelsModeController;
import Controllers.InitMode.secuencialModeController;
import Controllers.Timers.CatchTimer;
import com.github.kwhat.jnativehook.NativeHookException;
import repository.KeycodesRepository;
import repository.btnRepository;

import java.awt.*;
import java.util.Scanner;

import static Controllers.viewController.*;
import static java.lang.Thread.sleep;
import static repository.btnRepository.showList;

public class view {

    public static void editKey(){
        System.out.println("0: leave 1:Autoconfiguration  Enter key name from the list: to edit");
        showList();
        String keyId = sc.next();

        if(btnRepository.keyNameExists(keyId)){
            patchKey(btnRepository.getKeyIndexByName(keyId));
        }
        else if(!btnRepository.keyNameExists(keyId)){
            putKey(keyId);
        }
    }

    public static void AutoConfiguration(){
        CatchTimer timer = new CatchTimer();
        KeycodesRepository.initList();
        timer.start();
        while(timer.isAlive()){
            if(!timer.isFinishedFlag()){
                timer.interrupt();
            }
        }
    }

    public static void secuencialMode(int milliseconds) throws NativeHookException, InterruptedException, AWTException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initializing secuencial mode");
        secuencialModeController.init(milliseconds);


    }

    public static void parallelismMode(int milliseconds) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initializing parallelism mode");
        ParallelsModeController.init(milliseconds);
    }

}
