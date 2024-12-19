package keycode;

import java.util.HashMap;

public class keycodes {
    public HashMap getKeycodeMap() {
        HashMap<String, Integer> keycodes = new HashMap<>();
        for (int i = 0; i < 1000000; ++i) {
            String text = java.awt.event.KeyEvent.getKeyText(i);
            if (!text.contains("Unknown keyCode: ")) {
                keycodes.put(text, i);
            }
        }
        return keycodes;
    }

    public int getKeycode(String input) {
        HashMap keycode = getKeycodeMap();
        return (keycode.containsKey(input)) ? (int) keycode.get(input) : 0;
    }

}
