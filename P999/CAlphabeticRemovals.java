package P999;

import java.util.Scanner;
import java.io.PrintWriter;

public class CAlphabeticRemovals {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt(); in.nextLine();
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder(str);

        int a  = (char)'a';
        int z  = (char)'z';


        for(int j=a; j<=z && k>0; j++){
            int deletionsLeft = k;
            int index = 0;
            for(char c: sb.toString().toCharArray()){
                if(c == (char)j){
                    sb.setCharAt(index, '@');
                    deletionsLeft--;
                }
                index++;

                if(deletionsLeft==0){
                    break;
                }
            }
            int deletionsPerformed = k - deletionsLeft;
            k = k-deletionsPerformed;

//            System.out.println("Delete " + deletionsPerformed + " letter -> " + Character.toString(j));

        }

        String ans = sb.toString();

        for(int i=0; i<ans.length(); i++){
            if((ans.charAt(i)+"").equals("@") == false)
                out.print(ans.charAt(i));
        }
    }


}
