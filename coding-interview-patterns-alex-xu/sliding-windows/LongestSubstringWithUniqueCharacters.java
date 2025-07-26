import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {
    public int longestSubstringWithUniqueCharacters(String s) {
        int left = 0, right = 0, count = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            count = Math.max(count, set.size());
            right++;
        }
        return count;
    }

    public int longestSubstringBruteForce(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
                count = Math.max(count, j - i + 1);
            }
        }
        return count;
    }

    public int longestSubstringOpitmized(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
