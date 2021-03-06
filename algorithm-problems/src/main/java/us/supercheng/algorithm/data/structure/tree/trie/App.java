package us.supercheng.algorithm.data.structure.tree.trie;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("abc");

        PrintHelper.echoLn("curr size: " + trie.getTrieSize());
        PrintHelper.echoLn("Contains: " + trie.contains("cba"));

        PrintHelper.echoLn("Contains: " + trie.contains("abc"));
        PrintHelper.echoLn("curr size: " + trie.getTrieSize());

        trie.addWord("Moka");
        trie.addWord("Cheng");
        trie.addWord("Pasta");
        PrintHelper.echoLn("Contains: " + trie.contains("Moka"));
        PrintHelper.echoLn("Contains: " + trie.contains("Cheng"));
        PrintHelper.echoLn("Contains: " + trie.contains("Pasta"));

        PrintHelper.echoLn("Size: " + trie.getTrieSize());
    }
}