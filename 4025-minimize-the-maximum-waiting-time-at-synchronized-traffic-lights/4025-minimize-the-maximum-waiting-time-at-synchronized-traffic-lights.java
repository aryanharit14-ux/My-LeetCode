class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxLight = 0;
        for(int light:lights){
            maxLight = Math.max(maxLight,light);
        }
        int ans = 0;
        for(int time : arrivalTime){
            int r = time%period;
            int wait;
            if(r<maxLight){
                wait=0;
            }else{
                wait = period-r;
            }
            ans = Math.max(ans,wait);
        }
        return ans;
    }
}