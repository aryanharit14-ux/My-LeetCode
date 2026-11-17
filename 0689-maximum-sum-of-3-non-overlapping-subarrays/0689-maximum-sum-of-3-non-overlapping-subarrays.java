class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[n - k + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) {
                window[i - k + 1] = sum;
            }
        }
        int m = window.length;
        int[] left = new int[m];
        int best = 0;
        for (int i = 0; i < m; i++) {
            if (window[i] > window[best]) {
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[m];
        best = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (window[i] >= window[best]) {
                best = i;
            }
            right[i] = best;
        }
        int[] ans = new int[3];
        int max = 0;
        for (int mid = k; mid < m - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = window[l] + window[mid] + window[r];
            if (total > max) {
                max = total;
                ans[0] = l;
                ans[1] = mid;
                ans[2] = r;
            }
        }
        return ans;
    }
}