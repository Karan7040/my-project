public class SubstringAnagrams {
    public int substringAnagrams(String s, String t) {
        int left = 0, right = 0;
        while (right < s.length()) {
            if (right - left + 1 == t.length()) {
                isSubString(s.substring(left, right + 1), t);
                left++;
            }
            right++;
        }
    }

    public boolean isSubString(String s, String t) {

    }
}
