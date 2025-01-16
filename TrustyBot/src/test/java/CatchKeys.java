
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class CatchKeys extends Thread{
    int timeLimit = 15000;
    boolean finishedFlag = true;

    public CatchKeys(int timeLimit, boolean finishedFlag) {
        this.timeLimit = timeLimit;
        this.finishedFlag = finishedFlag;
    }



    public void run() {
        try {
            GlobalScreen.registerNativeHook();
            NativeHookBtn hook = new NativeHookBtn();
            GlobalScreen.addNativeKeyListener(hook);

            long starTime = System.currentTimeMillis();
            long timeElapsed = 0;
            while (timeElapsed <= timeLimit) {
                Thread.sleep(10);
                timeElapsed = System.currentTimeMillis() - starTime;
                //System.out.println("Time elapsed: " + timeElapsed);
                if (hook.isFlag()){

                    hook.setFlag(false);
                }
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

    public static void main(String[] args) {
        CatchKeys timer = new CatchKeys(99999999, true);
        timer.start();
//        for(int i = 0; i < 1000000; ++i) {
//            String text = java.awt.event.KeyEvent.getKeyText(i);
//            if(!text.contains("Unknown keyCode: ")) {
//                System.out.println("" + i + " -- " + text);
//            }
//        }
    }
}


