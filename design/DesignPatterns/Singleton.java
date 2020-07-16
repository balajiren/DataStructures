package DesignPatterns;


public final class Singleton {
    private static volatile Singleton instance = null;
 
    // private constructor
    private Singleton() {
    }
 
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

}
