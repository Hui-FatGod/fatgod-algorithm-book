class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int[] countTable = new int[2];
        int maxLength = 0;
        for (int left = 0, right = 0; right < chars.length; right++) {
            countTable[chars[right] >> 1 & 1]++;
            while (countTable[0] > k && countTable[1] > k) {
                countTable[chars[left++] >> 1 & 1]--;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}