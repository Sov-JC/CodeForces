package P988;

import java.util.*;
import java.io.PrintWriter;

public class BSubstringsSort {

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        ArrayList<String> strings = new ArrayList<>();

        int n = in.nextInt(); in.nextLine();

        for(int i=0; i<n; i++){
            strings.add(in.nextLine());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1;j<n; j++){
                if(strings.get(i).length() > strings.get(j).length()){
                    String temp = strings.get(i);
                    strings.set(i, strings.get(j));
                    strings.set(j, temp);
                }
            }
        }

        StringBuffer ans = new StringBuffer();

        for(int i=0; i<n; i++){
            String str = strings.get(i);

            for(int j=i+1; j<n; j++){
                if(strings.get(j).contains(str) == false){
                    out.println("NO");
                    return;
                }
            }

            ans.append(str + " ");
        }

        out.println("YES");
        out.println(ans.toString().trim());
    }
}
