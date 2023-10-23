package GreedyAlgo;

import java.util.Comparator;

public class meetingComparator implements Comparator<meeting> {
    public int compare(meeting m1, meeting m2) {
        if (m1.end < m2.end)
            return -1; // according to end time 
        else if (m1.end > m2.end)
            return 1;
        else if (m1.pos < m2.pos) // if end same hoi tahole position time
            return -1;
        return 1;
    }
    
}
