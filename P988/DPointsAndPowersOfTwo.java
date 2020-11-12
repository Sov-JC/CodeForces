package P988;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class DPointsAndPowersOfTwo {


    Long[] findNextOptions(ArrayList<Long> subSet){

    }

    ArrayList<LinkedList<Long>> findPossibleSubsets(Long[] xs, int startIndex){



        return null;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt(); in.nextLine();

        Long x[] = new Long[n];
        for(int i=0; i<n; i++){
            x[i] = in.nextLong();
        }


        int maxSubsetCount = 0;
        LinkedList<Long> maxSubset = null;
        for(int i=0; i<n; i++){
            ArrayList<LinkedList<Long>> posSubsets = findPossibleSubsets(x, i);

            for(LinkedList<Long> ll: posSubsets){
                int counter = ll.size();
                if(maxSubsetCount < counter){
                    maxSubsetCount = counter;
                    maxSubset = ll;
                }
            }
        }

        for(Long l: maxSubset)
            System.out.print(l + " ");


    }
}
