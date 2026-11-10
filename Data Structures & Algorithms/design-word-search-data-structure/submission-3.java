class WordDictionary {
    static class Node {
        boolean end;
        HashMap<Character, Node> children = new HashMap<>();
    }

    Node root; 

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        var cur = root;

        for (var c: word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }

        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int id, Node root) {
        var cur = root;

        for (var i = id; i < word.length(); i++) {
            var c = word.charAt(i);

            if (c == '.') {
                for (var node: cur.children.values()) {
                    if (node != null && dfs(word, i + 1, node)) {
                        return true;
                    }
                }

                return false;
            } else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }

                cur = cur.children.get(c);
            }
        }

        return cur.end;
    }
}
