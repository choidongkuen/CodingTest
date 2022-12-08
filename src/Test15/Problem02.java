package Test15;

import java.util.Arrays;

public class Problem02 {
    public static final int MAX_N = 100000; // O(n)
    public static int[] dp = new int[MAX_N];

    public static int solution(int[] arr, int k){

        dp[0] = arr[0];

        for (int i = 1; i < arr.length ; i++) {

            dp[i] = Integer.MIN_VALUE;

            for (int j = 1; j <= k ; j++) {

                if(i - j >= 0){
                    dp[i] = Math.max(dp[i],dp[i - j] + arr[i]);
                }
            }
        }


        for (int i = 0; i < arr.length ; i++) {
            System.out.print(dp[i] + " ");
        }

        return dp[arr.length - 1];

    }

    public static void main(String[] args){


        int[] buckets = {1,-1,-20,4,-7,5};
        int k = 2;

        System.out.println(solution(buckets,k));
    }
}
