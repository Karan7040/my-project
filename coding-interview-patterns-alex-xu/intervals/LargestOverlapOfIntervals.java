import java.util.ArrayList;
import java.util.List;

public class LargestOverlapOfIntervals {
    public int largestOverlapOfIntervals(int[][] intervals) {
        List<int[]> events = new ArrayList<>();


        //  [), ()
        for (int i = 0; i < intervals.length; i++) {
            events.add(new int[]{intervals[i][0], 1});
            events.add(new int[]{intervals[i][1], -1});
        }

        events.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));

        int active = 0, max = 0;
        for (int[] event : events) {
            active = active + event[1];
            max = Math.max(max, active);
        }

        return max;
    }
}
