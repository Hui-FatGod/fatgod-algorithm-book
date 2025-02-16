import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        ans[index++] = map.size();
        for (int i = k; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int cnt = map.get(nums[i - k]);
            if (cnt <= 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], cnt - 1);
            }
            ans[index++] = map.size();
        }
        return ans;
    }
}