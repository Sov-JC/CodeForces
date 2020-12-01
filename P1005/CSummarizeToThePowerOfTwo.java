package P1005;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;


//Fails on test 7
public class CSummarizeToThePowerOfTwo {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt(); in.nextLine();

        if(n==1) {
            out.println(1);
            return;
        }

        Long[] a = new Long[n];

        for(int i=0; i<n; i++)
            a[i] = in.nextLong();

        Arrays.sort(a);

        int removed = 0;
        for(int i=0; i<a.length; i++){
//            out.println("i: " + i);
            boolean jFound = false;
            for(int p=-1; p<=32 && !jFound; p++){
//                out.println("p: " + p);
                Long j = (long)Math.pow((long)2,(long)p) - a[i];
//                out.println("Searching for a j equal to: " + j);

                if(j<0)
                    continue;

                int index = Arrays.binarySearch(a,j);
//                out.println("index: " + index);

                if(index >= 0){
//                    out.println("a contains value: " + a[index]);
                    if(a[i].equals(j)) {
                        //find a duplicate
                        if (index == 0) {
                            if (a[index + 1].equals(a[index])) {
                                jFound = true;
//                                out.println("---jFound for i: " + i + " where j is: " + j);
                            }
                        } else if (index == a.length - 1) {
                            if (a[index - 1].equals(a[index])) {
//                                out.println("--jFound for i: " + i + " where j is: " + j);
                                jFound = true;
                            }
                        } else {
                            Long left = a[index - 1];
                            Long right = a[index + 1];

                            if ((left.equals(a[index])) || (right.equals(a[index]))) {
                                jFound = true;
//                                out.println("- jFound for i: " + i + " where j is: " + j);
                            }
                        }
                    }else{
                        jFound = true;
//                        out.println("jFound for i: " + i + " where j is: " + j);
                    }
                }
            }

            if(!jFound){
//                out.println("removed index: " + i);
                a[i] = Long.MIN_VALUE;
                removed++;
            }
        }

        out.println(removed);
    }
}
