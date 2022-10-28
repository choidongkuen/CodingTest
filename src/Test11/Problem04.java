package Test11;

import java.util.Arrays;
import java.util.Collections;

public class Problem04 {
    public static final int MAX = 10000;
    public static final int MAX_N = 1000;
    public static int[] dp = new int[MAX + 1];
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static void initialize(int money){
        for (int i = 0; i <= money ; i++) {
            dp[i] = INT_MAX;
        }
        dp[0] = 0;
    }

    public static int solution(int money, int[] chips) {


        initialize(money);

        for (int i = 1; i <= money ; i++) {
            for (int j = 0; j < chips.length ; j++) {
                if(i >= chips[j]){
                    if(dp[i - chips[j]] == INT_MAX)
                        continue;
                    dp[i] = Math.min(dp[i],dp[i - chips[j]] + 1);
                }
            }
        }
        return dp[money];
    }

    public static void main(String[] args) {
        int money = 3000;
        int[] chips = {1100,500,200,150,25};
        System.out.println(solution(money,chips));

    }
}
