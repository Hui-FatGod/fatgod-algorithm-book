import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countTable = new HashMap<>();
        long goodSubs = 0, pairs = 0;
        for (int left = 0, right = 0; right < n; right++) {
            pairs += countTable.merge(nums[right], 1, Integer::sum) - 1;
            while (pairs >= k) {
                goodSubs += n - right;
                pairs -= countTable.merge(nums[left++], -1, Integer::sum);
            }
        }
        return goodSubs;
    }
}