package P988;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

public class ADiverseTeam {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        in.nextLine();

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> indeces = new ArrayList<>();

        for(int i=0; i<n; i++)
            a[i] = in.nextInt();

        for(int i=0; i<n; i++){
            if(set.contains(a[i]) == false) {
                if(indeces.size() == k)
                    continue;
                set.add(a[i]);
                indeces.add(i);
            }
        }

        if(indeces.size() == 0 || indeces.size() != k){
            out.println("NO");
        }else{
            out.println("YES");
            for(int i: indeces)
                out.print((i + 1) + " ");

        }


    }
}
