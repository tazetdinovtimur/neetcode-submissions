class PrefixTree {
    public static class Node {
        HashMap<Character, Node> children = new HashMap<>();
        boolean end = false;
    }

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        var cur = root;

        for (var c: word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }

        cur.end = true;
    }

    public boolean search(String word) {
        var cur = root;

        for (var c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }

        return cur.end;
    }

    public boolean startsWith(String prefix) {
        var cur = root;

        for (var c: prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }

        return true;
    }
}
