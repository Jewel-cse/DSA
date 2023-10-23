package GreedyAlgo;

import java.util.Comparator;

public class knapsackComparator implements Comparator<Item>{
    public int compare(Item a, Item b) {
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);
        if (r1 > r2)    //descending order 
            return -1;
        else if(r1<r2)
            return 1;
        
        return 0;
    }
}
