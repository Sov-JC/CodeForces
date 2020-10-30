package P978;

import java.util.Scanner;
import java.io.PrintWriter;

public class BFileName {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(); in.nextLine();
        String s = in.nextLine();

        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i=0; i<n; i++){
            String str = s.substring(i, i+1);
            if(str.equals("x"))
                if(count>=2) {
                    count++;
                    continue;
                }else {
                    count++;
                    sb.append(str);
                }
            else {
                count=0;
                sb.append(str);
            }
        }

        out.println(s.length() - sb.toString().length());

    }
}
