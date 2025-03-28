class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int remainder = target % total, n = nums.length;
        int minLength = n + 1, sum = 0;
        for (int left = 0, right = 0; right < n * 2; right++) {
            sum += nums[right % n];
            while (sum >= remainder) {
                if (sum == remainder) {
                    minLength = Math.min(minLength, right - left + 1);
                }
                sum -= nums[left++ % n];
            }
        }
        return minLength > n ? -1 : minLength + target / total * n;
    }
}