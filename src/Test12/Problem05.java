package Test12;

import java.util.LinkedList;
import java.util.Queue;

public class Problem05{

    public static int solution(int n, int m, int[][] mazes){
        return 0;
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
