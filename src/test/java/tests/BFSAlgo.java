package tests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgo {
    
    LinkedList<Integer> siblings[];
    int vertexes;
    
    public BFSAlgo(int size){
        siblings = new LinkedList[size];
        for (int i = 0; i < size; ++i) {
            siblings[i] = new LinkedList<>();
        }
        vertexes = size;
    }
    
    public void addEdge(int siblingA, int siblingB) {
        siblings[siblingA].add(siblingB);
        siblings[siblingB].add(siblingA);
    }
    
    public void doBFS(int currentVertex) {
        LinkedList<Integer> queue = new LinkedList();
        
        queue.add(currentVertex);
        
        boolean[] visitedVertexes = new boolean[vertexes];
        visitedVertexes[currentVertex]=true;
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it 
            currentVertex = queue.poll();
            System.out.print(currentVertex+" ");

            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = siblings[currentVertex].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visitedVertexes[n])
                {
                    visitedVertexes[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // A function used by DFS 
    void DFSUtil(int currentVertex,boolean visited[])
    {
        // Mark the current node as visited and print it 
        visited[currentVertex] = true;
        System.out.print(currentVertex+" ");

        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = siblings[currentVertex].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int currentVertex)
    {
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[vertexes];

        // Call the recursive helper function to print DFS traversal 
        DFSUtil(currentVertex, visited);
    }
    
    public static void main(String[] args) {
        BFSAlgo bfs = new BFSAlgo(6);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 4);
        bfs.addEdge(3, 5);
        
        bfs.doBFS(2);
        
        bfs.DFS(2);
    }
}
