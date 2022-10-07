package Test08;

import java.util.Arrays;

public class Problem03 {

    public static int solution(int n, int[] rewards){

        int answer = 0;
        int[] dpInclude = new int[n];
        int[] dpExclude = new int[n];

        dpInclude[0] = dpInclude[1] = rewards[0];
        dpExclude[1] = rewards[1];

        for (int i = 2; i < n ; i++) {
            dpInclude[i] = Math.max(dpInclude[i - 1], rewards[i] + dpInclude[i - 2]);
            dpExclude[i] = Math.max(dpExclude[i - 1], rewards[i] + dpExclude[i - 2]);
        }

        return Math.max(dpInclude[n - 2],dpExclude[n - 1]);
    }

    public static void main(String[] args) {
        int[] rewards = {5,10,5,7,5,9};
        int n = 6;

        System.out.println(solution(n,rewards));

    }
}
