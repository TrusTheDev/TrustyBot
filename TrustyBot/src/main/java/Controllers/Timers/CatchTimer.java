package Controllers.Timers;

import Controllers.NativeHooks.NativeHookCatcher;
import Models.KeyBtn;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import repository.btnRepository;

public class CatchTimer extends Thread {
    boolean finishedFlag = true;

    public void run() {
        try {
            GlobalScreen.registerNativeHook();
            NativeHookCatcher hook = new NativeHookCatcher();
            GlobalScreen.addNativeKeyListener(hook);

            long starTime = System.currentTimeMillis();
            long timeElapsed = 0;
            while (hook.isStop()) {
                Thread.sleep(10);
                timeElapsed = System.currentTimeMillis() - starTime;
                if (hook.isFlag()){
                    btnRepository.saveKey(new KeyBtn(1000, hook.getKeyCode(), (int) timeElapsed, hook.getName()));
                    hook.setFlag(false);
                }
            }
            setFinishedFlag(false);
            System.out.println("Finished flag on timer: " + isFinishedFlag());
            GlobalScreen.removeNativeKeyListener(hook);
        } catch (NativeHookException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean isFinishedFlag() {
        return finishedFlag;
    }

    public void setFinishedFlag(boolean finishedFlag) {
        this.finishedFlag = finishedFlag;
    }
}
