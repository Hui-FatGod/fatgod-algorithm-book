import java.util.Arrays;

class Solution {
    private final static int NOT_CALC = -1;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(sequenceRob(nums, 0, n - 2), sequenceRob(nums, 1, n - 1));
    }

    private int sequenceRob(int[] nums, int start, int end) {
        int[] memory = new int[end + 1];
        Arrays.fill(memory, NOT_CALC);
        return dfs(end, nums, start, memory);
    }

    private int dfs(int i, int[] nums, int start, int[] memory) {
        if (i == start) {
            return nums[start];
        }
        if (i == start + 1) {
            return Math.max(nums[start], nums[start + 1]);
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = Math.max(nums[i] + dfs(i - 2, nums, start, memory), dfs(i - 1, nums, start, memory));
    }
}