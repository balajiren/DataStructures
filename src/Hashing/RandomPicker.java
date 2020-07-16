package Hashing;

import java.util.*;
//Design a data structure that supports insert, delete, search and getRandom 
//in constant time

public class RandomPicker {
    Random r;
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> map;
    int length;
    
    public RandomPicker(){
        this.r = new Random();
        this.arr = new ArrayList<>();
        this.map = new HashMap<>();
        this.length = 0;
    }
    
    public void add(int key){
        arr.add(length, key);
        map.put(key, length);
        length++;
    }
    
    public void delete(int key){
        int idx = map.get(key);
        int tmp = arr.get(length - 1);
        arr.set(length - 1, key);
        arr.set(idx, tmp);
        map.put(tmp, idx);
        length--;
    }
    
    public int getRandom(){
        return arr.get(r.nextInt(length));
    }
}
