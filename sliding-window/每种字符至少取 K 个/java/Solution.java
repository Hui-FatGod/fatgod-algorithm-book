class Solution {
    public int takeCharacters(String s, int k) {
        int length = s.length();
        if (length < 3 * k) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int[] countTable = new int[3];
        for (char c : chars) {
            countTable[c - 'a']++;
        }
        if (countTable[0] < k || countTable[1] < k || countTable[2] < k) {
            return -1;
        }
        int maxLength = 0;
        for (int left = 0, right = 0; right < length; right++) {
            countTable[chars[right] - 'a']--;
            while (countTable[chars[right] - 'a'] < k) {
                countTable[chars[left++] - 'a']++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return length - maxLength;
    }
}