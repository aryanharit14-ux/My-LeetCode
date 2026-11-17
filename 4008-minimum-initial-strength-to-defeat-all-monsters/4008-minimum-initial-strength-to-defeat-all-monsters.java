class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n+1];
        for(int[] boost:boosts){
            int left = boost[0];
            int right = boost[1];
            int bonusValue = boost[2];
            diff[left]+= bonusValue;
            if(right+1<n) diff[right+1]-= bonusValue;
        }
        long[] bonus = new long[n];
        long currentBonus = 0;
        for(int i=0;i<n;i++){
            currentBonus += diff[i];
            bonus[i] = currentBonus;
        }
        long low = 0;
        long high = 0;
        for(int strength:monsters){
            high+=strength;
        }
        while(low<high){
            long mid = low+(high-low)/2;
            if(canDefeat(mid,monsters,bonus)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean canDefeat(long initialStrength,int[] monsters,long[]bonus){
        long currentStrength = initialStrength;
        for(int i=0;i<monsters.length;i++){
            if(currentStrength+bonus[i]<monsters[i]){
                return false;
            }
            currentStrength-=monsters[i];
            if(currentStrength <0){
                currentStrength = 0;
            }
        }
        return true;
    }
}