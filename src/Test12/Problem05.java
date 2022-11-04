package Test12;

import java.util.LinkedList;
import java.util.Queue;

public class Problem05{
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int MAX = 1000;
    public static final int DIR = 4;

    public static boolean[][] visited = new boolean[MAX][MAX];
    public static int[][] shortest = new int[MAX][MAX];
    public static int[][] maze;
    public static Queue<Point> q = new LinkedList<>();

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static int n,m;
    public static int ans = Integer.MAX_VALUE;

    public  boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public  boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y] && maze[x][y] != 1;

    }

    public void bfs(int x, int y){
        q.add(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){

            Point curP = q.poll();
            for (int i = 0; i < DIR ; i++) {
                int nextX = curP.x + dx[i];
                int nextY = curP.y + dy[i];

                if(canGo(nextX,nextY)){
                    q.add(new Point(nextX,nextY));
                    visited[nextX][nextY] = true;
                    shortest[nextX][nextY] = shortest[curP.x][curP.y] + 1;
                }
            }
        }
    }

    public static int solution(int n, int m, int[][] mazes){

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(mazes[i][j] == 1){
                    mazes[i][j] = 0;
                    bfs(0,0);



                }
            }
        }



    }

    public static void main(String[] args) {

        int n = 6;
        int m = 6;

        int[][] mazes = {{0,0,0,0,0,0},
                {0,1,1,1,1,0},
                {0,1,0,0,0,0},
                {1,1,0,1,0,1},
                {0,0,0,0,1,0},
                {1,1,1,0,0,0}};
        System.out.println(solution(n,m,mazes));

    }
}
