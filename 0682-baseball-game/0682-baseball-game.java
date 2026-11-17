class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> ans = new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                ans.pop();
            }
            else if(op.equals("D")){
                int last = ans.peek();
                ans.push(last*2);
            }
            else if(op.equals("+")){
                int last = ans.pop();
                int secondLast = ans.peek();
                ans.push(last);
                ans.push(last+secondLast);
            }
            else{
                ans.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!ans.isEmpty()){
            sum+= ans.pop();
        }
        return sum;
    }
}