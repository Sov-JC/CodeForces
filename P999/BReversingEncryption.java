package P999;

import java.util.Scanner;
import java.io.PrintWriter;

public class BReversingEncryption {

    private static String reverse(String str, int end){
        //[0, end]

        StringBuffer sb = new StringBuffer();

        if(end == str.length()-1) {
            sb.append(str);
            return sb.reverse().toString();
        }

        for(int i=end; i>=0; i--)
            sb.append(str.charAt(i) + "");


        String rStr = sb.toString() + str.substring(end+1, str.length());

        return rStr;
    }
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt(); in.nextLine();
        String s = in.nextLine();

        for(int i=2; i<=n; i++){
            if(s.length()%i == 0){

                s = reverse(s, i-1);
            }
        }

        out.println(s);
    }
}
