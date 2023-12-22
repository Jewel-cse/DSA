package DSA.Trie_DS;

public class Node {
    Node[] links = new Node[26];
    boolean flag;

    Node() {
        
    }

    public boolean containSKey(char ch) {
        return links[ch - 'a']  != null;
    }

    public void put(char ch, Node node) {
        links[ch-'a'] = node;
    }

    public Node getNode(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }
}
