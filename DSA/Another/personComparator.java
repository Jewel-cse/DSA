package Another;

import java.util.Comparator;
//works for only PersonSort type objects..............@@@@@@....
public class personComparator implements Comparator<PersonSort> {
    //@@@@@@@ person comparator: sort using name -> id
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    public int compare(PersonSort p1, PersonSort p2) {
        int comp = p1.getName().compareTo(p2.getName());
        if (comp == 0) { // 0 means duplicate
            // sort according to id
            //call the compare function of Integer class.
            return Integer.compare(p1.getId(), p2.getId());
        }
        return comp;
    }
}
