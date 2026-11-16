class Solution {
    public String minWindow(String s, String t) {
        int[] ans = new int[128];
        for (int i = 0; i < t.length(); i++) {
            ans[t.charAt(i)]++;
        }

        int left = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (ans[c] > 0) {
                required--;
            }
            ans[c]--;
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char ch = s.charAt(left);
                ans[ch]++;
                if (ans[ch] > 0) {
                    required++;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        String ans1 = "";
        for (int i = start; i < start + minLen; i++) {
            ans1 = ans1 + s.charAt(i);
        }
        return ans1;
    }
}