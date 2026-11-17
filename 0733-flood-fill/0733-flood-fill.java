class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];
        if (oc == color) {
            return image;
        }
        dfs(image, sr, sc, oc, color);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int oc, int color) {
        if (r < 0 || c < 0 ||
            r >= image.length || c >= image[0].length ||
            image[r][c] != oc) {
            return;
        }
        image[r][c] = color;
        dfs(image, r + 1, c, oc, color);
        dfs(image, r - 1, c, oc, color);
        dfs(image, r, c + 1, oc, color);
        dfs(image, r, c - 1, oc, color);
    }
}