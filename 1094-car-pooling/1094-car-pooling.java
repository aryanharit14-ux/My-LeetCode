class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] road = new int[1001];

        for(int [] trip : trips){
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            for(int i=from;i<to;i++){
                road[i]+=passengers;

                if(road[i]>capacity)
                    return false;
            }
        }
        return true;
    }
}