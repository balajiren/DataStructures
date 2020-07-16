package RateLimiter;

/* public class TokenBucket {
    private final RefillStrategy refillStrategy;
    private final long capacity;
    private AtomicLong size;

    public TokenBucket(long capacity, RefillStrategy refillStrategy) {
        this.refillStrategy = refillStrategy;
        This.capacity = capacity;
        This.size = new AtomicLong(0L);
    }

    public void consume(long numTokens) throws InterruptedException {
        If (numTokens < 0)
            Throw new RuntimeException("Number of tokens to consume must be positive");
        If (numTokens >= capacity)
            Throw new RuntimeException("Number of tokens to consume must be less than the capacity of the bucket");

        Long newTokens = Math.max(0, refillStrategy.refill());
        While (!Thread.currentThread().isInterrupted()) {
            Long existingSize = size.get();
            Long newValue = Math.max(0, Math.min(existingSize + newTokens, capacity));
            If (numTokens <= newValue) {
                newValue -= numTokens;
                If (size.compareAndSet(existingSize, newValue))
                    Break;
            } else {
                Thread.sleep(refillStrategy.getIntervalInMillis());
                newTokens = Math.max(0, refillStrategy.refill());
            }
        }
    }
public class FixedIntervalRefillStrategy implements TokenBucket.RefillStrategy {
    private final long numTokens;
    private final long intervalInMillis;
    private AtomicLong nextRefillTime;

   public FixedIntervalRefillStrategy(long numTokens, long interval, TimeUnit unit) {
        this.numTokens = numTokens;
        this.intervalInMillis = unit.toMillis(interval);
        this.nextRefillTime = new AtomicLong(-1L);
    }

    public long refill() {
        Final long now = System.currentTimeMillis();
        Final long refillTime = nextRefillTime.get();
        If (now < refillTime) {
            return 0;
        }
        
        return nextRefillTime.compareAndSet(refillTime, now + intervalInMillis) ? numTokens : 0;
    }

    public long getIntervalInMillis() {
        return intervalInMillis;
    }

} */


