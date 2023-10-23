package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;

public class nMeetingInaRoom {
    
    public static int maximumMeetings(int[] start, int[] end) {
        int numberOfMeeting = 0;
        if (start.length == 0 && end.length == 0)
            return 0;
        ArrayList<meeting> meet = new ArrayList<>();
        //add to list
        for (int i = 0; i < end.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }

        //sort the list according to comparator
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);

        //prepare answer
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        numberOfMeeting++;
        for (int i = 1; i < end.length; i++) {
            if ((meet.get(i).start) > limit) { //porer start ager end er por holei meeting kora jabe
                ans.add(meet.get(i).pos); //answer list a koto no meeting host kora jabe tar list
                limit = meet.get(i).end;
                numberOfMeeting++;
            }
        }
        return numberOfMeeting;
    }
    
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maximumMeetings(start, end));
    }
    
}

