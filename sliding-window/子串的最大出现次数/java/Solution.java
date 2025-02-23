import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int k = minSize, length = s.length();
        if (k > length) {
            return 0;
        }
        Map<Character, Integer> letterMap = new HashMap<>();
        Map<String, Integer> subStrMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            letterMap.put(s.charAt(i), letterMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int maxFreq = letterMap.size() <= maxLetters ? 1 : 0;
        subStrMap.put(s.substring(0, k), maxFreq);
        for (int i = k; i < length; i++) {
            letterMap.put(s.charAt(i), letterMap.getOrDefault(s.charAt(i), 0) + 1);
            int cnt = letterMap.get(s.charAt(i - k));
            if (cnt <= 1) {
                letterMap.remove(s.charAt(i - k));
            } else {
                letterMap.put(s.charAt(i - k), cnt - 1);
            }
            if (letterMap.size() > maxLetters) {
                continue;
            }
            String subStr = s.substring(i - k + 1, i + 1);
            int subStrCnt = subStrMap.getOrDefault(subStr, 0) + 1;
            subStrMap.put(subStr, subStrCnt);
            maxFreq = Math.max(maxFreq, subStrCnt);
        }
        return maxFreq;
    }
}