class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for(int i=0;i<nums.length;i++){
            heap.offer(nums[i]);
        }
        this.k = k;
    }

    public int add(int val) {
        heap.offer(val);
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            stack.addFirst(heap.poll());
        }

        int out = stack.peek();
        while(!stack.isEmpty()){
            heap.offer(stack.pop());
        }
        return out;
    }
}
