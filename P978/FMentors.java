package P978;

import java.util.*;
import java.io.PrintWriter;

public class FMentors {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();
        int k = in.nextInt(); in.nextLine();

        int[] r = new int[n];

        for(int i=0; i<n; i++)
            r[i] = in.nextInt();
        in.nextLine();

        LinkedList<Integer>[] quarrels = new LinkedList[n];

        for(int i=0; i<n; i++){
            quarrels[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<k; i++){
            int left = in.nextInt()-1;
            int right = in.nextInt()-1;


            quarrels[left].add(right);
            quarrels[right].add(left);
            in.nextLine();
        }


        Map<Integer, Integer> map = new HashMap<>();

        Integer[] rCopy = new Integer[n];

        for(int i=0; i<n; i++)
            rCopy[i] = new Integer(r[i]);

        Arrays.sort(rCopy);

        { //populate map
            int key = rCopy[0];
            int count = 0;
            int previousKeyCount = 0;
            map.put(key, count);
            for (int i = 1; i < n; i++) {
                key = rCopy[i];
                count = i;
                int previousKey = rCopy[i - 1];
                if (previousKey == key) {
                    previousKeyCount++;
                    map.put(key, count - previousKeyCount);
                } else {
                    previousKeyCount = 0;
                    map.put(key, count);
                }
            }
        }

        for(int i=0; i<n; i++){
            int rank = r[i];
            int ranksLessThanCount = map.get(rank);

            int count = 0;
            for(Integer programmerInQuarrelWith: quarrels[i]){
                //find programmer in quarrel with that have a
                //rank less than programmer i's rank
                int pInQuarrelWithRank = r[programmerInQuarrelWith];

                if(pInQuarrelWithRank < rank)
                    count++;
            }

            int ranksLessThanCountNotIncludingQuarrels = ranksLessThanCount-count;
            int partialSol = ranksLessThanCountNotIncludingQuarrels;

            out.print(partialSol + " ");
        }
    }
}
