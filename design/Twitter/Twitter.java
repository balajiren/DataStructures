package Twitter;
import java.util.*;



class Tweet {
	
	int userId;
	int tweetId;
	int timeStamp;
	
	Tweet(int _userId) {
		
		this.userId = _userId;
	}
	
	public void addTweet(int _tweetId, int _ts) {
		this.tweetId = _tweetId;
		this.timeStamp = _ts;
	}
	
}

class Twitter {
    
    class User {
        Set<User> f;
        int id;
        Tweet tweetHead;
        public User(int id) {
            this.id = id;
            this.f = new HashSet<>();
        }
        
        public void follow(User user) {
            if (!f.contains(user)) f.add(user);
        }
        
        public void unfollow(User user) {
            if (f.contains(user)) f.remove(user);
        }
        
        public void tweet(int id) {
            Tweet t = new Tweet(id);
            t.user = this;
            t.next = tweetHead;
            tweetHead = t;
        }
    }
    
    class Tweet {
        int id;
        int time;
        Tweet next;
        User user;
        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            this.next = null;
        }
    }
    
    private static int timestamp = 0;
    Map<Integer, User> map;

    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)) {
            User user = new User(userId);
            map.put(userId, user);
        }
        User user = map.get(userId);
        user.tweet(tweetId);
    }
    
    
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(userId)) return res;
        User u = map.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a, b) -> (b.time - a.time));
        for (User f : u.f) {
            if (f.tweetHead != null) pq.offer(f.tweetHead);  // avoid null pointer
        }
        if (u.tweetHead != null) pq.offer(u.tweetHead); // don't forget to put userself
        while (!pq.isEmpty()) {
            // System.out.println(pq.size() + " " + pq.peek().id);
            Tweet curr = pq.poll();
            res.add(curr.id);
            if(res.size() >= 10) return res;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;    // not yourself
        if(!map.containsKey(followerId)) {
            User follower = new User(followerId);
            map.put(followerId, follower);
        }
        
        if(!map.containsKey(followeeId)) {
            User followee = new User(followeeId);
            map.put(followeeId, followee);
        }
        
        map.get(followerId).follow(map.get(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if(!map.containsKey(followeeId) || !map.containsKey(followerId)) {
            return;
        }
        map.get(followerId).unfollow(map.get(followeeId));

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
