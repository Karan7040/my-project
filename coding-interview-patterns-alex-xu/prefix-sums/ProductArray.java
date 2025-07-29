public class ProductArray {
    public int[] productArray(int[] arr) {
        int product = 1;
        int[] result = new int[arr.length];
        for (int num : arr) {
            product *= num;
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = product / arr[i];
        }
        return result;
    }

    public int[] productArrayOptimize(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public int[] productArrayMoreOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= arr[i];
        }

        return result;
    }


}
