import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Map<Integer, Integer> countTable = new HashMap<>();
        int completeSubs = 0;
        for (int left = 0, right = 0; right < n; right++) {
            countTable.merge(nums[right], 1, Integer::sum);
            while (countTable.size() == set.size()) {
                completeSubs += n - right;
                countTable.merge(nums[left++], -1, (oldValue, newValue) -> oldValue == 1 ?
                        null : oldValue + newValue);
            }
        }
        return completeSubs;
    }
}