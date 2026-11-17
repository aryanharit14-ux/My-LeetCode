class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int ans = Integer.MAX_VALUE;
        for(int shift=0;shift<n;shift++){
            int changes = shift;
            for(int i=0;i<n/2;i++){
                int left=s.charAt((i+shift)%n)-'a';
                int right = s.charAt((n-1-i+shift)%n)-'a';
                int diff = Math.abs(left-right);
                changes+= Math.min(diff,26-diff);
            }
            ans = Math.min(changes,ans);
        }
        return ans;
    }
}