package P977;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class DDivideByThreeMultiplyByTwo {

    private Long findNextChain(Long[] nums, long num){
        boolean twoTimesExists = false;

        for(int i=0; i<nums.length && !twoTimesExists; i++)
            if(num * 2 == nums[i])
                twoTimesExists = true;


        boolean threeDivExists = false;

        for(int i=0; i<nums.length && !threeDivExists; i++)
            if((num %3 == 0) && (num/3 == nums[i]))
                threeDivExists = true;

        if(twoTimesExists)
            return 2*num;
        else if(threeDivExists)
            return num/3;
        else
            return null;
    }

    private Long[] solveForwardChain(Long[] nums, long num){

        ArrayList<Long> chain = new ArrayList<Long>();
        chain.add(num);

        Long nextChain = findNextChain(nums, num);

        while(nextChain!= null){
            chain.add(nextChain);
            nextChain = findNextChain(nums, nextChain);
        }

        Long[] ans = new Long[chain.size()];
        for(int i=0; i<ans.length; i++)
            ans[i] = chain.get(i);

        return ans;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Long nums[] = new Long[n];
        for(int i=0; i<n; i++) {
            nums[i] = in.nextLong();
        }

        for(int i=0; i<nums.length; i++){
            Long[] forwardChain = solveForwardChain(nums, nums[i]);

            //print answer
            if(forwardChain.length == n)
                for(int j=0; j<n; j++) {
                    if(j==n-1)
                        out.print(forwardChain[j]);
                    else
                        out.print(forwardChain[j] + " ");
            }
        }

    }
}
