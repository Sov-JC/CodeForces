package P1003;

import java.util.Scanner;
import java.io.PrintWriter;

public class BBinaryStringConstructing {

    public static String addCharToFirstOccurrence(String str, char add, char firstOccurrence){
        boolean addedChar = false;
        for(int j=0; j<str.length() && !addedChar; j++){
            if((str.charAt(j)+ "").equals(firstOccurrence+"")){
                String left = str.substring(0,j);
                String mid = add+"";
                String right = str.substring(j, str.length());
                str = left + mid + right;
                addedChar = true;
            }
        }

        return str;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int a = in.nextInt(); int b = in.nextInt(); int x = in.nextInt();
        int n = a+b;

        String str = "";

        if(x==1){
            str = "01";
            a--;
            b--;
            for(int i=0; i<a; i++)
                str=("0"+str);
            for(int i=0; i<b; i++)
                str=(str+"1");
        }else if(x%2 == 1){
            // x is odd
            a=a-(x/2+1);
            b=b-(x/2+1);
            for(int i=0; i<(x/2+1); i++) str=str+"01";
            for(int i=0; i<a; i++) str="0"+str;
            for(int i=0; i<b; i++) str=str+"1";
        }else{ // x is even
            if(a>=b){
                //start with a zero
                str = "";
                for(int i=0; i<(x/2); i++)
                    str+="01";
                str +="0";
                a = a - (x/2+1);
                b = b - (x/2);

                for(int i=0; i<a; i++)
                    str="0"+str;


                for(int i=0; i<b; i++){
                    str=addCharToFirstOccurrence(str, '1', '1');
                }
            }else if(a<b){
                //start with 1
                str = "";
                for(int i=0; i<(x/2); i++)
                    str+="10";

                str+="1";

                a = a - x/2;
                b = b - (x/2+1);

                for(int i=0; i<b; i++)
                    str+="1";

                for(int i=0; i<a; i++)
                    str = addCharToFirstOccurrence(str, '0', '0');
            }
        }

        out.println(str);
    } //solve
}
