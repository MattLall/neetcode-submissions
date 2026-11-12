class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = null;
        for (int[] i : intervals) {
            if (cur == null) {
                cur = i;
                continue;
            }
            if (cur[1] < i[0]) {
                list.add(cur);
                cur = i;
            } else {
                cur[0] = Math.min(cur[0], i[0]);
                cur[1] = Math.max(cur[1], i[1]);
            }
        }
        if (cur != null) {
            list.add(cur);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
