package RateLimiter;

import java.util.Date;

class LeakyBucketRateLimiter {
    private int numDropsInBucket = 0;
    private Date timeOfLastDropLeak = null;
    private final int _BUCKET_SIZE_IN_DROPS = 20;
    private final long _MS_BETWEEN_DROP_LEAKS = 1000 * 60 * 60; // 1 hour

    public synchronized boolean addDropToBucket() {
        Date now = new Date();
        // first of all, let the bucket leak by the appropriate amount
        if (timeOfLastDropLeak != null) {
            long deltaT = now.getTime() - timeOfLastDropLeak.getTime();
            // note round down as part of integer arithmetic
            long numberToLeak = deltaT / _MS_BETWEEN_DROP_LEAKS;
            if (numberToLeak > 0) { //now go and do the leak
                if (numDropsInBucket <= numberToLeak) {
                    numDropsInBucket = 0;
                } else {
                    numDropsInBucket -= (int) numberToLeak;
                }
                timeOfLastDropLeak = now;
            }
        }

        if (numDropsInBucket < _BUCKET_SIZE_IN_DROPS) {
            numDropsInBucket++;
            return true; // drop added
        }

        return false; // overflow
    }
}
