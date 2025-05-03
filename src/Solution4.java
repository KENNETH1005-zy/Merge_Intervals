import java.util.*;

class Solution4 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int occupied = 0;
        int start = meetings[0][0];
        int end   = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < end) {
                end = Math.max(end, meetings[i][1]);
            } else {
                occupied += (end - start + 1);
                start = meetings[i][0];
                end   = meetings[i][1];
            }
        }
        occupied += (end - start + 1);
        return days - occupied;
    }

    public static void main(String[] args) {
        int[] inputDays = {12, 6, 100000, 3136, 786};
        int[][][] inputMeetings = {
                {{5, 6},   {9, 11},  {1, 3}},
                {{2, 4},   {5, 5}},
                {{1, 100000}},
                {{361, 570},{420,1225},{72,144},{987,1444}},
                {{1, 2},   {3, 4},   {5, 6}, {7, 8}, {9, 10}, {11, 12}}
        };

        // Instantiate the correct class:
        Solution4 sol = new Solution4();

        for (int i = 0; i < inputDays.length; i++) {
            System.out.println((i + 1) + ".\tdays: " + inputDays[i]);
            System.out.println("\tmeetings: " + Arrays.deepToString(inputMeetings[i]));
            System.out.println("\n\tNumber of free days: "
                    + sol.countDays(inputDays[i], inputMeetings[i]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }
    }
}