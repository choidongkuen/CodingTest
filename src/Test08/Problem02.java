package Test08;

import java.io.IOException;
import java.util.*;

//1개의 업무가 있다면 그 업무를 하는 것이 돈을 버는 일이고 
//2개의 업무가 있다면 겹치지 않으면 2개를 하는 것이 좋고 겹친다면 더 비싼 업무를 하는 것이 좋다.
//i번째 작업을 선택하지 않거나 선택한 것 중 최대값 
//i번째 작업을 선택하는 경우에는 i번째 작업의 비용과 i번째 작업과 겹치지 않는 작업의 최대값의 합
//dp[i] = Max(dp[i-1], getMaxCost(i) + c[i])

public class Problem02{

    static class Task implements Comparable<Task> {
        int s;
        int e;
        int c;

        public Task(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Task o) {
            // TODO Auto-generated method stub
            // 우선 종료 일자 기준으로 정렬하고 종료 일자가 동일하면 시작 일자 기준으로 정렬
            if (this.e == o.e) {
                return this.s - o.s;
            } else {
                return this.e - o.e;
            }
        }
    }

    static int N;
    static int M;
    static ArrayList<Task> task;
    static int[] dp;

    public static void test(int[] start, int[] end, int[] price) {

        // N개의 업무 dp
        dp = new int[N];
        Arrays.fill(dp, 0);

        // task 를 종료일, 시작일 순서로 정렬
        task.sort(Comparator.naturalOrder());

        // 첫번째 작업의 비용
        dp[0] = task.get(0).c;

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], getMaxCost(i) + task.get(i).c);
        }

        System.out.println(dp[N - 1]);
    }

    // n번째 작업과 겹치지 않는 마지막 시점까지의 최대값 찾기
    public static int getMaxCost(int n) {

        int ret = 0;
        int idx = -1;

        // n번째 작업과 겹치지 않는 마지막 시점까지의 최대값 찾기
        for (int i = 0; i < n; i++) {
            // 겹치면 중지
            if (task.get(i).e > task.get(n).s) {
                break;
            }
            idx = i;
        }

        // 겹치지 않는 작업의 최대값
        if (idx >= 0) {
            ret = dp[idx];
        }

        return ret;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] start = {1,5,10,6,5};
        int[] end = {5,6,12,9,12};
        int[] price = {10,40,30,20,50};

        task = new ArrayList<>();
        N = start.length;

        for(int i = 0; i < start.length; i ++){
            task.add(new Task(start[i],end[i],price[i]));
        } // 인스턴스 배열 설정
        test(start, end ,price);
    }
}