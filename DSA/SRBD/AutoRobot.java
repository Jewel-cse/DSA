package SRBD;

import java.util.Scanner;
//Problem description: https://blog.csdn.net/weixin_42688573/article/details/124970239
//// find the minimun moveing distance after fill 1L fuel to each cars
public class AutoRobot {

    static int[] arr;
    static int[] visited;
    static int tdistance;
    static int mx = (int) 1e9;

    public static void calc_min(int n, int distance, int rem, int pindex, int cars, int ins, int g_or_d) {
        if (cars == n) {
            if (tdistance > distance) {
                tdistance = distance;
            }
            return;
        }
        if (rem <= 0)
            return;

        if (ins == 0 && g_or_d == 0) {
            for (int k = 1; k <= n; k++) {
                if (visited[k] == 0 && arr[k] == 1) {
                    visited[k] = 1;
                    calc_min(n, distance + (k > pindex ? k - pindex : pindex - k), rem - 1, k, cars + 1, 0, 0);
                    calc_min(n, distance + (k > pindex ? k - pindex : pindex - k), 2, k, cars + 1, 1, 0);
                    calc_min(n, distance + (k > pindex ? k - pindex : pindex - k), 2, k, cars + 1, 2, 0);
                    visited[k] = 0;
                }
            }
        }

        if (ins == 0 && g_or_d == 1) {
            for (int k = n; k >= 1; k--) {
                if (visited[k] == 0 && arr[k] == 2) {
                    visited[k] = 1;
                    calc_min(n, distance + (k > pindex ? k - pindex : pindex - k), rem - 1, k, cars + 1, 0, 1);
                    calc_min(n, distance + (k > pindex ? k - pindex : pindex - k), 2, k, cars + 1, 1, 1);
                    calc_min(n, distance + (k > pindex ? k - pindex : pindex - k), 2, k, cars + 1, 2, 1);
                    visited[k] = 0;
                }
            }
        }

        if (ins == 1) {
            calc_min(n, distance + (pindex - 0), 2, 0, cars, 0, 0);
        }
        if (ins == 2) {
            calc_min(n, distance + ((n + 1) - pindex), 2, n + 1, cars, 0, 1);
        }
    }

    //@@@@@@@@ MAIN FUNCION 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            //input part......................
            int n = scanner.nextInt();
            arr = new int[n + 1];
            visited = new int[n + 1];
            tdistance = mx;

            for (int i = 1; i <= n; i++) {
                arr[i] = scanner.nextInt();
            }
            //find mini
            calc_min(n, 0, 2, 0, 0, 0, 0);
            if (tdistance == mx) {
                calc_min(n, n + 1, 2, n + 1, 0, 0, 1);
            }
            System.out.println("Case #" + (t -t) + " " + tdistance);
            tdistance = 99999;
        }
    }
}
