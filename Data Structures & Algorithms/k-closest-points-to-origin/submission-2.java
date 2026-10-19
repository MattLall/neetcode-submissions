class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new EucComp());
        for (int[] point : points) {
            heap.offer(point);
        }

        while (heap.size() > k) {
            heap.poll();
        }
        int[][] out = new int[k][2];
        for (int i = 0; i < k; i++) {
            out[i] = heap.poll();
        }

        return out;
    }

    class EucComp implements Comparator<int[]> {
        public int compare(int[] obj1, int[] obj2) {
            double d1 = distance(obj1);
            double d2 = distance(obj2);
            int out = Double.compare(d2, d1);
            return out;
        }

        private double distance(int[] obj) {
            double part1 = Math.pow((obj[0] - 0), 2);
            double part2 = Math.pow((obj[1] - 0), 2);
            double part3 = part1 + part2;
            return Math.sqrt(part3);
        }
    }
}