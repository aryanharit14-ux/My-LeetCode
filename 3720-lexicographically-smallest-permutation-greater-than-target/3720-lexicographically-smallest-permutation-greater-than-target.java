class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int n = s.length();
        int L = 0;
        int[] tempFreq = freq.clone();
        for (int i = 0; i < n; i++) {
            if (tempFreq[target.charAt(i) - 'a'] > 0) {
                tempFreq[target.charAt(i) - 'a']--;
                L++;
            } else {
                break;
            }
        }
        int start = Math.min(n - 1, L);
        int[] rem = freq.clone();
        for (int i = 0; i < start; i++) {
            rem[target.charAt(i) - 'a']--;
        }
        for (int i = start; i >= 0; i--) {
            int bestChar = -1;
            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                if (rem[c] > 0) {
                    bestChar = c;
                    break;
                }
            }
            if (bestChar != -1) {
                StringBuilder ans = new StringBuilder(target.substring(0, i));
                ans.append((char) (bestChar + 'a'));
                rem[bestChar]--;
                for (int c = 0; c < 26; c++) {
                    while (rem[c] > 0) {
                        ans.append((char) (c + 'a'));
                        rem[c]--;
                    }
                }
                return ans.toString();
            }
            if (i > 0) {
                rem[target.charAt(i - 1) - 'a']++;
            }
        }
        return "";
    }
}