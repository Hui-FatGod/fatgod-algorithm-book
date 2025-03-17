class Solution {
    public long validSubstringCount(String word1, String word2) {
        int word1Length = word1.length(), word2Length = word2.length();
        if (word1Length < word2Length) {
            return 0;
        }
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int[] countTable = new int[26];
        for (char c : chars2) {
            countTable[c - 'a']++;
        }
        long subs = 0;
        int letters = 0;
        for (int left = 0, right = 0; right < word1Length; right++) {
            countTable[chars1[right] - 'a']--;
            if (countTable[chars1[right] - 'a'] < 0) {
                continue;
            }
            letters++;
            while (letters == word2Length) {
                subs += word1Length - right;
                if (countTable[chars1[left] - 'a'] >= 0) {
                    letters--;
                }
                countTable[chars1[left++] - 'a']++;
            }
        }
        return subs;
    }
}