/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node, Map<Node,Node>m)
    {
        if(node==null)
            return null;
        if(m.containsKey(node))
            return m.get(node);
        
        Node clone=new Node(node.val);
        m.put(node,clone);
        for(int i=0;i<node.neighbors.size();i++)
        {
            clone.neighbors.add(dfs(node.neighbors.get(i),m));
        }
        return clone;
    }
    public Node cloneGraph(Node node) 
    {
        Map<Node,Node>m=new HashMap<>();
        return dfs(node,m);    
    }
}