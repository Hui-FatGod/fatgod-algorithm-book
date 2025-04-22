import java.util.Arrays;

class Solution_Dfs {
    private final static int NOT_CALC = -1, MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int goodStrCount = 0;
        int[] memory = new int[high + 1];
        Arrays.fill(memory, NOT_CALC);
        for (int i = low; i < high + 1; i++) {
            goodStrCount = (goodStrCount + dfs(i, zero, one, memory)) % MOD;
        }
        return goodStrCount;
    }

    public int dfs(int i, int zero, int one, int[] memory) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = (dfs(i - zero, zero, one, memory) + dfs(i - one, zero, one, memory)) % MOD;
    }
}