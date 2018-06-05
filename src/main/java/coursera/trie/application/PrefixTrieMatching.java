package coursera.trie.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import coursera.trie.model2.Trie;

/**
 * 
 * @author astoicovici
 *
 */
public class PrefixTrieMatching {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		int patternsNumber = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		int minPatternLength = Integer.MAX_VALUE;
		for (int i = 0; i < patternsNumber; i++) {
			String pattern = br.readLine();
			if (pattern.length() < minPatternLength) {
				minPatternLength = pattern.length();
			}
			trie.addPattern(pattern);
		}
		for (int i = 0; i < text.length() - minPatternLength + 1; i++) {
			String substring = text.substring(i);
			if (trie.isPartOf(substring)) {
				System.out.print(i + " ");
			}
		}

	}

}
