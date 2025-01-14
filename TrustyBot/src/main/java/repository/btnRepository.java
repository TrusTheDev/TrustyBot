package repository;

import Models.KeyBtn;

import java.util.ArrayList;
import java.util.List;

public class btnRepository {
    static List<KeyBtn> Keybtns = new ArrayList<>();

    public static boolean saveKey(KeyBtn key){
        return Keybtns.add(key);
    }

    public static void updateKey(int index, KeyBtn key){
        Keybtns.set(index, key);
    }

    public static void clearList(){
        Keybtns.clear();
    }

    public static void showList(){
        for(int i=0; i< Keybtns.size(); i++){
            System.out.println( i + ": " + btnRepository.getKey(i).getName());
        }
    }
    public static KeyBtn getKey(int i){
        return Keybtns.get(i);
    }

    //Use a java optional here.
    public static KeyBtn getKeyByName(String name){
        for(int i=0; i<Keybtns.size(); i++) {
            KeyBtn key = btnRepository.getKey(i);
            if (key.getName().equals(name)) {
                return key;
            }
        }
         KeyBtn ddada = new KeyBtn(2,2,2, "Error");
        return ddada;
    }
    public static int getKeyIndexByName(String name){
        for(int i=0; i<Keybtns.size(); i++){
            if (btnRepository.getKey(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;

    }
    public static boolean keyNameExists(String name){
        for(int i=0; i<Keybtns.size(); i++){
            KeyBtn key = btnRepository.getKey(i);
            if(key.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public static int keyListSize(){
        return Keybtns.size();
    }
}
