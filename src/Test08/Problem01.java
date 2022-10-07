// Problem 01

// 문제 설명 :
// 제로상담소를 운영하고 있는 금쪽이는 최근 TV 방송 출연으로 최고의 인기를 끌고 있다.
// 금쪽이의 스케쥴을 담당하고 있는 당신은 금쪽이가 최대의 수익을 올릴 수 있도록 스케쥴을 잡아주려고 한다.
// 당신은 우선 인터넷으로 모든 예약 요청을 받아둔 후에, 상담 비용의 총 합이 최대가 되도록 약속을 확정지으려 한다.
// 수집된 예약 요청은 약속 시작 시간 start[i], 종료 시간 end[i], 그리고 상담 비용 price[i]이다.
// 시간이 겹치지 않게 예약을 확정하려 할 때, 가능한 최대의 상담 비용을 구하시오.

// 입력 설명 :
// 0 < start.length = end.length = price.length <= 10000
// 0 <= start[i] <= 10000
// start[i] < end[i] <= 10000
// 0 < price[i] <= 10000

// 매개변수 형식 :
// start = {1, 5, 10, 6, 5}
// end = {5, 6, 12, 9, 12}
// price = {10, 40, 30, 20, 50}

// 반환값 형식 :
// 아래 예약을 확정하면 최대 비용인 100이 된다.
// 1~5 (10)
// 5~6 (40)
// 6~9 (20)
// 10~12 (30)

package Test08;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem01 {
    public static List<Node> info;
    public static int[] dp;
    public static int n;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.end == o.end){ // 종료 시간이 같으면 시작 시간으로 정렬
                return this.start - o.start;
            }else{ // 종료 시간이 다른 경우 종료 시간으로 정렬
                return this.end - o.end;
            }
        }
    }

    public static int solution(int[] start, int[] end, int[] cost){

        info = IntStream.range(0,start.length)
                .boxed()
                .map(i -> new Node(start[i],end[i],cost[i]))
                .sorted()
                .collect(Collectors.toList());

        dp = new int[Arrays.stream(end).max().getAsInt() + 1]; // 0 ~ n 까지 사용할 수 있도록

        for(Node n : info){
            for(int i = n.end; i < dp.length; i ++){
                dp[i] = Math.max(dp[n.start] + n.cost, dp[i]);
                // dp[n.start] + n.cost = 현재 예약을 하는 것
                // dp[i] = 현재 예약을 하지 않는 것(기존 결정이 더 이득인 경우)
                // dp[i] = 특정 순간 얻을 수 있는 최대 cost
                // 점점 update(시간이 겹치지 않는다면)
                // end 순으로 정렬하지 않으면 dp 테이블이 업데이트 되지 않음
            }
        }

        return dp[dp.length - 1];

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] start = {1,5,10,6,5};
        int[] end = {5,6,12,9,12};
        int[] price = {10,40,30,20,50};

        System.out.println(solution(start,end,price));
        System.out.println(Arrays.toString(dp));
    }
}
