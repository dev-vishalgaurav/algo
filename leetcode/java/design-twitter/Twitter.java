/**
 * https://leetcode.com/problems/design-twitter/
 */
public class Twitter {
    private class Tweet {
        private Long tweetCounter;
        private int tweetId;

        private Tweet(long conter, int id) {
            tweetCounter = conter;
            tweetId = id;
        }
    }

    private class IdComparator implements Comparator<Tweet> {

        public int compare(Tweet o1, Tweet o2) {
            return -1 * o1.tweetCounter.compareTo(o2.tweetCounter);
        }
    }

    private class User {
        HashSet<Integer> followers;
        PriorityQueue<Tweet> tweets;

        private User(Comparator<Tweet> sorter) {
            followers = new HashSet<Integer>();
            tweets = new PriorityQueue<Tweet>(10, sorter);
        }
    }

    private Comparator<Tweet> comparator = null;
    private HashMap<Integer, User> userMap;
    private long tweetCounter = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        comparator = new IdComparator();
        userMap = new HashMap<>();
    }

    private void ensureUser(int userId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(comparator));
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetCounter++;
        ensureUser(userId);
        User user = userMap.get(userId);
        if (user.tweets.size() >= 10) {
            user.tweets.poll();
        }
        userMap.get(userId).tweets.add(new Tweet(tweetCounter, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
     * in the news feed must be posted by users who the user followed or by the
     * user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(10, comparator);
        if (userMap.containsKey(userId)) {
            User me = userMap.get(userId);
            tweetHeap.addAll(me.tweets);
            for (int followee : me.followers) {
                tweetHeap.addAll(userMap.get(followee).tweets);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int size = tweetHeap.size();
        for (int i = 0; i < size; i++) {
            result.add(tweetHeap.poll().tweetId);
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId != followerId) {
            ensureUser(followerId);
            ensureUser(followeeId);
            userMap.get(followerId).followers.add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be
     * a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).followers.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */