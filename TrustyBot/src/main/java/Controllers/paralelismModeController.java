package Controllers;

import Models.KeyBtn;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import repository.btnRepository;

public class paralelismModeController extends Thread {
    private int timeLimit = 15000;
    private boolean finishedFlag = true;

    public paralelismModeController(int timeLimit, boolean finishedFlag) {
        this.timeLimit = timeLimit;
        this.finishedFlag = finishedFlag;
    }

    public void run() {
        try {
            GlobalScreen.registerNativeHook();
            NativeHook hook = new NativeHook();
            GlobalScreen.addNativeKeyListener(hook);

            long startime = System.currentTimeMillis();
            long timeElapsed = 0;
            while (timeElapsed <= timeLimit) {
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

    public static void init(int timeLimit) throws InterruptedException {
        paralelismModeController timer = new paralelismModeController(timeLimit, true);
        System.out.println("Iniciando paralelism mode");
        timer.start();
        while(timer.isFinishedFlag()){
            System.out.println("Pulsando teclas paralelamente");
            for( int i = 0; i < btnRepository.keyListSize(); i++){
                KeyBtn key = btnRepository.getKey(i);
                key.pressThreadBtn(key);
                System.out.println("valor de finished flag en principal: " + timer.isFinishedFlag());
                System.out.println(Thread.currentThread().getId());
            }
            sleep(1000);
        }
        System.out.println("Finalizado");
        timer.interrupt();

    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isFinishedFlag() {
        return finishedFlag;
    }

    public void setFinishedFlag(boolean finishedFlag) {
        this.finishedFlag = finishedFlag;
    }
}
