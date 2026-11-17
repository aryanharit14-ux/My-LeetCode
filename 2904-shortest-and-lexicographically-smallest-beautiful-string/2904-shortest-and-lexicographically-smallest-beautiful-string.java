class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        int bestStart = -1;
        int bestLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }
            while (ones == k) {
                int len = right - left + 1;
                if (len < bestLen) {
                    bestLen = len;
                    bestStart = left;
                }
                else if(len == bestLen){
                    for(int i=0;i<len;i++){
                        char current = s.charAt(left+i);
                        char best = s.charAt(bestStart+i);
                        if(current<best){
                            bestStart = left;
                            break;
                        }
                        if(current> best){
                            break;
                        }
                    }
                }
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }
        if (bestStart == -1) {
            return "";
        }
        return s.substring(bestStart, bestStart + bestLen);
    }
}