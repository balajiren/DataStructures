import java.util.*;

class LFUCache {
    private Map<Integer,PQNode> map;
    private PriorityQueue<PQNode> pq;
    private int cap;
    private static int timer;
    public LFUCache(int capacity) {
        map = new HashMap();
        pq = new PriorityQueue<PQNode>(
            (a, b)->(a.count ==b.count?(a.timer-b.timer):(a.count-b.count)));
        cap = capacity;
        timer = 0;
    }
    private void remove(PQNode node) {
        map.remove(node.key);
        pq.remove(node);
    }
    private void add(PQNode node) {
        map.put(node.key, node);
        pq.offer(node);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	PQNode node = map.get(key);
            remove(node);
            add(new PQNode(node.key, node.val, node.count+1, timer++));
            return node.val;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
        	PQNode node = map.get(key);
            remove(node);
            add(new PQNode(key, value, node.count+1, timer++));
        } else {
            if (cap!=0) {
                if (map.size()==cap) remove((PQNode) pq.peek());
                add(new PQNode(key, value, 1, timer++));
            }
        }
    }
}

class PQNode {
    int key;
    int val;
    int count;
    int timer;
    public PQNode(int k, int v, int c, int t) {
        this.key = k;
        this.val = v;
        this.count = c;
        this.timer = t;
    }
}
