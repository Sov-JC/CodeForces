package P978;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;



public class DAlmostArithmeticProgression {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] nums = new int[n];
        in.nextLine();

        ArrayList<Integer> aDiffCandidates = new ArrayList<>();
        ArrayList<Integer> bDiffCandidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        if(n<=2) {
            out.println(0);
            return;
        }



        int a = nums[0];
        int b = nums[1];

        aDiffCandidates.add(a - 1);
        aDiffCandidates.add(a);
        aDiffCandidates.add(a + 1);

        bDiffCandidates.add(b - 1);
        bDiffCandidates.add(b);
        bDiffCandidates.add(b + 1);


        int ONE_B = 1000000000;

        int minSolution = Integer.MAX_VALUE;
        for (int aCandidate : aDiffCandidates) {
            for (int bCandidate : bDiffCandidates) {
                boolean canBeSolved = true;
                int changeCounter = 0;

                if (aCandidate != nums[0]) {
                    changeCounter++;
                }if (bCandidate != nums[1]) {
                    changeCounter++;
                }

                int aStart = aCandidate;
                int bStart = bCandidate;

                int[] numsCopy = Arrays.copyOf(nums, n);

                numsCopy[0] = aStart;
                numsCopy[1] = bStart;

                int expectedDiff = bStart - aStart;

                for (int i = 2; i < n; i++) {
                    numsCopy[i] = numsCopy[i - 1] + expectedDiff;
                    int change = Math.abs(numsCopy[i] - nums[i]);

                    if (change > 1) {
                        canBeSolved = false;
                    } else {
                        changeCounter += (change);
                    }

                }

                if (canBeSolved) {
                    minSolution = Math.min(minSolution, changeCounter);
                } else {
                }
            }
        }

        if (minSolution != Integer.MAX_VALUE)
            out.println(minSolution);
        else
            out.println(-1);
    }
}




