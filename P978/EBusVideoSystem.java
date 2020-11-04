package P978;

import java.util.Scanner;
import java.io.PrintWriter;

public class EBusVideoSystem {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();
        int w = in.nextInt();

        in.nextLine();

        long[] a = new long[n];

        for(int i=0; i<n; i++){
            a[i] = in.nextLong();
        }

        Long relMin = 0l;
        Long relMax = 0l;
        Long relPassangers = 0L;
        for(int i=0; i<n; i++){
//            System.out.println("relMin: " + relMin +", relMax: " + relMax);
            relPassangers+=a[i];
            relMin = Math.min(relMin, relPassangers);
            relMax = Math.max(relMax, relPassangers);
        }

//        System.out.println("final relMin: " +relMin + ", final relMax: " + relMax);

        //check if relMin and relMax "diff" is between 0 and w
        boolean posMinPosMax = relMax >= 0l && relMin >= 0l;
        boolean negMinPosMax = relMin < 0l && relMax >= 0l;
        boolean negMinNegMax = relMin < 0l && relMax < 0l;

        long diff;
        if(posMinPosMax)
            diff = relMax - relMin;
        else if(negMinPosMax)
            diff = relMax - relMin;
        else
            diff = Math.abs(relMin) - Math.abs(relMax);


        if(diff < 0 || diff > w){
            out.println(0);
            return;
        }

        //check possibilities
        int MAX = w;
        int MIN = 0;

        int ans = 1;

        ans+= (MAX-relMax);
        ans+= (relMin-MIN);

        out.println(ans);
    }
}
