package DSA.String;


public class karpRabin {
    private static int prime  = 3;
    //@@@@@@@@@@@@@@ calculate hashvalue
    private static long hashValue(String pattern) {
        long h = 0;
        for (int i = 0; i < pattern.length(); i++) {
            h += (pattern.charAt(i) - 'a' + 1) * Math.pow(prime, i);
        }
        return h;
    }
    
    //@@@@@@@@@ re-calculate for rolling at text 
    private static long reCalculatehash(long oldHash, char oldch, char newch, int patlen) {
        long newhash = oldHash - oldch - 'a' + 1;
        newhash = newhash / prime;
        newhash += (newch - 'a' + 1) * Math.pow(prime, patlen - 1);

        return newhash;
    }

    //@@@ if hash equal then check individual index equal
    private static boolean isEqual(String txt, String pat, int patlen) {
        for (int i = 0; i < patlen; i++) {
            if (txt.charAt(i) != pat.charAt(i))
                return false;
        }
        return true;
    }
    
    //@@@@ match the string @@@@@@@@ ############## INCOMPLETE
    static void matchsubString(String txt, String pattern) {
        
        int plen = pattern.length();
        
        long hp = hashValue(pattern);
        long ht = hashValue(txt.substring(0, plen));
       
        for (int i = 1; i <= txt.length() - plen+1; i++) {
            
            //System.out.println(txt.substring(i, i+plen));
            if (hp == ht && isEqual(txt.substring(i-1, i + plen-1), pattern, plen)) {
                System.out.println("pattern found at : " + (i-1));
                
            } 
            //new calculate 
            if(i<txt.length() - plen+1)
                ht = reCalculatehash(ht, txt.charAt(i-1), txt.charAt(i + plen-1), plen);
        
        }
    }

    public static void main(String[] args) {
        String txt = "aaabcabababacbababacbababc";
        String pat = "abc";
        
        matchsubString(txt, pat);
       // System.out.println(isEqual(txt, pat, 3));
    }
}
