class Solution {
    public int minimumGroups(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String word:words){
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for(int i=0;i<word.length();i++){
                if((i&1)==0) even.append(word.charAt(i));
                else odd.append(word.charAt(i));
            }
            String key = minRotation(even.toString())+"#"+minRotation(odd.toString());
            set.add(key);
        }
        return set.size();
    }
    private String minRotation(String s){
        int n=s.length();
        if(n<=1) return s;
        String ss = s+s;
        int i=0;
        int j=1;
        int k=0;
        while(i<n && j<n && k<n){
            char a = ss.charAt(i+k);
            char b = ss.charAt(j+k);
            if(a==b){
                k++;
                continue;
            }
            if(a>b){
                i=i+k+1;
                if(i<=j) i=j+1;
            }else{
                j=j+k+1;
                if(j<=i)j=i+1;
            }
            k=0;
        }
        int start = Math.min(i,j);
        return ss.substring(start,start+n);
    }
}