class Solution {
    public int longestSubarray(int[] nums) {
        int lastZeroIndex = -1, maxLength = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = lastZeroIndex + 1;
                lastZeroIndex = right;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}