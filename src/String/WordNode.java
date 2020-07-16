package String;

public class WordNode {

	public String word;
	public int  numOfSteps;
	public WordNode pre;
	 
	public WordNode(String word, int numOfSteps, WordNode pre) {
		// TODO Auto-generated constructor stub
		this.word = word;
		this.numOfSteps = numOfSteps;
		this.pre = pre;
	}

}
