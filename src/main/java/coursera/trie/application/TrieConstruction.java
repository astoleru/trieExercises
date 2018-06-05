package coursera.trie.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import coursera.trie.model2.Trie;

public class TrieConstruction {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int patternsNumber = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < patternsNumber; i++) {
			trie.addPattern(br.readLine());
		}
		trie.printNLR();
	}

}
