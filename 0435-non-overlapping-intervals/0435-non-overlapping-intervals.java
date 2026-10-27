import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int overlapp = 0;

            Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[1], b[1])
        );
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