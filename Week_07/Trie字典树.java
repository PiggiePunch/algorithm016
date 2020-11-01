
/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * trie.insert("apple"); 
 * trie.search("apple"); // 返回 true 
 * trie.search("app"); // 返回 false 
 * trie.startsWith("app"); // 返回 true 
 * trie.insert("app");
 * trie.search("app"); // 返回 true
 * 
 */
class Trie字典树 {
    private boolean isEnd;
    private Trie字典树[] next;

    /**
     * Initialize your data structure here.
     */
    public Trie字典树() {
        isEnd = false;
        next = new Trie字典树[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        Trie字典树 curr = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null)
                curr.next[n] = new Trie字典树();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie字典树 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie字典树 node = searchPrefix(prefix);
        return node != null;
    }

    private Trie字典树 searchPrefix(String word) {
        Trie字典树 node = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            node = node.next[words[i] - 'a'];
            if (node == null)
                return null;
        }
        return node;
    }
}
