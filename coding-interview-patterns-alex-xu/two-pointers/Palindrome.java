public class Palindrome {
    boolean validPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int left = 0, right = str.length() - 1;
        while (left < right) {
            while (left < right && isNotAlpha(str.charAt(left))) {
                left++;
            }
            while (left < right && isNotAlpha(str.charAt(right))) {
                right--;
            }
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isNotAlpha(int letter) {
        return true;
    }
}
