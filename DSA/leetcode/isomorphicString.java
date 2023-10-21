import java.util.HashMap;

public class isomorphicString {
    public static void main(String[] args) {
       String s = "paper";
       String t = "title";
    
       System.out.println(isIsomorphic(s, t));
    }
    public static boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[200];
        int[] m2 = new int[200];
        
        for (int i = 0; i < s.length(); i++) {
            if(m1[s.charAt(i)] != m2[t.charAt(i)]){
                return false;
            }
            m1[s.charAt(i)] = i+1;     // position matching
            m2[t.charAt(i)] = i+1;
        }
        return true;
        
    }
}
