class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int maxCount = 0;
        long subs = 0;
        for (int left = 0, right = 0; right < n; right++) {
            maxCount += nums[right] == max ? 1 : 0;
            while (maxCount >= k) {
                subs += n - right;
                maxCount -= nums[left++] == max ? 1 : 0;
            }
        }
        return subs;
    }
}