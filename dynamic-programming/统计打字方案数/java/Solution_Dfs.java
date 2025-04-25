import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_Dfs {
    private final static int NOT_CALC = -1, MOD = (int) 1e9 + 7;
    private final static int[] KEY_LETTERS = { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };

    public int countTexts(String pressedKeys) {
        char[] chars = pressedKeys.toCharArray();
        List<int[]> tuples = new ArrayList<>();
        int count = 0, maxCount = 0;
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                tuples.add(new int[] { count, KEY_LETTERS[chars[i] - '0'] });
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        int[] memory3 = new int[maxCount + 1], memory4 = new int[maxCount + 1];
        Arrays.fill(memory3, NOT_CALC);
        Arrays.fill(memory4, NOT_CALC);
        long texts = 1;
        for (int[] tuple : tuples) {
            texts = texts * dfs(tuple[0], tuple[1], tuple[1] == 3 ? memory3 : memory4) % MOD;
        }
        return (int) texts;
    }

    private int dfs(int i, int letters, int[] memory) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        int schemes = 0;
        for (int j = 1; j < letters + 1; j++) {
            schemes = (schemes + dfs(i - j, letters, memory)) % MOD;
        }
        return memory[i] = schemes;
    }
}