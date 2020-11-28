package P1005;

import java.util.Scanner;
import java.io.PrintWriter;

public class BDeleteFromTheLeft {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String l = in.nextLine();
        String r = in.nextLine();
        l = new StringBuffer(l).reverse().toString();
        r = new StringBuffer(r).reverse().toString();

        int diffIndex = -1;
        for(int i=0; i<Math.min(l.length(), r.length()); i++){
            if(l.charAt(i) != r.charAt(i)){
                diffIndex = i;
                break;
            }
        }

        if(diffIndex == -1){
            out.println(Math.max(l.length(), r.length())-Math.min(l.length(), r.length()));
        }else{
            int removeL = l.length()-diffIndex;
            int removeR = r.length()-diffIndex;
            out.println(removeL+removeR);
        }
    }
}
