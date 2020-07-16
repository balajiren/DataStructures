package ArrayQuestions;

public class FindCelebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 private int numberOfPeople;
	    public int findCelebrity(int n) {
	        numberOfPeople = n;
	        int celebrityCandidate = 0;
	        
	        for(int i=0;i<n;i++) {
	            if(knows(celebrityCandidate,i)) {
	                celebrityCandidate =  i;
	            }
	        }
	        if(iscelebrity(celebrityCandidate)) {
	            return celebrityCandidate;
	        }
	        
	        return -1;
	    }
	    
	    //assuming it returns true	
	    private boolean knows(int i,int j) {
	    	return false;
	    }
	    
	    public boolean iscelebrity(int i) {
	        for(int j=0;j<numberOfPeople;j++) {
	            if(i==j) continue;
	            if(knows(i,j) || !knows(j,i)) {
	                return false;
	            }
	            
	        }
	        return true;
	    }

}
