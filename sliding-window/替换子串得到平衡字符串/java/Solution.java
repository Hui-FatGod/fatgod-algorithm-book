class Solution {
    public int balancedString(String s) {
        char[] chars = s.toCharArray();
        int[] countTable = new int['W' - 'E' + 1];
        for (char c : chars) {
            countTable[c - 'E']++;
        }
        int length = s.length(), m = length / 4;
        if (countTable['Q' - 'E'] == m && countTable['W' - 'E'] == m
                && countTable[0] == m && countTable['R' - 'E'] == m) {
            return 0;
        }
        int minLength = length + 1;
        for (int left = 0, right = 0; right < length; right++) {
            countTable[chars[right] - 'E']--;
            while (countTable['Q' - 'E'] <= m && countTable['W' - 'E'] <= m
                    && countTable[0] <= m && countTable['R' - 'E'] <= m) {
                minLength = Math.min(minLength, right - left + 1);
                countTable[chars[left++] - 'E']++;
            }
        }
        return minLength;
    }
}