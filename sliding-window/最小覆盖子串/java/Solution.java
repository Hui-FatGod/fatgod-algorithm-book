class Solution {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] countTable = new int['z' - 'A' + 1];
        int eligibleChars = 0;
        for (char c : t.toCharArray()) {
            eligibleChars += ++countTable[c - 'A'] == 1 ? 1 : 0;
        }
        int minSubLeft = 0, minSubRight = length;
        for (int left = 0, right = 0; right < length; right++) {
            eligibleChars -= --countTable[chars[right] - 'A'] == 0 ? 1 : 0;
            while (eligibleChars == 0) {
                if (right - left < minSubRight - minSubLeft) {
                    minSubLeft = left;
                    minSubRight = right;
                }
                eligibleChars += ++countTable[chars[left++] - 'A'] > 0 ? 1 : 0;
            }
        }
        return minSubRight >= length ? "" : s.substring(minSubLeft, minSubRight + 1);
    }
}