package Controllers;

import Models.KeyBtn;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import Controllers.NativeHook.*;
import repository.btnRepository;

import java.awt.*;

public class secuencialModeController extends Thread{
    private int timeLimit = 15000;
    private boolean finishedFlag = false;

    public secuencialModeController(int timeLimit, boolean finishedFlag) {
        this.timeLimit = timeLimit;
        this.finishedFlag = finishedFlag;
    }

    public void run() {
        System.out.println("Hola mundo");

        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeHook());

            long startime = System.currentTimeMillis();
            long timeElapsed = 0;
            while (timeElapsed <= timeLimit){
                Thread.sleep(10);
                timeElapsed = System.currentTimeMillis() - startime;
                System.out.println("Time elapsed: " + timeElapsed);
            }
            finishedFlag = false;
            System.out.println("valor de finished flag en timer: " + isFinishedFlag());
        } catch (NativeHookException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void init(int timeLimit) throws NativeHookException, InterruptedException, AWTException {
        secuencialModeController h1 = new secuencialModeController(timeLimit, true);
        h1.start();
        Robot trustyBot = new Robot();
        while (h1.isFinishedFlag()) {
            System.out.println("Pulsando teclas");
            for (int i = 0; i < btnRepository.keyListSize(); i++) {
                KeyBtn key = btnRepository.getKey(i);
                key.pressbtn(trustyBot);
                sleep(key.getDelay());
                System.out.println("valor de finished flag en principal: " + h1.isFinishedFlag());
            }
        }

        System.out.println("Finalizado");
        h1.interrupt();
    }

    public boolean isFinishedFlag() {
        return finishedFlag;
    }

    public void setFinishedFlag(boolean finishedFlag) {
        this.finishedFlag = finishedFlag;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
