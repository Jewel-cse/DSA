package SRBD;
//spaceship or bomb explosion problem using @@@@RECURSION
/*
https://www.careercup.com/question?id=5652067409461248
https://www.geeksforgeeks.org/samsung-interview-experience-set-28-campus/
https://code.hackerearth.com/ea07cfD?key=1cb190b158c79639d66d35f7dfa8ef7a -> One
Problem::
You’ll be given a grid as below:

    0 1 0 2 0
    0 2 2 2 1
    0 2 1 1 1
    1 0 1 0 0
    0 0 1 2 2
    1 1 0 0 1
    x x S x x

In the grid above,
  1: This cell has a coin.
  2: This cell has an enemy.
  0: It contains nothing.

  The highlighted(yellow) zone is the control zone. S is a spaceship that we need to control so that we can get 
  maximum coins.
  Now, S’s initial position will be at the center and we can only move it right or left by one cell or do not move.
  At each time, the non-highlighted part of the grid will move down by one unit.
  We can also use a bomb but only once. If we use that, all the enemies in the 5×5 region above the control zone 
  will be killed.
  If we use a bomb at the very beginning, the grid will look like this:

    0 1 0 2 0
    0 0 0 0 1
    0 0 1 1 1
    1 0 1 0 0
    0 0 1 0 0
    1 1 0 0 1
    x x S x x

  As soon as, the spaceship encounters an enemy or the entire grid has come down, the game ends.
  For example,
  At the very first instance, if we want to collect a coin we should move left( coins=1). This is because when the 
  grid comes down by 1 unit we have a coin on the second position and by moving left we can collect that coin. 
  Next, we should move right to collect another coin (coins=2).
  After this, remain at the same position (coins=4).
  This is the current situation after collecting 4 coins.

    0 1 0 2 0 0 1 0 0 0
    0 2 2 2 1 -->after using 0 0 0 0 1
    x x S x x -->bomb x x S x x

Now, we can use the bomb to get out of this situation. After this, we can collect at most 1 coin. So maximum coins=5.
*/
import java.util.Scanner;

public class spaceShipExpolsion {

    static void updateMatrix(int row, char[][] matrix) {
        if (row < 0) {
            return;
        }
        int upLimit = Math.max(0, row - 4);
        for (int i = row; i >= upLimit; i--) {
            for (int j = 0; j <= 4; j++) {
                if (matrix[i][j] == '2') {
                    matrix[i][j] = '0';
                }
            }
        }
    }

    //                       #row, spaceship pos, #bomb , matrix ///
    static int findMaxPoints(int row, int col, int bombs, char[][] matrix) {
        if (row <= 0 || col < 0 || col >= 5) {
            return 0;
        }
        int answer = 0;
        if (row > 0 && matrix[row - 1][col] != '2') { //not move
            answer = Math.max(answer,
                    (matrix[row - 1][col] == '1' ? 1 : 0) + findMaxPoints(row - 1, col, bombs, matrix));
        }
        if (col > 0 && row > 0 && matrix[row - 1][col - 1] != '2') { //move left 
            answer = Math.max(answer,
                    (matrix[row - 1][col - 1] == '1' ? 1 : 0) + findMaxPoints(row - 1, col - 1, bombs, matrix));
        }
        if (col < 4 && row > 0 && matrix[row - 1][col + 1] != '2') { //move right
            answer = Math.max(answer,
                    (matrix[row - 1][col + 1] == '1' ? 1 : 0) + findMaxPoints(row - 1, col + 1, bombs, matrix));
        }
        if (answer == 0 && bombs > 0) {
            updateMatrix(row - 1, matrix);
            answer = findMaxPoints(row, col, bombs - 1, matrix);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Number of test 
        int t = scanner.nextInt();
        int tNo = 0;

        while (t-- > 0) {
            //take char matrix
            int row = scanner.nextInt();
            char[][] matrix = new char[row][5];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < 5; j++) {
                    matrix[i][j] = scanner.next().charAt(0);
                }
            }
            tNo++;
            System.out.println("#" + tNo + " : " + findMaxPoints(row, 2, 1, matrix));
        }
        scanner.close();

    }
}
/*
#test case 
>>row 5
0 0 2 0 1
2 1 1 0 2
1 0 2 1 1
0 1 0 1 0
1 0 1 0 0
x x s x x << lets imagin my spaceship>>

Ans : 4
>>row 5
1 1 2 0 1
2 1 1 0 2
1 0 2 1 1
0 1 0 1 0
1 0 1 0 0
 x x s x x << lets imagin my spaceship>>
Ans : 5
>> row 6
0 1 0 2 0
0 0 0 0 1
0 0 1 1 1
1 0 1 0 0
0 0 1 0 0
1 1 0 0 1
ans: 5
 */
