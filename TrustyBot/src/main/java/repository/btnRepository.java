package repository;

import Models.KeyBtn;

import java.util.ArrayList;
import java.util.List;

public class btnRepository {
    static List<KeyBtn> Keybtns = new ArrayList<>();

    public static boolean saveKey(KeyBtn key){
        return Keybtns.add(key);
    }

    public static void clearRepo(){
        Keybtns.clear();
    }

    public static KeyBtn getKey(int i){
        return Keybtns.get(i);
    }
    //Utilizar un java optional
    public static KeyBtn getKeyByName(String name){
        for(int i=0; i<Keybtns.size(); i++) {
            KeyBtn key = btnRepository.getKey(i);
            if (key.getName() == name) {
                return key;
            }
        }
         KeyBtn ddada = new KeyBtn(2,2,2, "Hola mundoi");
        return ddada;
    }
    //Utilizar un java optional
    public static boolean keyNameExists(String name){
        for(int i=0; i<Keybtns.size(); i++){
            KeyBtn key = btnRepository.getKey(i);
            if(key.getName() == name){
                return true;
            }
        }
        return false;
    }

    public static int keyListSize(){
        return Keybtns.size();
    }
}
