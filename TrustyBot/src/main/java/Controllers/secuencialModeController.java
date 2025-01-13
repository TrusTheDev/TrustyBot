package Controllers;

import Models.KeyBtn;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import Controllers.NativeHook.*;
import repository.btnRepository;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
            NativeHook hook = new NativeHook();
            GlobalScreen.addNativeKeyListener(hook);

            long startime = System.currentTimeMillis();
            long timeElapsed = 0;
            while (timeElapsed <= timeLimit){
                Thread.sleep(10);
                timeElapsed = System.currentTimeMillis() - startime;
                System.out.println("Time elapsed: " + timeElapsed);
            }
            finishedFlag = false;
            System.out.println("valor de finished flag en timer: " + isFinishedFlag());
            GlobalScreen.removeNativeKeyListener(hook);
        } catch (NativeHookException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void init(int timeLimit) throws NativeHookException, InterruptedException, AWTException {
        secuencialModeController timer = new secuencialModeController(timeLimit, true);
        timer.start();
        Robot trustyBot = new Robot();
        sleep(2000);
        while (timer.isFinishedFlag()) {
            System.out.println("Pulsando teclas paralelamente");
            for( int i = 0; i < btnRepository.keyListSize(); i++){
                KeyBtn key = btnRepository.getKey(i);
                key.pressBtn(trustyBot);
                System.out.println("valor de finished flag en principal: " + timer.isFinishedFlag());
            }
            System.out.println("Durmiendo hilo principal");
            sleep(1000);
        }
        System.out.println("Finalizado");
        timer.interrupt();
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
