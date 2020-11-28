package P1003;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class DCoinsAndQueries {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();
        int qs = in.nextInt(); in.nextLine();
        int[] query = new int[qs];

        Integer[] a = new Integer[n];

        Integer[] counter = new Integer[31];
        Arrays.fill(counter, 0);

        for(int i=0; i<n; i++)
            a[i] = in.nextInt();

        in.nextLine();

        for(int i=0; i<qs; i++){
            query[i] = Integer.parseInt(in.nextLine());
        }

        for (int power = 30; power >= 0; power--) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == Math.pow(2, power)) {
                    counter[power]++;
                }
            }
        }

        for (Integer q : query) {
            int coinsCounter = 0;

            boolean answerExists = false;

            for (int power = 30; power >= 0 && !answerExists; power--) {
                int twoD = (int)Math.pow(2, power);
                int twoDSum = counter[power] * twoD;

                if (q > twoDSum) {
                    int coinsToAdd = counter[power];
                    coinsCounter += coinsToAdd;
                    q -= twoDSum;
                } else if (q % twoD == 0) {
                    coinsCounter += q / (twoD);
                    answerExists = true;
                } else {
                    int coinsToAdd = q / twoD;
                    coinsCounter += coinsToAdd;
                    q -= coinsToAdd * twoD;
                }
            }

            out.println(answerExists ? coinsCounter : "-1");
        }
    }
}
