class Solution {
    public int numberOfSpecialSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] countTable = new int[26];
        int subs = 0;
        for (int left = 0, right = 0; right < chars.length; right++) {
            countTable[chars[right] - 'a']++;
            while (countTable[chars[right] - 'a'] > 1) {
                countTable[chars[left++] - 'a']--;
            }
            subs += right - left + 1;
        }
        return subs;
    }
}