import java.util.*;

class Solution5 {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1) sort by start ↑, end ↓
        Arrays.sort(intervals, (a, b) ->
                a[0] != b[0]
                        ? Integer.compare(a[0], b[0])
                        : Integer.compare(b[1], a[1])
        );

        int removed = 0;
        int maxEnd  = intervals[0][1];

        // 2) scan and count “covered” ones
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= maxEnd) {
                removed++;
            } else {
                maxEnd = intervals[i][1];
            }
        }

        return intervals.length - removed;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {{1,4},{3,6},{2,8}},
                {{1,2},{1,4},{3,4}},
                {{1,10},{2,9},{3,8},{4,7}},
                {{1,3},{4,6},{7,9}},
                {{1,5},{2,3},{4,6}}
        };

        Solution5 sol = new Solution5();   // instantiate!

        for (int i = 0; i < testCases.length; i++) {
            int[][] intervals = testCases[i];
            System.out.printf("%d.\tIntervals: %s\n",
                    i+1, Arrays.deepToString(intervals));
            int result = sol.removeCoveredIntervals(intervals);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(60));
        }
    }
}