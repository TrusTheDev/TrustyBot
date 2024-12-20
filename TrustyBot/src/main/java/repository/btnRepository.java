package repository;

import Models.KeyBtn;

import java.util.ArrayList;
import java.util.List;

public class btnRepository {
    List<KeyBtn> Keybtns = new ArrayList<>();

    public boolean saveKey(KeyBtn key){
        return Keybtns.add(key);
    }

    public void clearRepo(){
        Keybtns.clear();
    }

    public KeyBtn getKey(int i){
        return Keybtns.get(i);
    }
}
