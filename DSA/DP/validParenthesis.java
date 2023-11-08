package DP;


import java.util.ArrayList;
import java.util.List;

public class validParenthesis {
    public static boolean checkValidString(String s) {
        List<Character> ls = new ArrayList<>();

        return validcheck(s.length() - 1, s, ls);
    }

    private static boolean validcheck(int index, String s, List<Character> ds) {
        if (index < 0) {
            //check for valid and return 
            return check(ds);
        }
        boolean nonStar = false;
        boolean starSpace = false, starOpen = false, starClose = false;
        if (s.charAt(index) != '*') {
            ds.add(s.charAt(index));
            nonStar = validcheck(index - 1, s, ds);
            ds.remove(ds.size() - 1);
        } else {
            //ds.add(' ');
            starSpace = validcheck(index - 1, s, ds);
            //ds.remove(ds.size() - 1);

            ds.add('(');
            starOpen = validcheck(index - 1, s, ds);
            ds.remove(ds.size() - 1);
            //ds.remove(ds.size() - 2);

            ds.add(')');
            starClose = validcheck(index - 1, s, ds);
            ds.remove(ds.size() - 1);
        }
        return nonStar || starSpace || starOpen || starClose;
    }

    private static boolean check(List<Character> ds) {
        
        int counter = 0;
        if (ds.get(ds.size()-1) == ')')
            return false;
        for (int i = ds.size()-1; i >=0; i--) {
            if (ds.get(i) == '(')
                counter++;
            else
                counter--;
        }
        return counter == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("((*)"));
    }
    
}
