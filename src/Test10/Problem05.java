package Test10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem05 {

    static class Node{
        int to;
        int dist;

        public Node(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    public static final int MAX_N = 1000;
    public static final int MAX_M = 10000;

    public static ArrayList<Node>[] graph = new ArrayList[MAX_N];
    public static PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
    public static int[] dist = new int[MAX_N];
    public static int v,e;
    public static int start = 0;

    public static int solution(int n, int[][] arr){

        v = n; // 정점의 개수
        e = arr.length; // 간선의 개수

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < MAX_N ; i++) {
            dist[i] = (int)1e9;
        } // dist 배열 초기화

        dist[start] = 0;
        pq.add(new Node(start,dist[start]));

        for (int i = 0; i < e ; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int z = arr[i][2];

            graph[x].add(new Node(y,z));
        }

        while(!pq.isEmpty()){

            Node currNode = pq.poll();

            int minDist = currNode.dist;
            int minIndex = currNode.to;

            for (int i = 0; i <  graph[minIndex].size() ; i++) {
                Node adjNode = graph[minIndex].get(i);

                int targetIndex = adjNode.to;
                int targetDist = adjNode.dist;

                int newDist = dist[minIndex] + targetDist;

                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Node(targetIndex,newDist));
                }
            }
        }

        int maxIndex = -1;
        int maxVal = -1;
        for(int i = 0; i < n; i++) {
            if (dist[i] > maxVal) {
                maxIndex = i;
                maxVal = dist[i];
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;

        int[][] arr = {{0,1,5},{0,2,7},{1,3,10},{3,4,8},{2,4,9},{4,2,1}};
        System.out.println(solution(n,arr));


    }
}
