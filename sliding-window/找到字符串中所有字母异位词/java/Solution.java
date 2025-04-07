import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (p.length() > s.length()) {
            return anagrams;
        }
        int[] countTable = new int[26];
        for (char c : p.toCharArray()) {
            countTable[c - 'a']++;
        }
        char[] chars = s.toCharArray();
        int k = p.length(), letters = 0;
        for (int i = 0; i < k; i++) {
            letters += --countTable[chars[i] - 'a'] >= 0 ? 1 : 0;
        }
        if (letters == k) {
            anagrams.add(0);
        }
        for (int i = k; i < chars.length; i++) {
            letters += (--countTable[chars[i] - 'a'] >= 0 ? 1 : 0) - (++countTable[chars[i - k] - 'a'] >= 1 ? 1 : 0);
            if (letters == k) {
                anagrams.add(i - k + 1);
            }
        }
        return anagrams;
    }
}