package String;

import java.util.*;

public class GenStack<T>{ //T is the type parameter
     
    private Node top;   //top of stack
     
    public class Node { //defines each node of stack
        T value;    
        Node next;
 
        public Node(T value){         
            this.value=value;  //initializing         
            next=null;       
        }       
    }
 
//A Method to perform a stack push.
public void push(T item){
    Node current=new Node(item);     
    if(empty())        
        top=current; //if empty stack     
    else{        
        current.next=top;        
        top=current;     
    }
}
 
//A method to perform a stack pop and return what was popped. Throw EmptyStackException when attempting to pop an empty stack.
public T pop() throws EmptyStackException{
    T value=null;     
        if(!empty()){         
            top=top.next;         
            value=top.value;     
        }     
    return value;  //returning popped value
}
 
//Returns the top value of the stack without performing a pop. Think of this as peeking instead of popping.
public T top(){
    if (empty()) throw new NoSuchElementException("Stack underflow");
        return top.value;
}
 
//Returns true if stack is empty.
public boolean empty(){ 
    return top == null;
}
 
//This function returns the entire stack    
public void dumpStack() {
    Node p = top;   
    while ( p != null ) {    
        System.out.println(p.value);    
        p = p.next;  
    }
}
}