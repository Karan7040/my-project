import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacement {
    public int longestUniformSubstring(String s, int k) {
        int left = 0, right = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
            if (maxFrequency + k < right - left + 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
