import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - k + 1]);
        }
        return minDiff;
    }
}