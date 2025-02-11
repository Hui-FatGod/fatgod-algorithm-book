import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        long maxSum = map.size() < k ? 0 : sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            Integer cnt = map.get(nums[i - k]);
            if (cnt <= 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], cnt - 1);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxSum = Math.max(maxSum, map.size() < k ? 0 : sum);
        }
        return maxSum;
    }
}