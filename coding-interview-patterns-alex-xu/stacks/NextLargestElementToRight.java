import java.util.Stack;

public class NextLargestElementToRight {
    public int[] nextLargestElementToTheRight(int[] arr) {
        int[] result = new int[arr.length];
//  [4, 5, 2, 10]
        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i] && arr[j] > max) {
                    max = arr[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public int[] nextLargestElementToTheRightOptimized(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
