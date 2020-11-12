package P988;

import java.util.*;
import java.io.PrintWriter;

public class DPointsAndPowersOfTwo {

    Long[] powOfTwo(int n){
        Long[] p = new Long[n+1];
        for(int i=0; i<=n; i++){
            p[i] = (long)Math.pow(2.0, i);
        }
        return p;
    }

//    private int isPowOfTwo(Long n){
//        int max = (int)Math.log(n);
//
//        for(int i=0; i<=max; i++){
//            if((long)Math.pow(2, i) == n)
//                return i;
//        }
//
//        return -1;
//    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt(); in.nextLine();

        Long x[] = new Long[n];
        for(int i=0; i<n; i++){
            x[i] = in.nextLong();
        }

        Arrays.sort(x);

        Long[] pTwo = powOfTwo(30); // ~ 1 billion

        ArrayList<Long> ans = new ArrayList<>();

        //check if answer is 3
        for(int i=1; i<n-1; i++){
            for(Long p: pTwo){
                Long a = x[i] - p;
                Long c = x[i] + p;

                //System.out.println("checking a: " + a + ", b: " + x[i] + ", c: " + c);
                if(Arrays.binarySearch(x, a) >= 0 && Arrays.binarySearch(x, c) >= 0){
//                    System.out.println("Is 3");
                    ans = new ArrayList<>();
                    ans.add(a);
                    ans.add(x[i]);
                    ans.add(c);
                }
            }
        }

        //check if answer is 2
        for(int i=0; i<x.length && ans.size() <= 2; i++){
            for(Long p: pTwo){
                if(Arrays.binarySearch(x,x[i]+p) > 0){

                    ans = new ArrayList<>();
                    ans.add(x[i]);
                    ans.add(x[Arrays.binarySearch(x,x[i]+p)]);
                }
            }
        }

        if(ans.size() == 0) {
            ans = new ArrayList<>();
            ans.add(x[0]);
        }

        out.println(ans.size());
        for(Long a: ans)
           out.print(a + " ");



    }
}
