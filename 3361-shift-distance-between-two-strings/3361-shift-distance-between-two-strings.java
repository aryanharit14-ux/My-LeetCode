class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[][]cost = new long[26][26];
        for(int from =0;from<26;from++){
            long forward = 0;
            int curr = from;

            for(int step =0;step<26;step++){
                cost[from][curr] = forward;
                forward+=nextCost[curr];
                curr = (curr+1)%26;
            }
            long backward = 0;
            curr = from;
            for(int step = 0;step<26;step++){
                cost[from][curr] = Math.min(cost[from][curr],backward);
                backward += previousCost[curr];
                curr = (curr-1+26)%26;
            }
        }
        long ans = 0;
        for(int i=0;i<s.length();i++){
            int from = s.charAt(i) - 'a';
            int to = t.charAt(i) - 'a';
            ans+=cost[from][to];
        }
        return ans;
    }
}