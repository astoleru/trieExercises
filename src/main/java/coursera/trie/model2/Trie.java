package coursera.trie.model2;

public class Trie {
	
	private TrieNode root;
	private int currentIndex = 0;
	
	public Trie() {
		root = new TrieNode(0, null);
		root.setTree(this);
	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public void incrementCurrentIndex() {
		currentIndex++;
	}

	public void printNLR() {
		NLR(root);
	}
	
	public void addPattern(final String pattern) {
		root.addPattern(pattern);
	}
	
	private void NLR(TrieNode node) {
		for (TrieNode child : node.getChildren()) {
			System.out.println(node.getDepth() + "->" + child.getDepth() + ":" + child.getLetter());
			NLR(child);
		}
	}
	
	public boolean isPartOf(String pattern) {
		if (pattern != null) {
			for (TrieNode child : root.getChildren()) {
				if (child.isPartOf(pattern)) {
					return true;
				}
			}
		}
		return false;
	}

}
