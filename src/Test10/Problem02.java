package Test10;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.*;
public class Problem02 {

    static class Node{
        int num; //  해당 숫자
        int cnt; // 교환 횟수

        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static final int MAX_N = 1000000;
    public static final int k = 1;

    public static int N;
    public static int result;

    public static int swap(int n, int i, int j){
        char[] numArr = String.valueOf(n).toCharArray();

        if(i == 0 && numArr[j] == '0'){
            return -1;
        }

        char tmp;
        tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;

        return Integer.parseInt(new String(numArr));
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[MAX_N][k + 1];

        q.add(new Node(N,0)); // start
        visited[N][0] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.cnt == k){
                result = Math.max(result,node.num);
                continue;
            }

            int len = String.valueOf(node.num).length();

            for (int i = 0; i < len - 1 ; i++) {
                for (int j = i + 1; j < len ; j++) {
                    int x = swap(node.num, i ,j);

                    if(x != -1 && !visited[x][node.cnt + 1]){
                        q.add(new Node(x,node.cnt + 1));
                        visited[x][node.cnt + 1] = true;
                    }
                }
            }
        }
    }

    public static int solution(int n) {
        N = n;
        result = n;
        bfs();

        return result;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }
}
