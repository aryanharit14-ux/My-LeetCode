class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0') pos.add(i);
        }
        int zero = pos.size();
        boolean[] ans = new boolean[strs.length];
        for(int x=0;x<strs.length;x++){
            char[] t = strs[x].toCharArray();
            int cnt0=0;
            ArrayList<Integer> q = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(t[i]=='0')cnt0++;
                else if(t[i]=='?')q.add(i);
            }

        if(cnt0>zero || cnt0+q.size()<zero){
            ans[x]=false;
            continue;
        }
        int need = zero-cnt0;
        for(int i=0;i<need;i++){
            t[q.get(i)]='0';
        }
        for(int i=need;i<q.size();i++){
            t[q.get(i)]='1';
        }
        ArrayList<Integer> cur = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(t[i]=='0'){
                cur.add(i);
            }
        }
        boolean ok = true;
        for(int i=0;i<zero;i++){
            if(cur.get(i)>pos.get(i)){
                ok = false;
                break;
            }
        }
        ans[x]=ok;
        }
        return ans;
    }
}