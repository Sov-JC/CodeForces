package P1003;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class APolycarpsPockets {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt(); in.nextLine();
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=100; i++){
            map.put(i, 0);
        }

        for(int i=0; i<n; i++){
            int key = nums[i];
            int keyVal = map.get(key);
            map.put(key, keyVal + 1);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=100; i++){
            int keyVal = map.get(i);
            max = Math.max(max, keyVal);
        }

        out.print(max);
    }
}
