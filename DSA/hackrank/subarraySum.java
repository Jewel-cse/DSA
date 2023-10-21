package hackrank;

import java.util.ArrayList;
import java.util.List;

public class subarraySum {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numbers.add(i);
        }
        //System.out.println(numbers);
        
        List<List<Integer>> queries = List.of(List.of(1, 3,5), List.of(1, 2,10));

        List<Long> result = findSum(numbers, queries);
        System.out.println(result);

    }
    public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {
        List<Long> result = new ArrayList<>();  // result rakhar jonno
        // Write your code here
            int loop  =  queries.size();
            int k = 0;
            while(k<loop){
                int start = queries.get(k).get(0);
                int end = queries.get(k).get(1);
                int x = queries.get(k).get(2);
            
                //System.out.println(end);
                Long temp = (long) 0.0;
                for (int i = start; i <= end; i++) {
                    //System.out.println(numbers.get(i));
                    if(numbers.get(i-1)!=0){
                        temp+= numbers.get(i-1);
                    }
                    else{
                        temp += x;
                    }
                }
                result.add(temp);

                k++;

            }
            return result;
        }
}
