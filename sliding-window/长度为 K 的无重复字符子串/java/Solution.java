class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int[] table = new int[26];
        int size = 0;
        for (int i = 0; i < k; i++) {
            if (table[s.charAt(i) - 'a']++ == 0) {
                size++;
            }
        }
        int number = size < k ? 0 : 1;
        for (int i = k; i < s.length(); i++) {
            if (table[s.charAt(i) - 'a']++ == 0) {
                size++;
            }
            if (--table[s.charAt(i - k) - 'a'] == 0) {
                size--;
            }
            number += size < k ? 0 : 1;
        }
        return number;
    }
}