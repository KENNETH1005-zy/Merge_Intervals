import java.util.*;

class Solution2 {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int n = existingIntervals.length;
        int i = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        List <int[]> outputList = new ArrayList<>();
        while (i < n && existingIntervals[i][0] < newStart) {
            outputList.add(existingIntervals[i]);
            i += 1;
        }
        if (outputList.size() == 0 || outputList.get(outputList.size() - 1)[1] < newStart) {
            outputList.add(newInterval);
        } else {
            outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], newEnd);
        }
        while (i < n) {
            int [] ei = existingIntervals[i];
            int eiEnd = ei[1];
            int eiStart = ei[0];
            if ( outputList.get(outputList.size() - 1)[1] < eiStart) {
                outputList.add(ei);
            } else {
                outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], eiEnd);
            }
            i += 1;
        }
        return outputList.toArray(new int[][]{});
    }
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}