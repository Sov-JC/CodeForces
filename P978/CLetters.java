package P978;

import java.util.Scanner;
import java.io.PrintWriter;

public class CLetters {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt(); in.nextLine();

        Long[] a = new Long[n];
        Long[] adp = new Long[n];
        Long[] letterNums = new Long[m];

        for(int i=0; i<n; i++){
            a[i] = in.nextLong();
        }
        in.nextLine();
        for(int i=0; i<m; i++){
            letterNums[i] = in.nextLong();
        }

        adp[0] = a[0];

        for(int i=1; i<n; i++)
            adp[i] = adp[i-1] + a[i];

        int currDorm = 0; //base-0
        long sum = 1L;
        Long currRoom = 1L; //base-1
        for(int i=0; i<letterNums.length; i++){
            long lNum = letterNums[i];
            long roomsToVisit = lNum - sum;
            long roomsInCurrentDorm = a[currDorm];
            long roomsLeftInCurrentDorm = roomsInCurrentDorm-currRoom;

            while(roomsToVisit > 0L){
                if(roomsToVisit <= roomsLeftInCurrentDorm){
                    // Letter is in this dorm. Stay in this storm.
                    sum+=roomsToVisit;
                    currRoom = currRoom+roomsToVisit;
                    roomsToVisit = 0L;
                }else{
                    // Letter is not in this dorm. Move over one dorm.
                    currDorm++;
                    sum += (roomsLeftInCurrentDorm+1L);
                    roomsToVisit = lNum-sum;
                    roomsInCurrentDorm = a[currDorm];
                    currRoom = 1L;
                    roomsLeftInCurrentDorm = roomsInCurrentDorm-currRoom;
                }
            }

            out.println( (currDorm+1) + " " + currRoom);
        }

    }
}
