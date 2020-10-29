package P977;

import java.util.*;
import java.io.PrintWriter;

public class ECyclicComponents {

    class UGraph{
        int N;
        int M;
        int[] parent;
        int[] rank;
        int[] refCount;

        // 0-base
        UGraph(int n, int m){
            this.N = n;
            this.M = m;
            parent = new int[n];
            rank = new int[n];
            refCount = new int[n];

            for(int i=0; i<n; i++) {
                parent[i] = -1;
                rank[i] = 0;
                refCount[i] = 0;
            }

        }

        public void printParentAndRank(){
            System.out.print("         ");
            for(int i=0; i<10; i++){
                System.out.print(i +"  ");
            }
            System.out.println();
            System.out.print("parent: ");
            for(int i=0; i<N; i++) {
                if(parent[i] == -1)
                    System.out.print(parent[i] + " ");
                else
                    System.out.print(" " + parent[i] + " ");
            }
            System.out.println();
            System.out.print("rank  : ");
            for(int i=0; i<N; i++) {
                if(rank[i] == -1)
                    System.out.print(rank[i] + " ");
                else
                    System.out.print(" " + rank[i] + " ");
            }
            System.out.println();
        }

        public int findAbsParent(int v){
            if(parent[v]==-1)
                return v;
            else {
                parent[v] = findAbsParent(parent[v]);
                return parent[v];
            }
        }

        private void union(int v1, int v2){
            int v1AbsParent = parent[v1] == -1 ? v1: parent[v1];
            int v2AbsParent = parent[v2] == -1 ? v2: parent[v2];

            int v1AbsParentRank = rank[v1AbsParent];
            int v2AbsParentRank = rank[v2AbsParent];

            if (v1AbsParentRank == v2AbsParentRank) {
                parent[v1AbsParent] = v2AbsParent;
                rank[v2AbsParent] = v2AbsParentRank+1;
            }else if(v1AbsParentRank < v2AbsParentRank){
                parent[v1AbsParent] = v2AbsParent;
            }else{
                parent[v2AbsParent] = v1AbsParent;
            }
        }

        public void add(int v1, int v2){
            refCount[v1]++;
            refCount[v2]++;
            int v1AbsParent = findAbsParent(v1);
            int v2AbsParent = findAbsParent(v2);

            if(v1AbsParent != v2AbsParent)
                union(v1, v2);
        }

        public int getDegree(int v){
            return refCount[v];
        }

        public int componentCount(){
            int count = 0;
            for(int i=0; i<N; i++)
                if(parent[i] == -1)
                    count++;

            return count;
        }
    }

    public int numComponentsWithOuterCycle(UGraph graph){
        Set<Integer> invalidComponents = new HashSet<>();

        int degree;
        for(int i=0; i<graph.N; i++){
            degree = graph.getDegree(i);
            if(degree != 2){
                int absParent = graph.findAbsParent(i);
                invalidComponents.add(absParent);
            }
        }

        return graph.componentCount() - invalidComponents.size();
    }

    public void solve(int testNumber, Scanner in, PrintWriter out){
        int n = in.nextInt();
        int m = in.nextInt();

        UGraph graph = new UGraph(n, m);

        for(int i=0; i<m; i++){
            int l = in.nextInt();
            int r = in.nextInt();
            graph.add(l-1, r-1);
        }

        out.println(numComponentsWithOuterCycle(graph));
    }
}
