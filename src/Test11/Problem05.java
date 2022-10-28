package Test11;

import java.awt.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem05 {

    static class Point1{

        int x,y;

        public Point1(int x,int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static final int MAX_N = 1000;
    public static final int MAX_M = 1000;
    public static final int DIR = 8;

    public static int n,m;
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    public static int[][] Maze;
    public static int[][] shortest = new int[MAX_N][MAX_M];
    public static Queue<Point1> q = new LinkedList<>();

    public static int[] dx = {0,-1,-1,-1,0,1,1,1};
    public static int[] dy = {1,1,0,-1,-1,-1,0,1};

    public static void step(int x, int y, int s){
        shortest[x][y] = s;
        visited[x][y] = true;
        q.add(new Point1(x,y));
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y] && Maze[x][y] == 0;
    }

    public static void bfs(){

        while(!q.isEmpty()){

            Point1 curP = q.poll();
            int currX = curP.x;
            int currY = curP.y;

            for (int i = 0; i < DIR ; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if(canGo(nextX,nextY)){ // 해당 방향으로 갈 수 있다면
                    step(nextX,nextY,shortest[currX][currY] + 1); // 해당 지점의 최단거리 + 1
                }
            }


        }
    }
    public static int solution(int N, int M, int[][] maze){
        Maze = maze;
        n = N;
        m = M;
        Point1 start = new Point1(0,0);
        step(start.x,start.y,0);
        bfs();


        return shortest[N - 1][M - 1] == 0? -1 : shortest[N - 1][M - 1];

    }

    public static void main(String[] args) {
        int n = 6;
        int m = 6;
        int[][] maze = {{0,0,0,0,0,0},
                        {0,1,1,1,1,0},
                        {0,1,0,0,0,0},
                        {1,1,0,1,0,1},
                        {0,0,0,0,1,0},
                        {1,1,1,0,0,0}};

        System.out.println(solution(n,m,maze));
    }

}
