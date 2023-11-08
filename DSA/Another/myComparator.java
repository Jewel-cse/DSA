package Another;

import java.util.Comparator;

public class myComparator implements Comparator {
   /* 
   /// @@@@@@@@@@@@ sort integer descending order @@@@@@@@@@@@
   ///  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   @Override
   public int compare(Object o1, Object o2) {
   Integer i = (Integer) o1;
   Integer j = (Integer) o2;
   if (i > j) {
       return -1;
   } else if (i < j) {
       return 1;
   } else
       return 0;
   } 
   
   //@@@@@@@@@ some trick using default compareTo for integer   @@@@@@@@@@
   //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   // Look @@@@@@@@@@custom sort class
   public int compare(Object o1, Object o2) {
   Integer i = (Integer) o1;
   Integer j = (Integer) o2;
   
   //return i.compareTo(j);   //ascending
   //return -i.compareTo(j); //descending
   //return j.compareTo(i); //descending
   //return 1;      // preserve insertion order
   //return -1; // reverse of insertion order
   return 0;   //only first element insert , others consider duplicate
   }
   
   public int compare(Object i, Object j) {
    String s1 = (String) i;
    String s2 = (String) j;
    //return s1.compareTo(s2);  //a-z 1st/2nd...
    
    return -s1.compareTo(s2); //z-a 1st/2nd...  or s2.campareTo(s1);
    
   }
   */
   //@@@@@@@@sort length wise if length== then alphabatically
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  public int compare(Object i, Object j) {

      String s1 = (String) i;
      String s2 = (String) j;

      int l1 = s1.length();
      int l2 = s2.length();

      if (l1 < l2) //1st length smaller
          return -1;
      else if (l1 > l2) // 2nd length smaller
          return 1;
      else { //both are equal ,alphabatically sort 
          return s1.compareTo(s2);
      }
  }

    
  //@@@@@@@@@@@@ Sort with 2 parameter @@@@@@@@@@@
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


   

}
