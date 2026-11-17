class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        int n = profits.length;
        long[] projects = new long[n];
        for (int i = 0; i < n; i++) {
            projects[i] = ((long) capital[i] << 32)
                        | (profits[i] & 0xffffffffL);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < n &&
                   (int)(projects[index] >>> 32) <= w) {
                maxHeap.offer((int)projects[index]);
                index++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}