import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> countTable = new HashMap<>();
        int maxFreq = 0;
        for (int left = 0, right = 0; right < nums.size(); right++) {
            countTable.merge(nums.get(right), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, countTable.get(nums.get(right)));
            while (right - left + 1 - maxFreq > k) {
                countTable.merge(nums.get(left++), -1, Integer::sum);
            }
        }
        return maxFreq;
    }
}