import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class KeycodesRepository {
    Map<String, Integer> keycodes;

    public KeycodesRepository() {
        for(int i = 0; i < 1000000; ++i) {
            String text = java.awt.event.KeyEvent.getKeyText(i);
            if(!text.contains("Unknown keyCode: ")) {
                keycodes.put(text, i);
            }
        }
    }
}
