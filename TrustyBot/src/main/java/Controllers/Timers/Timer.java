package Controllers.Timers;

import Controllers.NativeHooks.NativeHook;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class Timer extends Thread{
    private int timeLimit;
    private boolean finishedFlag;

    public Timer(int timeLimit, boolean finishedFlag) {
        this.timeLimit = timeLimit;
        this.finishedFlag = finishedFlag;
    }

    public void run() {
        try {
            GlobalScreen.registerNativeHook();
            NativeHook hook = new NativeHook();
            GlobalScreen.addNativeKeyListener(hook);

            long starTime = System.currentTimeMillis();
            long timeElapsed = 0;
            while (timeElapsed <= timeLimit) {
                Thread.sleep(10);
                timeElapsed = System.currentTimeMillis() - starTime;
                System.out.println("Time elapsed: " + timeElapsed);
            }
            finishedFlag = false;
            System.out.println("Finished flag on timer: " + isFinishedFlag());
            GlobalScreen.removeNativeKeyListener(hook);
        } catch (NativeHookException | InterruptedException e) {
            throw new RuntimeException(e);
        }
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
