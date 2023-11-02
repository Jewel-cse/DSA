
public class rmove_adjacent_duplicate {
    public static void main(String[] args) {
    
        String str = "leet**cod*e";    //leecoe
        System.out.println(removeDuplicates(str));
    }
    //method last theke asbo * > cnt++ na paile --, cnt == 0 string a add korbo
    public  static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i <n; i++) {
            if(s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            }
            else
                sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
        
}
