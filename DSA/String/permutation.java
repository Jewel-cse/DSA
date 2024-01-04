package String;

class permutation {
    private static void permute(int ind, StringBuilder sb) {
        if (ind == sb.length()) {
            //get one permutation
            System.out.println(sb.toString());
            return;
        }
        for (int i = ind; i < sb.length(); i++) {
            swap(ind, i, sb);
            permute(ind + 1, sb);
            swap(ind, i, sb);
        }
    }
    private static void swap(int i, int ind, StringBuilder sb) {
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(ind));
        sb.setCharAt(ind, ch);
    }
    
    public static void main(String[] args) {
        
        permute(0, new StringBuilder("abcd"));
    }
}
