import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> countTable = new TreeMap<>();
        long subs = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            countTable.merge(nums[right], 1, Integer::sum);
            while (countTable.lastKey() - countTable.firstKey() > 2) {
                countTable.merge(nums[left++], -1, (oldValue, value) ->
                        oldValue == 1 ? null : oldValue + value);
            }
            subs += right - left + 1;
        }
        return subs;
    }
}