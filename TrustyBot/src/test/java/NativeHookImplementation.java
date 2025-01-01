import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class NativeHookImplementation implements NativeKeyListener {
    public static void main(String[] args) throws NativeHookException, InterruptedException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new NativeHookImplementation());

        long startime = System.currentTimeMillis();
        long tiempoTranscurrido = 0;
        //Hace un procedo en un determinado tiempo
        while (tiempoTranscurrido <= 50000){
            System.out.println("Hola mundo");
            Thread.sleep(10);
            tiempoTranscurrido = System.currentTimeMillis() - startime;
        }




    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + e.getKeyCode());
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
                System.exit(0);
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }
}
