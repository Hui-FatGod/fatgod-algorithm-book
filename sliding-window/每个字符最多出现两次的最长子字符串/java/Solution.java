class Solution {
    public int maximumLengthSubstring(String s) {
        int[] cntTable = new int[26];
        int maxLength = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            while (cntTable[s.charAt(right) - 'a'] > 1) {
                cntTable[s.charAt(left++) - 'a']--;
            }
            cntTable[s.charAt(right) - 'a']++;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}