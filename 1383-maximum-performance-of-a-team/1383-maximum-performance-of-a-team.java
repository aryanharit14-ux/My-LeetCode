class Solution {
    public int maxPerformance(int n, int[] s, int[] e, int k) {
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = e[i];
            a[i][1] = s[i];
        }
        Arrays.sort(a, (x, y) -> y[0] - x[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0, ans = 0;
        for (int[] x : a) {
            q.add(x[1]);
            sum += x[1];
            if (q.size() > k)
                sum -= q.poll();
            ans = Math.max(ans, sum * x[0]);
        }
        return (int)(ans % 1000000007);
    }
}