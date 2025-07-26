public class LargestContainer {
    int largestContainer(int[] arr) {

        int maxVolume = 0;

        if (arr == null || arr.length == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int volume = Math.min(arr[i], arr[j]) * (j - i);
                maxVolume = Math.max(volume, maxVolume);
            }
        }
        return maxVolume;
    }

    int largestContainerOptimized(int[] arr) {
        int maxVolume = 0;

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int volume = Math.min(arr[left], arr[right]) * (right - left);
            maxVolume = Math.max(volume, maxVolume);

            if (arr[left] < arr[right]) {
                left++;
            } else if (arr[left] > arr[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxVolume;
    }
}
