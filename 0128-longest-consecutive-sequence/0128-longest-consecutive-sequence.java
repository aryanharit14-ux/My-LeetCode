// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int num:nums){
//             set.add(num);
//         }
//         int longest = 0;
//         for(int num:set){
//             if(!set.contains(num-1)){
//                 int current = num;
//                 int length = 1;
//                 while(set.contains(current+1)){
//                     current++;
//                     length++;
//                 }
//                 longest = Math.max(longest,length);
//             }
//         }
//         return longest;
//     }
// }

class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        if(n == 0)
        return 0;
        int cur = 1, max = 1;
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++){
            if(arr[i] + 1 == arr[i + 1]){
                cur++;
            }else if(arr[i + 1] == arr[i]){
                continue;
            }else{
                if(cur > max){
                    max = cur;
                }
                cur = 1;
            }
        }
        if(cur > max){
            max = cur;
        }
        return max;
    }
}