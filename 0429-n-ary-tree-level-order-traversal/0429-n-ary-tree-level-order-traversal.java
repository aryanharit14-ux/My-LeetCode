/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>res =new ArrayList<>();
        if(root==null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> l=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node c=queue.poll();
                l.add(c.val);
                for(Node j:c.children){
                    queue.add(j);
                }
            }
            res.add(l);
        }
        return res;
    }
}