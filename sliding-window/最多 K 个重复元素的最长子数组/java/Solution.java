import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.merge(nums[left++], -1, Integer::sum);
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}