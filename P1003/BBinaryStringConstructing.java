package P1003;

import java.util.Scanner;
import java.io.PrintWriter;

public class BBinaryStringConstructing {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int a = in.nextInt(); int b = in.nextInt(); int x = in.nextInt();
        int n = a+b;

        String str = "";

        if(n==2){
            str = "01";
            a--;
            b--;
            for(int i=0; i<a; a++) str="0"+str;
            for(int i=0; i<b; b++) str=str+"1";
        }else if(x%2 == 0){
            a=n/2;
            b=n/2;
            for(int i=0; i<a; a++) str="0"+str;
            for(int i=0; i<b; b++) str=str+"1";
        }else{
            if( a> b){
                //start with zero
                for(int i=0; i<x; i++){

                }
            }else{
                //start with one


            }
        }






    }
}
