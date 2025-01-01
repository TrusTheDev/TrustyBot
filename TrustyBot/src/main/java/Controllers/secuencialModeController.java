package Controllers;

import Models.KeyBtn;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import Controllers.NativeHook.*;

public class secuencialModeController {

    private void run(int timeLimit) throws NativeHookException, InterruptedException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new NativeHook());

        long startime = System.currentTimeMillis();
        long timeElapsed = 0;
        while (timeElapsed <= timeLimit){
            Thread.sleep(10);
            timeElapsed = System.currentTimeMillis() - startime;
        }

    }


    public static void init(int timeLimit) throws NativeHookException, InterruptedException {


    }


}
