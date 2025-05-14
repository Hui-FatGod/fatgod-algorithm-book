import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution_StateCompressionDp {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countTable = new HashMap<>();
        for (int num : nums) {
            countTable.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = countTable.keySet();
        int n = set.size(), start = 0;
        int[] newNums = new int[n];
        for (Integer num : set) {
            newNums[start++] = num;
        }
        Arrays.sort(newNums);
        if (n == 1) {
            return newNums[0] * countTable.get(newNums[0]);
        }
        int prev = 0, current = newNums[0] * countTable.get(newNums[0]);
        for (int i = 1; i < n; i++) {
            int points = newNums[i] * countTable.get(newNums[i]);
            int next = newNums[i] - newNums[i - 1] > 1 ? points + current
                    : Math.max(points + prev, current);
            prev = current;
            current = next;
        }
        return current;
    }
}