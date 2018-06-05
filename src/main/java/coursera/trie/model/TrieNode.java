package coursera.trie.model;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	
	private int depthLevel;
	
	private TrieNode incomingEdge;
	
	private List<TrieNode> outgoingEdges = new ArrayList<TrieNode>();
	
	public TrieNode(final int depth) {
		depthLevel = depth;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
