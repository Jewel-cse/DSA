package GreedyAlgo;

import java.util.Arrays;

public class fractionalKnapsack {
    public static double maximumValue(Item[] items, int n, int w) {
        //sort acording to ratio of v/w
        Arrays.sort(items, new knapsackComparator());

        /*
         * 
         for (Item item : items) {
             System.out.println(item.value + " " + item.weight);
         }
         */
        double maxVal = 0.0;
        int wgt = 0;
        for (int i = 0; i < n; i++) {
            if (wgt + items[i].weight <= w) {
                wgt += items[i].weight; 
                maxVal += items[i].value; // value increase
            } else { // wgt poriman item add korbo
                maxVal += (double) (w - wgt) * ((double) items[i].value / (double) items[i].weight);
                break;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Item[] items = new Item[6];
        int[] weight = { 50, 40, 90, 120, 10, 200 };
        int[] value = { 40, 50, 25, 100, 30, 45 };
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        System.out.println(maximumValue(items, items.length, 200));
    }
}
/*
 * 
 1
 6 200
 50 40 90 120 10 200 //weitht
 40 50 25 100 30 45  //value
 */
