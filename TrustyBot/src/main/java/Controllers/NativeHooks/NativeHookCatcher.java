package Controllers.NativeHooks;

import Controllers.Timers.CatchTimer;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import repository.KeycodesRepository;
import repository.btnRepository;


public class NativeHookCatcher implements NativeKeyListener {
    private boolean stop = true;
    private int keyCode;
    private boolean flag = false;
    private String name;

    public void nativeKeyPressed(NativeKeyEvent e) {

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
                btnRepository.showList();
                this.stop = false;
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }

        this.keyCode = KeycodesRepository.getKeyByText(NativeKeyEvent.getKeyText(e.getKeyCode()));
        System.out.println(" Key Pressed: " + "JNative code: " + NativeKeyEvent.getKeyText(e.getKeyCode()) + " " + e.getKeyCode() + " Robot code " + keyCode);
        this.name = NativeKeyEvent.getKeyText(e.getKeyCode());
        this.setFlag(true);

    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}

