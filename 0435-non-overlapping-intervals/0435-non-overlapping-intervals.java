import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int overlapp = 0;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int start = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < start) {
                overlapp++;
                start = Math.min(start, intervals[i][1]);
            } else {
                start = intervals[i][1];
            }
        }

        return overlapp;
    }
}