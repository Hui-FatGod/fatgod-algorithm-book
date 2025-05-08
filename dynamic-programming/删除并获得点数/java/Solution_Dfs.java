import java.util.*;

class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> countTable = new TreeMap<>();
        for (int num : nums) {
            countTable.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = countTable.keySet();
        int start = 0, n = set.size();
        int[] numArr = new int[n];
        for (int num : set) {
            numArr[start++] = num;
        }
        int[] memory = new int[n];
        Arrays.fill(memory, NOT_CALC);
        return dfs(numArr.length - 1, numArr, countTable, memory);
    }

    private int dfs(int i, int[] nums, TreeMap<Integer, Integer> countTable, int[] memory) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[0] * countTable.get(nums[0]);
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        int points = nums[i] * countTable.get(nums[i]);
        return memory[i] = nums[i] - nums[i - 1] > 1 ? points + dfs(i - 1, nums, countTable, memory)
                : Math.max(points + dfs(i - 2, nums, countTable, memory), dfs(i - 1, nums, countTable, memory));
    }
}