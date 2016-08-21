package tree;

public class ImplementTrie_E208M_I442M {
	/**
	 * Time: O(l); Space: O(26n) to O(26nl)
	 */
	private TrieNode root;

	public ImplementTrie_E208M_I442M() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		root = put(root, word, 0);
	}

	private TrieNode put(TrieNode node, String s, int d) {
		if (node == null) {
			node = new TrieNode();
		}
		
		if (d == s.length()) {
			node.eow = true;
			return node;
		}
		
		int c = s.charAt(d) - 'a';
		node.next[c] = put(node.next[c], s, d + 1);
		
		return node;
	}
	
	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = get(root, word, 0);
		
		if (node == null) {
			return false;
		} else {
			return node.eow;
		}
	}

	private TrieNode get(TrieNode node, String s, int d) {
		if (node == null) {
			return null;
		}
		
		if (d == s.length()) {
			return node;
		}
		
		int c = s.charAt(d) - 'a';
		
		return get(node.next[c], s, d + 1);
	}
	
	// Returns if there is any word in the trie that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = get(root, prefix, 0);
		
		if (node == null) {
			return false;
		} else {
			return true;
		}
	}
	
	// Definition for a Trie node.
	public class TrieNode {
		boolean eow; // end of word
		TrieNode[] next;
		
		// Initialize your data structure here.
		public TrieNode() {
			eow = false;
			next = new TrieNode[26];
		}
	}
	
	public static void main(String[] args) {
		ImplementTrie_E208M_I442M trie = new ImplementTrie_E208M_I442M();
		trie.insert("somestring");
		System.out.println(trie.search("key"));	// false
		System.out.println(trie.search("somestring"));	// true
	}
}

/**
 * LeetCode #208
 * LintCode #442
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("somestring");
 * trie.search("key");
 */
 
