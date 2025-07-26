import java.util.Arrays;

public class SubstringAnagrams {


    public static int substringAnagrams(String s, String t) {
        int left = 0, right = 0, count = 0;
        int[] frequencyT = new int[26];
        int[] frequencyS = new int[26];
        for (char c : t.toCharArray()) {
            frequencyT[c - 'a']++;
        }
        while (right < s.length()) {
            frequencyS[s.charAt(right) - 'a']++;
            if (right - left + 1 == t.length()) {
                if (Arrays.equals(frequencyT, frequencyS)) {
                    count++;
                }
                frequencyS[s.charAt(left) - 'a']--;
                left++;

            }
            right++;
        }
        return count;
    }

}
