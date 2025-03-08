import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxLength = 1;
        long sumGap = 0;
        for (int left = 0, right = 1; right < nums.length; right++) {
            sumGap += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (sumGap > k) {
                sumGap -= nums[right] - nums[left++];
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}