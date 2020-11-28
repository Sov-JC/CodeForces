package P1005;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class ATanyaAndStairways {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(); in.nextLine();
        int s[] = new int[n];

        for(int i=0; i<n; i++)
            s[i] = in.nextInt();

        int[] stairs = new int[n];
        Arrays.fill(stairs, 0);
        int stairP = 0;
        stairs[stairP]++;
        for(int i=1; i<n; i++){
            if(s[i] <= s[i-1]) {
                stairP++;
            }

            stairs[stairP]++;
        }

        int totalStairs = 0;
        for(int stair: stairs){
            if(stair!=0){
                totalStairs++;
            }
        }

        out.println(totalStairs);

        for(int stair: stairs){
            if(stair!=0){
                out.print(stair + " ");
            }
        }

    }
}
