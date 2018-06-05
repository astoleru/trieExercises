package coursera.trie.model2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrieNode {
	
	private int depth;
	
	private Character letter;
	
	private List<TrieNode> children = new ArrayList<TrieNode>();
	
	private boolean terminal;
	
	private Trie tree;

	public TrieNode(final int depthLevel, final Character letter) {
		this.depth = depthLevel;
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Trie getTree() {
		return tree;
	}

	public void setTree(Trie tree) {
		this.tree = tree;
	}

	public TrieNode addNode(final TrieNode node) {
		if (!children.contains(node)) {
			tree.incrementCurrentIndex();
			node.setDepth(tree.getCurrentIndex());
			node.setTree(tree);
			children.add(node);
			return node;
		}
		Optional<TrieNode> result = children.parallelStream().filter((trieNode) -> node.equals(trieNode)).findFirst();
		return result.get();
	}
	
	public void addPattern(final String pattern) {
		TrieNode node = new TrieNode(depth + 1, pattern.charAt(0));
		TrieNode addedNode = addNode(node);
		if (pattern.length() > 1) {
			addedNode.addPattern(pattern.substring(1));
		} else {
			addedNode.setTerminal(true);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(TrieNode.class)) {
			TrieNode node = (TrieNode) obj;
			return letter.equals(node.getLetter());
		}
		return super.equals(obj);
	}
	
//	@Override
//	public int hashCode() {
//		return 31 * letter.hashCode() + depth;
//	}

	public List<TrieNode> getChildren() {
		return children;
	}
	
	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}

	public boolean isPartOf(final String pattern) {
		if (new Character(letter).equals(pattern.charAt(0))) {
			if (children.isEmpty() || terminal) {
				return true;
			} else if (pattern.length() > 1){
				boolean foundMatch = false;
				for (TrieNode child : children) {
					if (child.isPartOf(pattern.substring(1))) {
						foundMatch = true;
						break;
					}
				}
				return foundMatch;
			}
		}
		return false;
	}
	
}
