package Hashing;
import java.util.*;


import java.util.HashMap;


class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

public class LRUCacheImpl<T> {
    int capacity;
    HashMap<Integer, CacheNode<Integer>> map = new HashMap<Integer, CacheNode<Integer>>();
    CacheNode<Integer> head=null;
    CacheNode<Integer> end=null;
 
    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            CacheNode<Integer> n = map.get(key);
            remove(n);
            setHead(n);
            return n.data;
        }
 
        return -1;
    }
 
    public void remove(CacheNode<Integer> n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(CacheNode<Integer> n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
   public void set(int key, int value) {
        if(map.containsKey(key)){
            CacheNode<Integer> old = map.get(key);
            old.data = value;
            remove(old);
            setHead(old);
        }else{
            CacheNode<Integer> created = new CacheNode<Integer>(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    } 
}