package String;

//Example:
//Input: 
//S = "heeellooo"
//words = ["hello", "hi", "helo"]
//Output: 1
//Explanation: 
//We can extend "e" and "o" in the word "hello" to get "heeellooo".
//We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more

//Algorithm:
//1. Generate run length encoding
//If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters.
//
//If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S, as the latter is extended.
//
//Else, if c1 < 3, then we must have c2 == c1 for the ith groups of word and S to match.
public class FindExpressiveWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getExpressiveWords(String input, String[] words) {
		
		
		int count = 0;
		for(String word : words) {
			
			if(IsStretchy(input, word)) {
				count++;
			}
			
		}
		return count;
		
	}
	
	public boolean IsStretchy(String input, String word) {
		
		int i=0, j=0;
		while(i<input.length() && j < word.length()) {
			
			if(input.charAt(i) == word.charAt(j)) {
				int len1 = getRepeatedLength(input, i);
				int len2 = getRepeatedLength(word, j);
				if(len1<3 && len1!=len2 || len1 >=3 && len1 < len2) {
					return false;
				}
				i += len1;
	            j += len2;
				
			} else {
				return false;
			}
			
			
		}
			
			
		return i == input.length() && j == word.length();	
			
	  }
		
		public int getRepeatedLength(String str, int i) {
			
			int j=i;
			while(j < str.length() && str.charAt(j) == str.charAt(i)) {
				j++;
			}
			
			return j-i;
		}
		
		
		
	

}
