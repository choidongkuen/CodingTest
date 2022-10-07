// problem 02

// 문제 설명 :
// 누리는 개발 공부를 하다 보니 삽으로 땅을 파는 데에 전문가가 되었다. 누리가 파내는 땅은 블록 형태로 구분되어있고, 각 블록은 제거하는 데에 서로 다른 에너지가 소비된다.
// 땅에 있는 첫 번째 블록은 깊이가 0부터 시작하며, 한칸씩 내려갈 때 마다 깊이가 1씩 증가한다. 누리가 블록을 제거할 수 있는 조건은 아래와 같다.
// 깊이 0에 위치한 블록은 자유롭게 제거할 수 있다.
// 깊이 d에 위치한 i번째 블록을 제거하려면, 깊이 d-1에 위치한 i-1, i, i+1번째 블록 중 하나가 제거되어 있어야 한다.
// 누리는 깊이 depth의 n번째 블록에 위치한 화석을 발굴하려고 한다. 각 깊이별 블록을 제거하는 데에 필요한 에너지는 blocks에 저장되어 있다.
// 화석이 위치한 블록을 제거하는 데에 필요한 최소의 에너지를 구하시오. (단, n은 0부터 시작하며, 모든 깊이에는 동일한 숫자의 블록이 있다.)

// 입력 설명 :
//0 <= depth <= 10000
//0 <= n < blocks[i].length
//0 < blocks[i].length <= 10000
//0 < blocks[i][j] <= 100

// 매개변수 형식 :
// depth = 3
// n = 3
// blocks = {{5, 6, 2, 6},{1, 6, 4, 9},{5, 6, 9, 4},{55, 14, 21, 14}}

// 반환값 형식 :
// 24

// 점수 : 16점
package Test08;

import java.util.Arrays;

public class Problem02{
    public static final int MAX_DEPTH = 10000;
    public static final int DIR = 3;

    public static int N; // 행
    public static int M; // 열
    public static int[][] dp;

    public static int[] dx = {-1,-1,-1};
    public static int[] dy = {-1,0,1};

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static int solution(int depth, int n, int[][] blocks){

        N = depth + 1; // 3 + 1
        M = blocks[0].length; // 4
        dp = new int[N][M];

        for(int[] sub : dp){
            Arrays.fill(sub, Integer.MAX_VALUE);
        }

        for (int i = 0; i < M ; i++) {
            dp[0][i] = blocks[0][i];
        }

        for (int i = 1; i < N ; i++) {
            for (int j = 0; j < M ; j++) {

                for (int d = 0; d < DIR ; d++) {
                    int preX = i + dx[d];
                    int preY = j + dy[d];

                    if(checkRange(preX,preY)){
                        dp[i][j] = Math.min(dp[i][j],dp[preX][preY]);
                    }
                }

                dp[i][j] += blocks[i][j];
            }
        }

        return dp[depth][n];

    }

    public static void main(String[] args) {

        int[][] blocks = {{5,6,2,6},{1,6,4,9},{5,6,9,4},{55,14,21,14}};
        int depth = 3;
        int n = 3;

        System.out.println(solution(depth,n,blocks));
        System.out.println(Arrays.deepToString(dp));

    }
}