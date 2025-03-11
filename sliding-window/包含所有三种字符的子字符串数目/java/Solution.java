class Solution {
    public int numberOfSubstrings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] countTable = new int[3];
        int subs = 0;
        for (int left = 0, right = 0; right < length; right++) {
            countTable[chars[right] - 'a']++;
            while (countTable[0] > 0 && countTable[1] > 0 && countTable[2] > 0) {
                subs += length - right;
                countTable[chars[left++] - 'a']--;
            }
        }
        return subs;
    }
}