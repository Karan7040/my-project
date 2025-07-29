import java.util.HashMap;
import java.util.Map;

public class FindSubArraysSumToK {
    public int KSumSubArraysBruteforce(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (arr[i] + arr[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    // 1, 2, -1 , 1, 2
    public static int KSumSubArrays(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            count = count + map.getOrDefault(sum - target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        assert KSumSubArrays(new int[]{1, 2, -1, 1, 2}, 3) == 3;
    }
}
