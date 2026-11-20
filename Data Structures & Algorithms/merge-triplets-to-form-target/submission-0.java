class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> viable = new ArrayList<>();
        for (int[] t : triplets) {
            if (Arrays.equals(t, target)) {
                return true;
            }
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            viable.add(t);
        }

        int[] merge = new int[3];
        for (int[] v : viable) {
            merge[0] = Math.max(merge[0], v[0]);
            merge[1] = Math.max(merge[1], v[1]);
            merge[2] = Math.max(merge[2], v[2]);
        }

        return Arrays.equals(merge, target);
    }
}
