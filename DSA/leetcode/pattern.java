public class pattern {
    public static void main(String[] args) {
        int n = 5;
        //pattern 1 : ractangle not solidddd
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0 || j == n || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        //pattern 2 : triangle
        int val = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //System.out.print("*");
                //System.out.print(j);
                System.out.print(val); val++;
            }
            System.out.println();
        }

        /*          *
                   **
                  ***
                 ****
         */

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");

            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
         
        //
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                //System.out.print("*");
                System.out.print(j);
            }
            System.out.println();
        }
        

        /* 1
           01
           101
           0101
        */
        /////// approach 1
        val = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                val = 1;
            else
                val = 0;
            for (int j = 1; j <= i; j++) {
                System.out.print(val);
                if (val == 1)
                    val = 0;
                else
                    val = 1;
            }
            System.out.println();

        }
        // approach 2 .........
        for (int i = 1; i <= n; i++) {
               for (int j = 1; j <= i; j++) {
                   int sum = i + j;
                   if (sum % 2 == 0) {
                       System.out.print(1);
                   }
                   else
                        System.out.print(0);
            }
              System.out.println();      
        }


    }
}
