public class SumBetweenRange {
    private int[] prefixSums;

    public SumBetweenRange(int[] arr) {

        prefixSums = new int[arr.length];
        prefixSums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + arr[i];
        }
    }


    public int sumBetweenRange(int start, int end) {
        if (start < 0 || end >= prefixSums.length || end < start) {
            throw new IllegalArgumentException("Invalid Range");
        }

        if (start == 0) {
            return prefixSums[end];
        }
        return prefixSums[end] - prefixSums[start - 1];
    }


}
