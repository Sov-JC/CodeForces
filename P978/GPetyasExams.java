package P978;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class GPetyasExams {

    public void solve(int testNumber, Scanner in, PrintWriter out){
        int n = in.nextInt(); // days
        int m = in.nextInt(); // exams

        StringBuffer ans = new StringBuffer();

        int[] s = new int[m]; // solution out
        int[] d = new int[m]; // day exam due
        int[] c = new int[m];

        for (int i = 0; i < m; i++) {
            s[i] = in.nextInt();
            d[i] = in.nextInt();
            c[i] = in.nextInt();
        }

        // For solutionMem, -1 means solutions is not out yet
        // 0 means solution is out, but person has not studied for it yet
        // some positive integer > 0 means the day the solution was studied for.
        int[] solutionMem = new int[m];
        for(int i=0; i<solutionMem.length; i++){
            solutionMem[i]  = -1;
        }

        for(int j=1 ;j<=n; j++){
            // Find the solutions that came out today
            for(int i=0; i<m; i++){
                if(s[i] == j){
                    solutionMem[i] = 0;
                }
            }

            // Check if any exams are due today
            boolean tookExamToday = false;
            for(int e=0; e<m; e++){
                if(d[e] ==j){
                    if(solutionMem[e] == 0){
                        // There is an exam today but the person has not studied for the exam.
                        System.out.println("Exam " + e + " is due today, but have not studied for it on day " + j);
                        System.out.println("Ans so far looks like: " + ans.toString().trim());
                        out.println("-1");
                        return;
                    }else{
                        // A user needs to take today's exam
                        ans.append((m+1) + " ");
                        tookExamToday = true;
                        solutionMem[e] = Integer.MAX_VALUE;
                        break;
                    }
                }
            }

            if(tookExamToday) continue;


            // Check for which exams a user can study for (base-0).
            // that he has not studied for yet.
            ArrayList<Integer> examsToStudyFor = new ArrayList<>();
            for(int i=0; i<m; i++){
                if(solutionMem[i] == 0)
                    examsToStudyFor.add(i);
            }

            // Determine which exam you should study for next.
            if(examsToStudyFor.size() != 0){
                int examToStudyForNext = examsToStudyFor.get(0);

                for(int examToStudyFor: examsToStudyFor)
                    if(d[examToStudyFor] < d[examToStudyForNext]) {
                        examToStudyForNext = examToStudyFor;
                    }

                solutionMem[examToStudyForNext] = j;


                ans.append((examToStudyForNext+1)+" ");
                continue;
            }else{
                // No exams which the user has not studied for.
                // Determine which exam the user should continue to study for
                // If none, append 0 to ans

                boolean revisitingMaterial = false;
                for(int i=0; i<m; i++){
                    if(solutionMem[i] > 0 && solutionMem[i] != Integer.MAX_VALUE) {
                        ans.append((i + 1) + " ");
                        revisitingMaterial = true;
                        break;
                    }
                }

                if(revisitingMaterial)
                    continue;
                else {
                    ans.append("0 ");
                    continue;
                }

            }

        }
        
        out.println(ans.toString().trim());
    }

}