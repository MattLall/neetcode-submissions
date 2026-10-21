class Twitter {
    Map<Integer, PriorityQueue<Tweet>> tweets;
    Map<Integer, Set<Integer>> follows;
    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new PriorityQueue<>((a, b) -> b.time.compareTo(a.time)))
            .add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = follows.getOrDefault(userId, new HashSet<>());
        PriorityQueue<Tweet> newsFeed = new PriorityQueue<>((a, b) -> b.time.compareTo(a.time));
Iterator fol = following.iterator();
        while(fol.hasNext()){
            PriorityQueue<Tweet> temp = new PriorityQueue<>(tweets.get(fol.next()));
            for (int x = 0; x < 10; x++) {
                if (temp.isEmpty()) {
                    break;
                }
                newsFeed.offer(temp.poll());
            }
        }
        PriorityQueue<Tweet> userPosts = new PriorityQueue<>(tweets.getOrDefault(userId,new PriorityQueue<>()));
        for (int y = 0; y < 10; y++) {
            if (userPosts.isEmpty()) {
                break;
            }
            newsFeed.offer(userPosts.poll());
        }

        List<Integer> out = new ArrayList<>();
        while(out.size()<10 && !newsFeed.isEmpty()){
            out.add(newsFeed.poll().tweetId);
        }

        return out;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !follows.containsKey(followerId)) {
            return;
        }
        Set<Integer> temp = follows.get(followerId);
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
