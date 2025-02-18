import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int num = nums.get(i);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long maxSum = map.size() >= m ? sum : 0;
        for (int i = k; i < nums.size(); i++) {
            int newNum = nums.get(i), oldNum = nums.get(i - k);
            sum += newNum - oldNum;
            map.put(newNum, map.getOrDefault(newNum, 0) + 1);
            int cnt = map.get(oldNum);
            if (cnt <= 1) {
                map.remove(oldNum);
            } else {
                map.put(oldNum, cnt - 1);
            }
            maxSum = Math.max(maxSum, map.size() >= m ? sum : 0);
        }
        return maxSum;
    }
}