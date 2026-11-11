class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == newInterval[0] && intervals[i][1] == newInterval[1]) {
                list.add(newInterval);
                added = true;
                continue;
            }
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
                continue;
            }

            if (intervals[i][0] > newInterval[1]) {
                if (!added) {
                    added = true;
                    list.add(newInterval);
                }
                list.add(intervals[i]);

            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        if (!added) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
