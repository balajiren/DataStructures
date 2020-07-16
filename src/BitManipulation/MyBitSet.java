package BitManipulation;

import java.util.BitSet;


public class MyBitSet {

	int[] bitset;
	int size;
	
	public MyBitSet(int s)
	{
		size = s;
		bitset = new int[size>> 5+1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
	}
	
	
	public void set(int pos)
	{
		int wordnumber = pos  >> 5;
		int bitnumber = pos % 32;
		bitset[wordnumber] |= 1 << bitnumber;
	}
	

	// if return 1 then exists
  public boolean get(int pos)
  {

	  int wordNumber = (pos >> 5);
	  //
		int bitNumber = pos % 32;
		
		return (bitset[wordNumber] & (1 << bitNumber)) !=0;
  }

	// if return 1 then exists
  public boolean clear(int pos)
  {

	  int wordNumber = (pos >> 5);
	  //
		int bitNumber = pos % 32;
		
		return (bitset[wordNumber] & ~(1 << bitNumber)) !=0;
  }
	
	
	public void setBit(int pos)
	{
		//divide by 32
		int wordNumber = (pos >> 5);		
		//
		int bitNumber = pos % 32;
		bitset[wordNumber] |= 1<< bitNumber;

	}

}
