package Another;

import java.util.TreeSet;

public class CustomSort {
    
    public static void main(String[] args) {
        /* 
        //@@@@@ sort integer  descending
        TreeSet<Integer> t = new TreeSet<>(new myComparator());
        t.add(12);    
        t.add(132); //===== compare(132,12)
        t.add(1);   // ===  compare(1,12)
        
        System.out.println(t);
        
        
        //@@@@@@@@@ Sort string/StringBuffer/StringBuilder  @@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ make sure type cast
        
        TreeSet<String> ts = new TreeSet<>(new myComparator());
        ts.add("hello");
        ts.add("world");
        ts.add("jewel");
        ts.add("rana");
        System.out.println(ts);
        
        
        //@@@@@@@ Sort like[a,b,aa,bb,xxx] @@@@@@@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        TreeSet ts = new TreeSet<>(new myComparator());
        
        ts.add("hello");
        ts.add("rana");
        ts.add("jewel");
        ts.add("no");
        
        System.out.println(ts);
        
        */
        // @@@@@@@@@@@  sort name, id @@@@@@@@@@
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // class: PersonSort, personComparator,Custom.java

        TreeSet<PersonSort> ts = new TreeSet<>(new personComparator());
        ts.add(new PersonSort("jewel", 20));
        ts.add(new PersonSort("jewel", 12));
        ts.add(new PersonSort("himu", 22));
        ts.add(new PersonSort("rimu", 2));

        
        for (PersonSort p : ts) {
            System.out.println(p.getName()+ " " +p.getId());
        }
       
       
        
    }

}
