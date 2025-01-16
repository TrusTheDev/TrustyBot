import Models.KeyBtn;
import com.github.kwhat.jnativehook.NativeHookException;
import repository.btnRepository;

import java.awt.*;
import java.util.Scanner;

import static View.view.*;

public class main {
    public static void main(String[] args) throws NativeHookException, InterruptedException, AWTException {
        KeyBtn A = new KeyBtn(1000, 65, 1000, "A");
        KeyBtn B = new KeyBtn(1000, 66, 3000, "B");
        KeyBtn C = new KeyBtn(1000, 67, 1000, "C");
        btnRepository.saveKey(A);
        btnRepository.saveKey(B);
        btnRepository.saveKey(C);
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to TrustyBot! \n 0: close \n 1: initialize \n 2:create/edit keys ");

            switch (sc.nextLine()) {
                case "0":
                    System.exit(0);

                case "1":
                    int milliSeconds = 15000;
                    System.out.println("0: Leave \n 1: secuencial mode (safe) \n 2: parallelism mode (unsafe) \n 3: Process time: " + milliSeconds);
                    String option = "";
                    while (option != "0"){
                        option = sc.nextLine();
                        switch (option){
                            case "1":
                                secuencialMode(milliSeconds);
                                break;
                            case "2":
                                parallelismMode(milliSeconds);
                                break;
                            case "3":
                                System.out.println("Enter process time on milliSeconds: " + milliSeconds);
                                milliSeconds = sc.nextInt();
                                break;
                        }
                    }
                case "2":
                    editKey();
                    break;
            }
        }
    }
}
