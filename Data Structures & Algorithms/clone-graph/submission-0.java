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
    HashMap<Integer, Node> seen = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return copy(node);
    }

    private Node copy(Node current) {
        if (current == null) {
            return null;
        }

        if (seen.containsKey(current.val)) {
            return seen.get(current.val);
        }

        var node = new Node(current.val);
        seen.put(node.val, node);

        for (var n: current.neighbors) {
            node.neighbors.add(copy(n));
        }

        return node;
    }
}