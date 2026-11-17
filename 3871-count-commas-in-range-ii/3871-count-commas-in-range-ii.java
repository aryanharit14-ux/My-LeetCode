class Solution {
    public long countCommas(long n) {
        long ans = 0;
        for (long p = 1000; p <= n; ) {
            long right = Math.min(n, p * 1000 - 1);
            long count = right - p + 1;
            long commas = 0;
            long x = p;
            while (x >= 1000) {
                x /= 1000;
                commas++;
            }
            ans += count * commas;
            if (p > n / 1000) {
                break;
            }
            p *= 1000;
        }
        return ans;
    }
}
