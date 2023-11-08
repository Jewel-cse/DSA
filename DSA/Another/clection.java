package Another;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Vector;

public class clection {
    public static void main(String[] args) {
        /*  //list
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i*3);
        } 
        
        //ll
        LinkedList<Integer> l2 = new LinkedList<>(l);
        // System.out.println(l2); //internally call l2.toString()
        
        ///vector
        Vector<Integer> v = new Vector<>(l);
        System.out.println(v);
        
        //Stack
        Stack<Integer> st = new Stack<>();
        st.push(3); 
        st.push(3); 
        st.push(9);
        //System.out.println(st);
        
        //@@@@@@@@@@@@@@@@@@@  Cursor  @@@@@@@@@@@@@@@
        //enumaretion, iterator,ListIterator
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        
        //enumaretion > vector.elements()  method used korbe
        //only legacy class 
        //remove korte pare na
        // hasmoreElement and hasNextElement()
        
        
        Enumeration e = v.elements(); //old
        e.getClass().getName();
            while (e.hasMoreElements()) {
         System.out.println((Integer) e.nextElement());
        
        } 
        
        //@@@@@@@@@@@@@@@      Iterator: 
        /*
        * universal cursor
        * any collection object
        * read , remove
        
        
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
          //System.out.println(it.next());
          if (it.next() % 2 == 0)
          it.remove();
        }
        System.out.println(l); //original element remove
        
        */

        //@@@@@@@@@@@       ListIterator
        /*
        * : bi direction(forward and backward )
        read, remove, replace, add
        only for list implemnt class object
        
        ListIterator<Integer> lt = l2.listIterator();
        while (lt.hasNext()) {
         System.out.println(lt.previous());
         if (lt.previous() % 2 == 0)
             //lt.remove();
             System.out.println(lt.previous());
        }
        //System.out.println(l); //original element remove
        
        
        // 
        
        //@@@ will we create new object interface??? NO
        Vector v = new Vector<>();
        
        Enumeration e = v.elements();
        Iterator it = v.iterator();
        ListIterator lt = v.listIterator();
        
        System.out.println(e.getClass().getName()); //annonymous inner class inside vector 
        System.out.println(it.getClass().getName());
        System.out.println(lt.getClass().getName());
        
        */
    }
   

}
