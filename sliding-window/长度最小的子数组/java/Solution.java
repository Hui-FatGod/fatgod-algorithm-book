class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, minLength = n + 1;
        long sum = 0;
        for (int left = 0, right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength > n ? 0 : minLength;
    }
}