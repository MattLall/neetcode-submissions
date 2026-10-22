class MedianFinder {
PriorityQueue<Integer> minHeap;
PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->b-a);
        maxHeap = new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        if(minHeap.size()-maxHeap.size()>1 || !maxHeap.isEmpty() && minHeap.peek()>maxHeap.peek()){
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double) (maxHeap.peek()+minHeap.peek())/2;
        }else if(minHeap.size()>maxHeap.size()){
            return (double) minHeap.peek();
        }
        return (double) maxHeap.peek();
    }
}
