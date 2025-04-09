class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            while (left < right && !isNumberOrLetter(chars[left])) {
                left++;
            }
            while (left < right && !isNumberOrLetter(chars[right])) {
                right--;
            }
            if (left != right && Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberOrLetter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}