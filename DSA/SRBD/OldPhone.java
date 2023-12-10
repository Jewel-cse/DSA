package SRBD;

/*
/*
https://www.careercup.com/question?id=5680648437104640

You are given an old touch smartphone numbers having dial pad and calculator app.
Aim: The goal is to type a number on dialpad.

But as phone is old, some of the numbers and some operations can't be touched.
For eg. 2,3,5,9 keys are not responding , i.e you cannot use them
But you can always make a number using other numbers and operations in Calculator. There could be multiple ways of making a number

Calculator have 1-9 and +,-,*,/,= as operations. Once you have made the number in Calculator you can copy the number and use it.

You have to find minimum number to touches required to obtain a number.

#Input:#
There will be multiple Test cases .Each test case will consist of 4 lines
1) First line will consist of N,M,O
	N: no of keys working in Dialpad (out of 0,1,2,3,4,5,6,7,8,9)
	M:types of operations supported (+,-,*,/)
	O: Max no of touches allowed
2) second line of input contains the digits that are working e.g 0,2,3,4,6.
3) Third line contains the valued describing operations, 1(+),2(-),3(*),4(/)
4) fourth line contains the number that we want to make .

#Output:#
Output contains 1 line printing the number of touches required to make the number

 */
import java.util.Scanner;

public class OldPhone {
    static int[] working, operations;
    static int answer = Integer.MAX_VALUE;
    static int n, m, o;
    static int inf = -(int) 1e9;

    //@@@@@@@@@@ : evalute the expression (+,-,*,/) other wise 0;
    static int eval(int prev, int curr, int op) {
        if (prev == inf) {
            return curr;
        }

        if (op == 1) {
            return prev + curr;
        }
        if (op == 2) {
            return prev - curr;
        }
        if (op == 3) {
            return prev * curr;
        }
        if (op == 4) {
            if (curr == 0) {
                return -1;
            } else {
                return prev / curr;
            }
        }
        return 0; // Return default value if none of the conditions match
    }

    //@@@@@@@@@@ 
    static boolean isDone(int prev, int curr, int Operation, int target) {
        if (Operation == 4 && curr == 0) {
            return false;
        }

        return eval(prev, curr, Operation) == target;
    }

    //FROM MAIN :  previous value, current value, current operation, touch ,target
    static void findMinTouch(int prev, int curr, int ooperation, int tou, int t) {
        if (ooperation != -1 && curr != inf) {
            boolean k = isDone(prev, curr, ooperation, t);
            if (k && tou < o) {
                if (answer > tou + 1)
                    answer = tou + 1;
            }
        }
        if (prev == t && tou < o && ooperation != -1 && curr == inf) {
            answer = Math.min(answer, tou);
        }
        if (ooperation == -1 && curr == t && tou < o) {
            answer = Math.min(answer, tou);
        }
        if (tou > o) // if touch is greater than opeation then return
            return;

        for (int i = 0; i < m; i++) {
            if (curr == inf)
                break;
            if (curr == 0 && ooperation == 4)
                continue;
            int val = eval(prev, curr, ooperation);
            findMinTouch(val, inf, operations[i], tou + 1, t);
        }
        for (int i = 0; i < n; i++) {
            if (curr == inf) {
                findMinTouch(prev, working[i], ooperation, tou + 1, t);
            } else {
                int val = Math.abs(curr);
                val = val * 10 + working[i];
                if (curr < 0) {
                    val *= -1;
                }
                findMinTouch(prev, val, ooperation, tou + 1, t);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int count = 0;

        while (t-- > 0) {
            answer = Integer.MAX_VALUE;
            n = scanner.nextInt(); /// number of working keys {1 2 .}
            m = scanner.nextInt(); // number of operations {+ - *}
            o = scanner.nextInt(); // number of touch  {4}

            working = new int[n + 2];
            for (int i = 0; i < n; i++) {
                working[i] = scanner.nextInt();
            }

            operations = new int[m + 2];
            for (int i = 0; i < m; i++) {
                operations[i] = scanner.nextInt();
            }

            int target = scanner.nextInt();
            //input done@@@@@@@@@@@

            findMinTouch(inf, inf, -1, 0, target);
            count++;
            System.out.println("#" + count + ": " + answer);
        }
        scanner.close();
    }
}
/*
#Sample Test Case:#
5 

5 3 5
1 2 4 6 0
1 2 3
5

6 4 5 
1 2 4 6 9 8
1 2 3 4
91

6 2 4
0 1 3 5 7 9
1 2 4
28

5 2 10
1 2 6 7 8
2 3
981

6 3 5
1 4 6 7 8 9
1 2 3
18

#Output:#
4
2 
5
9
2


 */

