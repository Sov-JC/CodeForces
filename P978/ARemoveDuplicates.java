package P978;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class ARemoveDuplicates {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }


        for (int i = n - 1; i >= 0; i--) {
            int value = array[i];
            if (value == 1001)
                continue;

            for (int j = 0; j < i; j++) {
                if (value == array[j]) {
                    array[j] = 1001;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(array[i] != 1001){
                ans.add(array[i]);
            }
        }

        int count = ans.size();
        out.println(count);
        for(int i=0 ;i<ans.size(); i++)
            out.print(ans.get(i) + " ");
    }
}


