class Solution {
    public int minFlips(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int notEqualCount = 0;
        for (int i = 0; i < length; i++) {
            notEqualCount += (chars[i] ^ i) & 1;
        }
        int minFlips = Math.min(notEqualCount, length - notEqualCount);
        for (int i = length; i < 2 * length - 1; i++) {
            notEqualCount += ((chars[i % length] ^ i) & 1) - ((chars[(i - length) % length] ^ (i - length)) & 1);
            minFlips = Math.min(minFlips, Math.min(notEqualCount, length - notEqualCount));
        }
        return minFlips;
    }
}