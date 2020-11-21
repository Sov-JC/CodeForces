package P1003;

import java.util.Scanner;
import java.io.PrintWriter;

public class CIntenseHeat {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(); int k = in.nextInt(); in.nextLine();
        int[] a = new int[n];

        for(int i=0; i<a.length; i++)
            a[i] = in.nextInt();

        double hiv = Double.MIN_VALUE;

        for(; k<=n; k++){
            int subSum = 0;
            for(int i=0; i<k; i++)
                subSum+=a[i];

            hiv = Math.max(hiv, ((double)subSum)/((double)k));

            int shifts = n-k;

            for(int i=1; i<=shifts; i++) {
                //some op
                int kStart = i;
                int kEnd = i+k-1;

                subSum-=a[kStart-1];
                subSum+=a[kEnd];

                double kAvgTemp = ((double)subSum)/((double)k) ;

                hiv = Math.max(hiv, kAvgTemp);
            }
        }

        out.println(hiv);
    }
}
