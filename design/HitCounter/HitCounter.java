package HitCounter;

import java.util.*;

/* TO GET LAST 60 SECONDS USE CIRCULAR ARRAY/DEQUE */

public class HitCounter {
    private final int WINDOW_SIZE = 300;
    class TimeSlot {
        public TimeSlot(long t) {
            time = t;
            hits = 1;
            
        }
        private long time;
        private long hits;      
    }
    
    private long hits;
    private long time;

    
    private Deque<TimeSlot> slots = new ArrayDeque<>(WINDOW_SIZE * 60);
    
    HitCounter() {
        time = System.currentTimeMillis()/1000;
    }
   private   void resize(long current) {    
        long before = current - WINDOW_SIZE;
        while (slots.size() > 0 && slots.getFirst().time < before) {
            hits -= slots.removeFirst().hits;             
        }
        if (slots.size() == 0) {            
            slots.add(new TimeSlot(current));
            
        }       
        time = slots.getFirst().time;
        
    }
    public void hit() {
        long current = System.currentTimeMillis()/1000;  
        if (time < current - WINDOW_SIZE)  {
            resize(current);           
        }
        else {
            if (slots.size() > 0 && slots.getLast().time == time) {
                slots.getLast().hits++;               
            } else {
                slots.add(new TimeSlot(current));
            }           
        }       
        hits++;
    }

    public long getHits() {
        long current = System.currentTimeMillis()/1000;       
        if (time < current - WINDOW_SIZE) 
            resize(current);
        return hits;
    }
}