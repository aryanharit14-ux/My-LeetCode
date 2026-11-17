class Solution {
    public int uniqueMorseRepresentations(String[] words) {
         String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....",
            "..",".---","-.-",".-..","--","-.","---",".--.",
            "--.-",".-.","...","-","..-","...-",".--","-..-",
            "-.--","--.."
        };
        HashSet<String> ans = new HashSet<>();
        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                sb.append(morse[c-'a']);
            }
            ans.add(sb.toString());
        }
        return ans.size();
    }
}