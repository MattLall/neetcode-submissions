// import java.time.OffsetDateTime;
class Twitter {
    Map<Integer, Set<Integer>> map;
    PriorityQueue<Tweet> tweets;
    public Twitter() {
        map = new HashMap<>();
        tweets = new PriorityQueue<>((a, b) -> b.time.compareTo(a.time));
    }

    public void postTweet(int userId, int tweetId) {
        tweets.offer(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = map.getOrDefault(userId,new HashSet<>());
        PriorityQueue<Tweet> tempTweets = new PriorityQueue<>(tweets);
        List<Integer> out = new ArrayList<>();
        while (out.size() < 10 && !tempTweets.isEmpty()) {
            Tweet temp = tempTweets.poll();
            if (temp.userId == userId || follows.contains(temp.userId)) {
                out.add(temp.tweetId);
            }
        }

        return out;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }


        map.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !map.containsKey(followerId)) {
            return;
        }
        Set<Integer> temp = map.get(followerId);
        temp.remove(followeeId);
    }
}

class Tweet {
    int userId, tweetId;
    java.time.OffsetDateTime time;
    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
        time = java.time.OffsetDateTime.now();
    }
}
