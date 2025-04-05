class Solution {
    public long countOfSubstrings(String word, int k) {
        return getSubs(word, k) - getSubs(word, k + 1);
    }

    private long getSubs(String word, int k) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        int[] countTable = new int[26];
        int vowelTypes = 0, consonants = 0;
        long subs = 0;
        for (int left = 0, right = 0; right < length; right++) {
            if (isVowel(chars[right])) {
                vowelTypes += ++countTable[chars[right] - 'a'] == 1 ? 1 : 0;
            } else {
                consonants++;
            }
            while (vowelTypes == 5 && consonants >= k) {
                subs += length - right;
                if (isVowel(chars[left])) {
                    vowelTypes -= --countTable[chars[left] - 'a'] == 0 ? 1 : 0;
                } else {
                    consonants--;
                }
                left++;
            }
        }
        return subs;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}