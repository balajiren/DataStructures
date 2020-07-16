package DesignPatterns;
import java.util.*;



 interface Subject 
	{
	    public void attach(Observer o);
	    public void detach(Observer o);
	    public void notifyUpdate(Message m);
	}

 interface Observer 
{
    public void update(Message m);
}
 class Message 
{
    final String messageContent;
     
    public Message (String m) {
        this.messageContent = m;
    }
 
    public String getMessageContent() {
        return messageContent;
    }
}
 class MessagePublisher implements Subject {
    
    private List<Observer> observers = new ArrayList<>();
 
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
 
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyUpdate(Message m) {
        for(Observer o: observers) {
            o.update(m);
        }
    }
}
 
 class MessageSubscriberOne implements Observer 
 {
     @Override
     public void update(Message m) {
         System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
     }
 }
 
 public class Observor 
 {
     public static void main(String[] args) 
     {
         MessageSubscriberOne s1 = new MessageSubscriberOne();

          
         MessagePublisher p = new MessagePublisher();
          
         p.attach(s1);

          
         p.notifyUpdate(new Message("First Message"));   //s1 and s2 will receive the update
          
         p.detach(s1);
 
          
         p.notifyUpdate(new Message("Second Message")); //s2 and s3 will receive the update
     }
 }