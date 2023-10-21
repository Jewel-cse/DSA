package Stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidColision {
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            
            boolean colide = !st.empty() && asteroids[i] < 0 && st.peek() > 0 ;
           
            
             while ( colide && Math.abs(asteroids[i]) > Math.abs(st.peek())){   
                st.pop();
                colide = !st.empty() && asteroids[i] < 0 && st.peek() > 0 ;   //destroy peek while colide
            }
             if (colide && Math.abs(asteroids[i]) < Math.abs(st.peek()))  
                 continue;       //destroy asteroid[i]
             
             else if ( colide && asteroids[i]+st.peek() == 0) {   
                 st.pop();   //destroyed both when same but oposite direction
                 continue;
             }

            st.push(asteroids[i]);
        }
        int arrlen = st.size();
        int[] arr = new int[arrlen];
        for (int i = arrlen - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] asteroid = { 5,10,-5 };
        System.out.println(Arrays.toString(asteroidCollision(asteroid)));
    }
}
