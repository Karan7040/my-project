public class HappyNumber {
    public boolean happyNumber(int n) {
        int slow = n, fast = n;
        while (true) {
            slow = findHappyNumber(slow);
            fast = findHappyNumber(findHappyNumber(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }
        }
    }

    private int findHappyNumber(int n) {
        int sum = 0;
        while (n != 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }
        return sum;
    }
}
