import java.util.Arrays;

class Solution_Dfs {
    private final static int NOT_CALC = -1, MOD = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, NOT_CALC);
        long count = dfs(n, memory);
        return (int) (count * count % MOD);
    }

    private int dfs(int i, int[] memory) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = (dfs(i - 1, memory) + dfs(i - 2, memory)) % MOD;
    }
}