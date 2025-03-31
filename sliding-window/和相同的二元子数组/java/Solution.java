class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int gtSum = 0, geSum = 0;
        int gtSubs = 0, geSubs = 0;
        for (int gtLeft = 0, geLeft = 0, right = 0; right < n; right++) {
            gtSum += nums[right];
            while (gtSum > goal) {
                gtSubs += n - right;
                gtSum -= nums[gtLeft++];
            }
            geSum += nums[right];
            while (geSum >= goal && geLeft <= right) {
                geSubs += n - right;
                geSum -= nums[geLeft++];
            }
        }
        return geSubs - gtSubs;
    }
}