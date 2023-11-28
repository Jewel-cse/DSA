package SRBD;

import java.util.Scanner;

/*
 Problem statement : Sum of the node of given level of a tree
 link: https://www.hackerrank.com/contests/target-samsung-13-nov19/challenges/sum-of-nodes-in-kth-level/problem
 
idea:
    : traverse string from level -1 means root 
    : if'('   >>> level up
    : if ')'  >>> level down
    : when it reach kth level : from that index to next convert it into number 
    : sum up the number  and repeat
 */
public class sumOfNodeKthLevel {
    //main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String tree = sc.nextLine();
        
        int sum = findKthlevelSum(k, tree);
        System.out.println(sum);
        sc.close();
    }
    //@@@ function for find the sum of given level
    private static int findKthlevelSum(int k, String tree) {
        int level = -1;
        int sum = 0;
        for (int i = 0; i < tree.length(); i++) {
            //level up
            if (tree.charAt(i) == '(') 
                level++;
                //level down
            else if (tree.charAt(i) == ')') 
                level--;
            //aw!! my level, lets catch up to next level
            else if (level == k ) {
                int x = tree.charAt(i) - '0';
                i++;
                while (tree.charAt(i) >= '0' && tree.charAt(i) <= '9') {
                    x = x * 10 + tree.charAt(i) - '0';
                    i++;
                }
                i--;
                sum += x;
            }
        }
        return sum;
    }

}
/*
@@ testcase:::::
2
(0(5(6()())(4()(9))))
ans: 10

2
(0(5(16()())(4()(9()())))(7(1()())(3()())))
ans : 24
 */
