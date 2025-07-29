import java.util.ArrayList;
import java.util.List;

public class IdentifyAllOverlapIntervals {
    public List<int[]> findAllOverlapIntervals(int[][] interval1, int[][] interval2) {

        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < interval1.length && j < interval2.length) {
            int start1 = interval1[i][0], end1 = interval1[i][1];
            int start2 = interval2[j][0], end2 = interval2[j][1];


            if (start1 <= end2 && start2 <= end1) {
                int overlapStart = Math.max(start1, start2);
                int overlapEnd = Math.min(end1, end2);
                result.add(new int[]{overlapStart, overlapEnd});
            }

            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
