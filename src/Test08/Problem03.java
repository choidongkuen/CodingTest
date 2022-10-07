// Problem 03
// 문제 설명 :
// 당신은 제로국으로 급파된 암살자로, 제로국의 주요 인사들을 암살하는 임무를 맡았다.
// 제로국에는 총 N개의 성이 있고 이 성들은 일정한 가격으로 원형으로 배치되어 있다.
// 당신은 조사원들을 통해서 다음과 같은 사실을 알아내었다.
// 각 성마다 주요 인사는 한 명씩 배치되어 있다.
// 각 성의 주요 인사를 암살했을 때의 보상은 rewards[i]로 주어진다.
// 하나의 성의 주요 인사를 암살할 경우, 인접한 성은 경계태세가 되어 침입할 수 없다.
// 위 조건에서 달성할 수 있는 최대의 보상을 구하시오.
// 단, 원형 배치의 특성상 첫 번째 성은 마지막 성과 인접해 있다. < 핵심 >

// 입력 설명 :
// 0 < N <= 1000
// 0 < rewards[i] <= 100

// 매개변수 형식 :
// N = 6
// rewards = {5, 10, 5, 7, 5, 9}

// 반환값 형식 :
// 26

// 아이디어 :
// 개미전사 문제에 응용 ver
// 원형이기에 조금 까다로운 유형이다.



package Test08;
public class Problem03 {

    public static int solution(int n, int[] rewards) {

        /*
        int answer = 0;
        int[] dpInclude = new int[n]; // 0번째를 선택하는 경우(마지막 선택 불가능)
        int[] dpExclude = new int[n]; // 0번째를 선택하지 않는 경우(마지막 선택 가능)

        dpInclude[0] = dpInclude[1] = rewards[0];
        dpExclude[1] = rewards[1];

        for (int i = 2; i < n ; i++) {
            dpInclude[i] = Math.max(dpInclude[i - 1], rewards[i] + dpInclude[i - 2]);
            dpExclude[i] = Math.max(dpExclude[i - 1], rewards[i] + dpExclude[i - 2]);
        }

        return Math.max(dpInclude[n - 2],dpExclude[n - 1]);
        */

        // case 01 : 첫 번째를 고려하는 경우 : n - 1 번째 고려할 필요 x
        int[] dp = new int[n - 1];
        dp[0] = rewards[0];
        dp[1] = Math.max(rewards[1], rewards[0]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + rewards[i]);
        }

        int result1 = dp[dp.length - 1];

        // case 02 : 첫 번째를 고려하지 않는 경우 : n - 1 번째 고려해야 함

        dp = new int[n];
        dp[0] = 0;
        dp[1] = rewards[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + rewards[i]);
        }
        int result2 = dp[dp.length - 1];

        return Math.max(result1,result2);
    }

    public static void main(String[] args) {
        int[] rewards = {5,10,5,7,5,9};
        int n = 6;

        System.out.println(solution(n,rewards));
    }
}
