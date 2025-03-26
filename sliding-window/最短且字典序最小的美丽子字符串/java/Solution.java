class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length, minLength = length + 1, oneCount = 0;
        String minSub = "";
        for (int left = 0, right = 0; right < length; right++) {
            oneCount += chars[right] - '0';
            while (oneCount == k) {
                int currentLength = right - left + 1;
                String currentSub = s.substring(left, right + 1);
                oneCount -= chars[left++] - '0';
                if (currentLength > minLength) {
                    continue;
                }
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minSub = currentSub;
                    continue;
                }
                minSub = currentSub.compareTo(minSub) < 0 ? currentSub : minSub;
            }
        }
        return minSub;
    }
}