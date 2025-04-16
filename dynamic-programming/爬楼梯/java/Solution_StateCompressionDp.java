public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev = 1, current = 2;
        for (int i = 3; i < n + 1; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }
}