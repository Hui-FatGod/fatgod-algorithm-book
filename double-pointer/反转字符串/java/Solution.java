class Solution {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
        }
    }
}