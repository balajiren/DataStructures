package ArrayQuestions;
import java.util.*;
public class ArrayCustomSorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = new String[] {"swathi","balaji","nethra"};
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				//1 means lex follow -1 means lex before 0 means equal
				return o1.compareTo(o2);
			}
			
		});
		
		System.out.print(Arrays.toString(str));

	}
	
	

}
