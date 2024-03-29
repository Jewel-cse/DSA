
//https://leetcode.com/problems/remove-duplicate-letters/

public static String removeDuplicateLetters(String s) {
 
       Stack<Character> st = new Stack<>();
       int[] lastIndex = new int[26];
       boolean[] vis = new boolean[26];

       for(int i= 0;i<s.length();i++){
        lastIndex[s.charAt(i) - 'a'] = i;
       }

       for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(vis[ch-'a']) continue;
            while(!st.isEmpty() && ch<st.peek() && i<lastIndex[st.peek()-'a']){
                vis[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(ch);
            vis[ch-'a'] = true;
       }
       String res = "";
       while(!st.isEmpty()){
         res = st.pop()+res;
       }
       return res;
    }


//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
//same strategy without extra stack ......

 public String smallestSubsequence(String s) {
        StringBuilder sb = new StringBuilder();
        int[] lastIndex = new int[26];
        boolean[] vis = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vis[ch - 'a'])
                continue;
            while (!sb.isEmpty() && ch < sb.charAt(sb.length()-1) && i < lastIndex[sb.charAt(sb.length()-1) - 'a']) {
                vis[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch);
            vis[ch - 'a'] = true;
        }
        
       
        return sb.toString();
    }









