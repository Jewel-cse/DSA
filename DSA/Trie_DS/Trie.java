package DSA.Trie_DS;

/**
 * Trie
 */
public class Trie {
    //initialized trie
    private static Node root;

    Trie() {
        root = new Node();
    }
    
    //insert method
    
    //apple
    private  void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containSKey(word.charAt(i)))
                node.put(word.charAt(i), new Node());
            node = node.getNode(word.charAt(i)); //move newly created node
        }
        //add true of last
        node.setEnd();
    }
    

    //string exits ?
    private  boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containSKey(word.charAt(i)))
                return false;
            node = node.getNode(word.charAt(i));
        }
        return node.flag;
    }

    //prefix exits ?
    //string exits ?
    private  boolean startsWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containSKey(word.charAt(i)))
                return false;
            node = node.getNode(word.charAt(i));
        }
        return true;
    }

    //@@@@@@@@@@@@@@@@ Main driver code @@@@@@@@@@@@@@@@@@
    public static void main(String[] args) {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie trie=new Trie();
        for (int i = 0; i < n; i++) {
            switch (type[i]) {
                case 1:
                    trie.insert(value[i]);
                    break;
                case 2:
                    System.out.println(trie.search(value[i]));
                    break;
                case 3:
                    System.out.println(trie.startsWith(value[i]));
                    break;
                default:
                    break;
            }
            
        }
    }
}