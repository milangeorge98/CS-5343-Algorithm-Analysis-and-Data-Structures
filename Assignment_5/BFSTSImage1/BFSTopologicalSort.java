import java.util.*;

public class BFSTopologicalSort {
    static class Graph {
        int vertices;
        List<Integer> adjVertices[];

        public Graph(int vertices) {
            this.vertices = vertices;
            adjVertices = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++)
                adjVertices[i] = new ArrayList<Integer>();
        }

        public void addPath( int u, int v) {
            adjVertices[u].add(v);
        }

        public void BFStopologicalSort() {
            int inDegree[] = new int[vertices];

            for (int i = 0; i < vertices; i++) {
                ArrayList<Integer> tmp = (ArrayList<Integer>) adjVertices[i];
                for (int vertex : tmp) {
                    inDegree[vertex]++;
                }
            }
            Queue<Integer> queue= new LinkedList<Integer>();
            for (int i = 0; i < vertices; i++) {
                if (inDegree[i] == 0)
                    queue.add(i);
            }
            int countVisited = 0;

            Vector<Integer> BFSTS = new Vector<Integer>();
            while (!queue.isEmpty()) {

                int u = queue.poll();
                BFSTS.add(u);

                for (int vertex : adjVertices[u]) {
                    if (inDegree[vertex]-- == 0)
                        queue.add(vertex);
                }
                countVisited++;
            }

            if (countVisited != vertices) {
                System.out.println("Loop detected.");
                return;
            }

            for (int i : BFSTS) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(9);
        graph.addPath(1, 2);
        graph.addPath(1, 5);
        graph.addPath(1, 6);
        graph.addPath(2, 3);
        graph.addPath(2, 5);
        graph.addPath(2, 7);
        graph.addPath(3, 4);
        graph.addPath(4, 5);
        graph.addPath(5, 7);
        graph.addPath(5, 8);
        graph.addPath(6, 5);
        graph.addPath(6, 8);
        graph.addPath(7, 4);
        graph.addPath(7, 8);
        System.out.println("BFS Topological sort: ");
        graph.BFStopologicalSort();
    }

}