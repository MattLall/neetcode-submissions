class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            sortQueue(q, nums[r]);
                // System.out.println(r);
            if (r - l == k-1) {
                list.add(q.element());
             
                    // System.out.println("Removing " + nums[l]);
                    if(nums[l]==q.peekFirst()){
                        q.removeFirst();
                    }
                
                l++;
            }
        }

        int[] out = new int[list.size()];
        for(int i =0;i<list.size();i++){
            out[i]=list.get(i);
        }
        return out;
    }

    public Deque<Integer> sortQueue(Deque<Integer> q, int newVal) {
        // System.out.println("Adding "+newVal);
        while(!q.isEmpty() && q.getLast()<newVal){
            // System.out.println("Removing " + q.getLast() +" to add " +newVal);
            q.removeLast();
        }
        q.add(newVal);
        // System.out.println(q.toString());
        return q;
    }
}
