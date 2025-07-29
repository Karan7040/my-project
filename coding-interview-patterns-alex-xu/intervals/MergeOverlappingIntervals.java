import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public int[][] mergeOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        int[][] mergedIntervals = new int[intervals.length][2];
        int index = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                mergedIntervals[index] = current;
                current = intervals[i];
                index++;
            }
        }
        mergedIntervals[index++] = current;
        return Arrays.copyOf(mergedIntervals, index);
    }
}
