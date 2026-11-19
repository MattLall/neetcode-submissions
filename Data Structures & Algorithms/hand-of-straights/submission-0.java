class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
                if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int h : hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        PriorityQueue<Integer> minH = new PriorityQueue<>(freq.keySet());

        while(!minH.isEmpty()){
            int first = minH.peek();
            for(int i=first;i<first+groupSize;i++){
                if(!freq.containsKey(i)){
                    return false;
                }
                freq.put(i,freq.get(i)-1);
                if(freq.get(i)==0){
                    if(i!=minH.peek())return false;
                    minH.poll();
                }
            }
        }
        return true;
    }
}
