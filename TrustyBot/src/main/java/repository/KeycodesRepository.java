package repository;

import java.util.HashMap;


public class KeycodesRepository {
     static HashMap<String, Integer> keycodes = new HashMap<>();

     public static void initList() {
         for(int i = 0; i < 1000000; ++i) {
             String text = java.awt.event.KeyEvent.getKeyText(i);
             if(!text.contains("Unknown keyCode: ")) {
                 keycodes.put(text,i);
             }
         }
     }

     public static int getKeyByText(String keyName){
         return keycodes.get(keyName);
     }

}
