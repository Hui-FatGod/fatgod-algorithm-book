import java.util.List;

class Solution_StateCompressionDp {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] current = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                current[j] = Math.min(current[j], current[j + 1]) + triangle.get(i).get(j);
            }
        }
        return current[0];
    }
}