class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int k = jewels.length();
        int s = stones.length();
        int count = 0;
        for(int i=0;i<k;i++){
            char ch = jewels.charAt(i);

            for(int j=0;j<s;j++){
                if(ch==stones.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}