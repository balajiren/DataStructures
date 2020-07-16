package RateLimiter;

import java.util.Date;

public class RateLimiterImpl {
	
	private int _capacity = 100;
	private int _refillamount= 10;
	private int _size= 0;
	private long _lastAccessed;
	private long _refillTime = 20;
	private long _refillCount = 20;
	RateLimiterImpl(int refillAmount)
	{
		_refillamount = refillAmount;
		_size = refillAmount;
		
	}
	
	
	public boolean allowUser()
	{
		_lastAccessed = System.currentTimeMillis();
		if(this.getBucketSize() == 0)
		{
			return false;
			
		} else
		{
			
			this._size--;
		}
		
		return true;
	}
	
	public void RefillTokens()
	{
		long tokentoFill = (System.currentTimeMillis() - _lastAccessed)/ _refillTime;
		
		
	}
	
	public long getBucketSize()
	{
		long tokentoFill = (System.currentTimeMillis() - _lastAccessed)/ _refillTime;
		 Math.min(this._capacity, this._size + this._refillamount *  tokentoFill);
		
		long lastUpdate = Math.max(System.currentTimeMillis(),(this._lastAccessed  + this._refillamount *  _refillTime));
		return 0;
	}

}
