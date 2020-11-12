package P999;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class AMishkaAndContest {

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt(); int k = in.nextInt(); in.nextLine();
        ArrayList<Integer> x = new ArrayList<>();

        for(int i=0; i<n; i++)
            x.add(in.nextInt());

        int counter=0;
        int i=0;
        for(; i<n; i++)
            if(x.get(i) <= k){
                counter++;
            }else{
                break;
            }

        for(int j=n-1; j>i; j--)
            if(x.get(j) <= k){
                counter++;
            }else{
                break;
            }

        out.println(counter);


    }
}
