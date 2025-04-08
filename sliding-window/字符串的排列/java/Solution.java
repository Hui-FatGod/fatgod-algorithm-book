class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] countTable = new int[26];
        for (char c : s1.toCharArray()) {
            countTable[c - 'a']++;
        }
        char[] chars = s2.toCharArray();
        int k = s1.length(), letters = 0;
        for (int i = 0; i < k; i++) {
            letters += --countTable[chars[i] - 'a'] >= 0 ? 1 : 0;
        }
        if (letters == k) {
            return true;
        }
        for (int i = k; i < chars.length; i++) {
            letters += (--countTable[chars[i] - 'a'] >= 0 ? 1 : 0) - (++countTable[chars[i - k] - 'a'] >= 1 ? 1 : 0);
            if (letters == k) {
                return true;
            }
        }
        return false;
    }
}