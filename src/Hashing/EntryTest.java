package Hashing;

public class EntryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTableWithQuadProbing<Integer> hsh = new HashTableWithQuadProbing<Integer>(5);
		hsh.Insert(1, 100);
		hsh.Insert(2, 100);
		hsh.Insert(3, 100);
		Integer value = hsh.Get(1);
		System.out.print(value);

	}

}
