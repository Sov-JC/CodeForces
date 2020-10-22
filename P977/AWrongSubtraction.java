package P977;

import java.util.Scanner;
import java.io.PrintWriter;

public class AWrongSubtraction {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        while(k>0){
            if(n%10==0){
                n=n/10;
            }else{
                n--;
            }
            k--;
        }

        out.println(n);
    }
}
