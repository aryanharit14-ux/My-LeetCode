class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = -1;
        for (int x : nums1) {
            if (x % 2 == 1) {
                if (minOdd == -1 || x < minOdd) {
                    minOdd = x;
                }
            }
        }
        if (minOdd == -1) {
            return true;
        }
        for (int x : nums1) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }
        return true;
    }
}
