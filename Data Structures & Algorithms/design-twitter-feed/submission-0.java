class Tweet {
    int tweetid, userid, time;
    Tweet next;

    Tweet(int t, int u, int ti) {
        tweetid = t;
        userid = u;
        time = ti;
        next = null;
    }
}

class Twitter {

    Map<Integer, Set<Integer>> followermap;
    Map<Integer, Tweet> tweetmap;
    int time;

    public Twitter() {
        followermap = new HashMap<>();
        tweetmap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        Tweet newTweet = new Tweet(tweetId, userId, ++time);

        if (tweetmap.containsKey(userId)) {
            newTweet.next = tweetmap.get(userId);
        }

        tweetmap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // Add user's own latest tweet
        if (tweetmap.containsKey(userId)) {
            pq.offer(tweetmap.get(userId));
        }

        // Add followees' latest tweets
        if (followermap.containsKey(userId)) {

            for (int followee : followermap.get(userId)) {

                if (tweetmap.containsKey(followee)) {
                    pq.offer(tweetmap.get(followee));
                }
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {

            Tweet curr = pq.poll();

            res.add(curr.tweetid);

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        followermap.putIfAbsent(followerId, new HashSet<>());

        followermap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!followermap.containsKey(followerId))
            return;

        followermap.get(followerId).remove(followeeId);
    }
}