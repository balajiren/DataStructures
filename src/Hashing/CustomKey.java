package Hashing;
import java.util.*;

public class CustomKey {

    public static void main(String[] args)
    {
        //Create a HashMap with mutable key
        HashMap<CustomKey, String> map = new HashMap<CustomKey, String>();

        //Create key 1
        CustomKey a1 = new CustomKey(1);
        a1.setHolderName("A_ONE");
        //Create key 2
        CustomKey a2 = new CustomKey(2);
        a2.setHolderName("A_TWO");

        //Put mutable key and value in map
        map.put(a1, a1.getHolderName());
        map.put(a2, a2.getHolderName());

        //Change the keys state so hash map should be calculated again
        a1.setHolderName("Defaulter");
        a2.setHolderName("Bankrupt");

        //Success !! We are able to get back the values
        System.out.println(map.get(a1)); //Prints A_ONE
        System.out.println(map.get(a2)); //Prints A_TWO

        //Try with newly created key with same CustomKey number
        CustomKey a3 = new CustomKey(1);
        a3.setHolderName("A_THREE");

        //Success !! We are still able to get back the value for CustomKey number 1
        System.out.println(map.get(a3)); //Prints A_ONE
    }

    private int CustomKeyNumber;
    private String holderName;

    public CustomKey(int CustomKeyNumber) {
        this.CustomKeyNumber = CustomKeyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getCustomKeyNumber() {
        return CustomKeyNumber;
    }

    //Depends only on CustomKey number
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + CustomKeyNumber;
        return result;
    }

    //Compare only CustomKey numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomKey other = (CustomKey) obj;
        if (CustomKeyNumber != other.CustomKeyNumber)
            return false;
        return true;
    }

}
