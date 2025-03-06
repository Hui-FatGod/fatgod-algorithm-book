class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 1, same = 0;
        for (int left = 0, right = 1; right < chars.length; right++) {
            same += chars[right] == chars[right - 1] ? 1 : 0;
            while (same > 1) {
                same -= chars[left] == chars[left++ + 1] ? 1 : 0;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}