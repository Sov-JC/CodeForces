package P988;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class CEqualSums {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Map<Integer, Integer> map = new HashMap<>();

        int k = in.nextInt(); in.nextLine();
        ArrayList<Integer>[] sequences = new ArrayList[k];
        int[] sum = new int[k];

        for(int i=0; i<k; i++){
            int seqLength = in.nextInt(); in.nextLine();
            sequences[i] = new ArrayList<>();
            for(int j=0; j<seqLength; j++){
                sequences[i].add(in.nextInt());
            }
             in.nextLine();
        }

        for(int i=0; i<k; i++){
            int totalSum = 0;
            for(Integer seqNum: sequences[i])
                totalSum += seqNum;

            sum[i] = totalSum;
        }

        for(int i=0; i<sequences.length; i++){
            for(int j=0; j<sequences[i].size(); j++){
                int removalOfOneSum = sum[i] - sequences[i].get(j);

                if(map.containsKey(removalOfOneSum)){
                    int sOne = i;
                    int sTwo = map.get(removalOfOneSum);

                    if(sOne == sTwo)
                        continue;

                    int sOneIndex = j;
                    int sTwoIndex = Integer.MIN_VALUE;

                    int sTwoIndexToRemove = -1;
                    for(int x=0; x<sequences[sTwo].size(); x++){
                        int sTwoNumToRemove = sum[sTwo] - removalOfOneSum;
                        if(sequences[sTwo].get(x) == sTwoNumToRemove ) {
                            sTwoIndex = x;
                        }
                    }

                    out.println("YES");
                    out.println(sOne+1 + " " + (sOneIndex+1));
                    out.println(sTwo+1 + " " + (sTwoIndex+1));
                    return;
                }else {
                    map.put(removalOfOneSum, i);
                }
            }
        }

        out.println("NO");
    }
}
