package DHT;

public class Utility {

    public static int parseInt(String s){
        return Integer.parseInt(s);
    }

    /**
     * getKey : A method to calculate and integer value for given string.
     * @param value A value to be stored in hash table.
     * @return An integer value to be processed as key.
     */
    public static int getKey(String value){
        int key = 0;
        for (int i=0; i < value.length(); i++)
            key += value.charAt(i);
        return key % Settings.getInstance().Modulo;
    }

}
