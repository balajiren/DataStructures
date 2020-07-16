package BitSet;

public class CustomBitSet {

	int[] bitSet;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public CustomBitSet(int size)
	{
		bitSet = new int[size >> 5];
		
		
	}
	
	void set(int pos)
	{
		int wordNumber = pos >> 5;
		int bitNumber = pos % 32;
		bitSet[wordNumber] |= 1 << bitNumber;
	}
	
	boolean get(int pos)
	{
		int wordNumber = pos >> 5;
		int bitNumber = pos % 32;
		return (bitSet[wordNumber] & (1 << bitNumber))!=0;	
		
		
	}
	

}
