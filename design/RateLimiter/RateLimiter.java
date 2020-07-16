package RateLimiter;

//https://www.linkedin.com/pulse/api-rate-limiting-using-token-bucket-algorithm-siddharth-patnaik/

public class RateLimiter {

	private long capacity;
	private long windowTimeInSeconds;
	
	long lastRefillTimeStamp;
	long availabletokens;
	long refillCountPerSecond;
	
	
	public RateLimiter(long _capacity, long windowTimeInSeconds) {
		
        this.capacity = capacity;
        this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStamp = System.currentTimeMillis();
        refillCountPerSecond = capacity/windowTimeInSeconds;
        availabletokens  = 0;
	}
	
	public long getAvailableTokens() {
		
		return this.availabletokens;
		
	}
	
	public boolean TryConsume() {
		refill();
		if (this.availabletokens > 0) {
			this.availabletokens --;
			return true;
		} else {
			return false;
		}
		
	}
	
	private void refill() {
		long now = System.currentTimeMillis();
        if(now > lastRefillTimeStamp) {
        	long elapsedTime = now - lastRefillTimeStamp;
        	long tokensToBeAdded = (elapsedTime/1000) * refillCountPerSecond;
        	if(tokensToBeAdded > 0) {
        		this.availabletokens = Math.min(capacity,this.availabletokens + tokensToBeAdded);
        		lastRefillTimeStamp = now;
        	}
        	
        	
        }
		
		
	}
}
