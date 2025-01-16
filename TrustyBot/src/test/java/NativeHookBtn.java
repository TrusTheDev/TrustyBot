import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class NativeHookBtn implements NativeKeyListener {
    private int keyCode = 5;
    private boolean flag = false;


    public void nativeKeyPressed(NativeKeyEvent e) {

        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()) + " " + e.getKeyCode());
        this.keyCode = e.getKeyCode();
        this.setFlag(true);
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
                System.exit(0);
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }

//    public int nativeKeycodeToJavaKeycode(int nativeKeycode){
//        int keycode;
//    }

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
}

