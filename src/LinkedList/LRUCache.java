package LinkedList;

import java.util.HashMap;

public class LRUCache<T> {
    int capacity;
    HashMap<Integer, Node<Integer>> map = new HashMap<Integer, Node<Integer>>();
    Node<Integer> head=null;
    Node<Integer> end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            Node<Integer> n = map.get(key);
            remove(n);
            setHead(n);
            return n.data;
        }
 
        return -1;
    }
 
    public void remove(Node<Integer> n){
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
 
    public void setHead(Node<Integer> n){
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
            Node<Integer> old = map.get(key);
            old.data = value;
            remove(old);
            setHead(old);
        }else{
            Node<Integer> created = new Node<Integer>(key, value);
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