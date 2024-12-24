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

    public static int keyListSize(){
        return Keybtns.size();
    }
}
