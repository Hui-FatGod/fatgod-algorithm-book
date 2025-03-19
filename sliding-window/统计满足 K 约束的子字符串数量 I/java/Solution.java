class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int[] countTable = new int[2];
        int subs = 0;
        for (int left = 0, right = 0; right < chars.length; right++) {
            countTable[chars[right] - '0']++;
            while (countTable[0] > k && countTable[1] > k) {
                countTable[chars[left++] - '0']--;
            }
            subs += right - left + 1;
        }
        return subs;
    }
}