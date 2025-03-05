class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = -x, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0) {
            return n;
        }
        if (sum < 0) {
            return -1;
        }
        int maxLength = -1;
        for (int left = 0, right = 0; right < n; right++) {
            sum -= nums[right];
            while (sum < 0) {
                sum += nums[left++];
            }
            if (sum == 0) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength < 0 ? -1 : n - maxLength;
    }
}