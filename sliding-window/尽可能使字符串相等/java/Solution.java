class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] costs = new int[length];
        int totalCost = 0, maxLength = 0;
        for (int right = 0, left = 0; right < length; right++) {
            int cost = costs[right] = Math.abs(s.charAt(right) - t.charAt(right));
            while (maxCost - totalCost < cost) {
                totalCost -= costs[left++];
            }
            totalCost += cost;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}