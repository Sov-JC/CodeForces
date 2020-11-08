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

        LinkedList<String> ordered = new LinkedList<>();

        int[] substrCount = new int[n];
        for(int i=0; i<substrCount.length; i++)
            substrCount[i] = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    continue;
                if(strings.get(j).contains(strings.get(i))){
                    substrCount[i]++;
                }
            }
        }

        for(int i=0; i<n; i++)
            System.out.print(substrCount[i] + " ");
        System.out.println();

        for(int i=100; i>=0; i--){
            if(i==0){
                String str = strings.get(i);

                boolean isASubstringOfA
            }

            ArrayList<String> iSubstrCount = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(substrCount[j] == i){
                    iSubstrCount.add(strings.get(j));
                }
            }

            if(iSubstrCount.size()>0){
                String firstStr = iSubstrCount.get(0);
                for(int j=1; j<iSubstrCount.size(); j++){
                    String str = iSubstrCount.get(j);
                    if(str.equals(firstStr) == false){
                        out.println("NO");
                        return;
                    }
                }
            }
        }

        for(int i=100; i>=0; i--){
            for(int j=0; j<n; j++){
                if(substrCount[j] == i){
                    ordered.add(strings.get(j));
                }
            }
        }

        Stack<String> stack = new Stack<>();

        for(String s: ordered)
            stack.push(s);

        out.println("YES");
        for(String s: stack) {
            out.println(s);
        }
    }
}
