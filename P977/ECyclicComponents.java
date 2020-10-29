package P977;

import java.util.*;
import java.io.PrintWriter;

public class ECyclicComponents {


    class Edge implements Comparable<Edge>{
        public int left;
        public int right;
        boolean sortByLeftFlag;

        Edge(int left, int right, boolean leftSortFlag){
            this.left = left;
            this.right = right;
            sortByLeftFlag = leftSortFlag;
        }

        @Override
        public int compareTo(Edge e){

            if(this.left==e.left)
                return 0;
            else if(this.left < e.left)
                return sortByLeftFlag ? -1 : 1 ;
            else
                return sortByLeftFlag ? 1 : -1;
        }
    }

    public Edge[] sorted(Edge[] edges){
        Edge[] sortedEdges = new Edge[edges.length];

        for(int i=0; i<edges.length; i++){
            sortedEdges[i] = edges[i];
        }

        Arrays.sort(sortedEdges);
        return sortedEdges;
    }

    public Edge[] findEdgesLeftSorted(Edge[] leftSortedEdges){
        return null;
    }

    public Edge findEdgesRightSorted(Edge[] rightSortedEdges){



        return null;
    }

    public void solve2(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        //Edge[] edges = new Edge[n];
        Edge[] leftSortedEdges = new Edge[n];
        Edge[] rightSortedEdges = new Edge[n];

        for(int i=0; i<n; i++){
            int left = in.nextInt();
            int right = in.nextInt();

            leftSortedEdges[i] = new Edge(left, right, true);
            rightSortedEdges[i] = new Edge(left, right, false);
        }

    }

    public void solve3(int testNumber, Scanner in, PrintWriter out){
        int n = in.nextInt();
        int m = in.nextInt();
        
        HashSet<String> set = new HashSet<>();
        Edge[] edges = new Edge[m];

        
        for(int i=1; i<m; i++){
            int l = in.nextInt();
            int r = in.nextInt();

            set.add(l+" " + r);
            edges[i] = new Edge(l, r, true);
        }

        Edge edge = edges[0];
    }

    class Component{
        LinkedList<Integer>[] vertices;
        Map<Integer, Integer> map;

        Component(int n, Map<Integer, Integer> map){
            vertices = new LinkedList[n];
            this.map = map;
        }

        public void addEdge(int v1, int v2){
            int v1Map = this.map.get(v1);
            int v2Map = this.map.get(v2);
            vertices[v1Map].add(v2Map);
        }

        public boolean containsCycle(){
            boolean containsCycle=false;
            for(int i=0; i<vertices.length; i++){
                if(vertices[i].size() != 2)
                    containsCycle=true;
            }
            return containsCycle;
        }
    }

    class UGraph{
        int N;
        int[] parent;
        int[] rank;

        // 0-base
        UGraph(int n, int m){
            N = n;
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n; i++) {
                parent[i] = -1;
                rank[i] = 0;
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

        private void unionAnyTwo(int v1, int v2){
            int vl = parent[v1] == -1 ? v1 : parent[v1];
            int vr = parent[v2] == -1 ? v2 : parent[v2];
        }

        private void union(int v1, int v2){
            System.out.println("Union: " + v1 + " " + v2);
            //int v1AbsParent = findAbsParent(v1);
            //int v1AbsParent = parent[v1];
            int v1AbsParent = parent[v1] == -1 ? v1: parent[v1];

            //int v2AbsParent = findAbsParent(v2);
            //int v2AbsParent = parent[v2];
            int v2AbsParent = parent[v2] == -1 ? v2: parent[v2];

            int v1AbsParentRank = rank[v1AbsParent];
            int v2AbsParentRank = rank[v2AbsParent];

            if (v1AbsParentRank == v2AbsParentRank) {
                // Make v1 absolute parent point to v2 absolute parent.
                // Increase v2 absolute parent's rank by 1.
                parent[v1AbsParent] = v2AbsParent;
                rank[v2AbsParent] = v2AbsParentRank+1;
            }else if(v1AbsParentRank < v2AbsParentRank){
                // Make v1 absolute parent point to v2 absolute parent.
                // Leave the rank the same.
                parent[v1AbsParent] = v2AbsParent;
            }else{
                parent[v2AbsParent] = v1AbsParent;
            }
        }

        public void add(int v1, int v2){
            printParentAndRank();
            System.out.println("Add " + v1 + " " + v2);
            int v1AbsParent = findAbsParent(v1);
            System.out.println("v1AbsParent: " + v1AbsParent);
            int v2AbsParent = findAbsParent(v2);
            System.out.println("v2AbsParent: " + v2AbsParent);
            //int v1AbsParentRank = rank[v1AbsParent];
            //int v2AbsParentRank = rank[v2AbsParent];

            if(v1AbsParent == v2AbsParent){
                // do nothing
            }else{
                //different sets. Join them
               union(v1, v2);
            }
        }

        public int componentCount(){
            int count = 0;
            for(int i=0; i<N; i++){
                if(parent[i] == -1)
                    count++;
            }

            return count;
        }

//        public LinkedList<Integer> componentVertices(boolean[] visited, int v){
//            visited[v] = true;
//            LinkedList<Integer> compVertices = new LinkedList<>();
//            compVertices.add(v);
//
//            // Surrounding vertices to v, both visited and non-visited.
//            LinkedList<Integer> to = new LinkedList<>();
//
//            for(LinkedList<Integer> surrounding: directedVertices){
//                for(Integer surroundingVertex: surrounding)
//                    to.add(surroundingVertex);
//            }
//
//            if(to.size() == 0)
//                return new LinkedList<>();
//
//            for(Integer toVertex: to){
//                if(visited[toVertex] == true){
//                    //
//                }else{
//
//                    for(Integer vertex: componentVertices(visited, toVertex)){
//                        compVertices.add(vertex);
//                    }
//                }
//            }
//
//            return compVertices;
//        }

    }


    class UndGraphComponents{
        int[] parent;
        //LinkedList<Integer>[] vertices;
        //ArrayList<Component> components;
        int[] isRoot;


        LinkedList<Integer>[] directedVertices;

        UndGraphComponents(int n){
            parent = new int[n];
            directedVertices = new LinkedList[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        public void addEdge(int v1, int v2){
            int v1parentTemp = parent[v1];
            int v2parentTemp = parent[v2];

            directedVertices[v1].add(v2);
            directedVertices[v2].add(v1);
        }

        public int getDegree(int v){
            return directedVertices[v].size();
        }

        public LinkedList<Integer> dfs(int visited, int rootVertex){
            return null;
        }

        public int numComponentsWithCycles(){
            //find parent roots
            LinkedList<Integer> rootParents = new LinkedList<>();

            for(int i=0; i<parent.length; i++)
                if(parent[i] == i)
                    rootParents.add(i);

            return 0;
        }

        public int numComponentsWithCyclesOld(){
            Set<Integer> parents = new HashSet<Integer>();

            for(int i=0; i<parent.length; i++){
                parents.add(parent[i]);
            }

            LinkedList<Integer>[] components = new LinkedList[this.parent.length];

            // For each component, check that there is no cycle
            int componentsWithCycleCounter = 0;
            for(LinkedList component: components){
                boolean eachVertexIsOfDegTwo = true;
                for(Object vertex: component){
                    int v = (Integer)vertex;
                    if(getDegree(v) != 2)
                        eachVertexIsOfDegTwo = false;
                }

                if(eachVertexIsOfDegTwo)
                    componentsWithCycleCounter++;
            }

            return componentsWithCycleCounter;
        }

    }

    public void solve(int testNumber, Scanner in, PrintWriter out){
        int n = in.nextInt();
        int m = in.nextInt();

        UGraph graph = new UGraph(n, m);

        for(int i=0; i<m; i++){
            int l = in.nextInt();
            int r = in.nextInt();
            graph.add(l, r);
        }

        out.println("Not CodeForces Output");
        out.println(graph.componentCount());

    }
}
