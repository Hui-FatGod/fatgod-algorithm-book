class Solution {
    public int numberOfSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] countTable = new int[26];
        int subs = 0;
        for (int left = 0, right = 0; right < length; right++) {
            countTable[chars[right] - 'a']++;
            while (countTable[chars[right] - 'a'] >= k) {
                subs += length - right;
                countTable[chars[left++] - 'a']--;
            }
        }
        return subs;
    }
}