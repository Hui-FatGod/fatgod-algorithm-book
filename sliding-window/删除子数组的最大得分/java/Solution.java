import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, maxSum = sum;
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left++]);
            }
            sum += nums[right];
            set.add(nums[right]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}