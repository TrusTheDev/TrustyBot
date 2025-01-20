import Models.KeyBtn;
import com.github.kwhat.jnativehook.NativeHookException;
import repository.btnRepository;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static View.view.*;

public class main {
    public static void main(String[] args) throws NativeHookException, InterruptedException, AWTException, IOException {
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            KeyBtn a = new KeyBtn(1000, 65, 1000, "a");
            KeyBtn b = new KeyBtn(1000, 66, 1000, "b");
            KeyBtn c = new KeyBtn(1000, 67, 1000, "c");
            btnRepository.saveKey(a);
            btnRepository.saveKey(b);
            btnRepository.saveKey(c);
            System.out.println("Welcome to TrustyBot! \n 0: close \n 1: initialize \n 2:create/edit keys ");
             String option = reader.readLine();

            switch (option) {
                case "0":
                    System.exit(0);
                case "1":
                    int milliSeconds = 15000;
                    System.out.println("0: Leave \n 1: secuencial mode (safe) \n 2: parallelism mode (unsafe) \n 3: Process time: " + milliSeconds);
                    option = reader.readLine();
                    while (!option.equals("0")){
                        switch (option){
                            case "1":
                                secuencialMode(milliSeconds);
                                break;
                            case "2":
                                parallelismMode(milliSeconds);
                                break;
                            case "3":
                                System.out.println("Enter process time on milliSeconds: " + milliSeconds);
                                milliSeconds = Integer.parseInt(reader.readLine());
                                break;
                        }
                    }
                case "2":
                    System.out.println("0: Leave 1: edit key 2: Autoconfiguration");
                    switch (reader.readLine()){
                        case "0":
                            break;
                        case "1":
                            editKey();
                            break;
                        case "2":
                            AutoConfiguration();
                            break;
                    }
                    System.out.println("Después de la opcion 2 del switch");
                    break;
            }
        }
    }
}
