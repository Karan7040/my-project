import java.util.Arrays;

public class CuttingWood {

    int cuttingWood(int[] arr, int k) {
        int left = 0, right = Arrays.stream(arr).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (cutsEnoughWood(arr, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean cutsEnoughWood(int[] arr, int mid, int k) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }
        return sum >= k;
    }
}
