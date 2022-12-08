package Test13;

import java.util.ArrayList;

public class Problem02 {
    public static final int NUM_CNT = 3;
    public static int N;
    public static int T;
    public static int ans;
    public static int minGap = Integer.MAX_VALUE;
    public static int[] forArr;

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void cal(){

        int sum = 0;
        for(Integer e : answer){
            sum += e;
        }

        int gap = Math.abs(T - sum);
        if(gap == minGap){
            ans = Math.min(ans,sum);
        }
        else if(gap < minGap){
            ans = sum;
            minGap = gap;
        }


    }

    public static void choose(int curNum, int cnt){

        if(curNum == N ){
            if(cnt == NUM_CNT){
                cal();
            }
            return;
        }

        answer.add(forArr[curNum]);
        choose(curNum + 1,cnt + 1);
        answer.remove(answer.size() - 1);

        choose(curNum + 1, cnt);

    }

    public static int solution(int[] arr , int target){
        if(arr == null){
            return 0;
        }
        choose(0,0);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 15, 3, 10, 12};
        int target = 21;

        N = arr.length;
        T = target;
        forArr = arr.clone();

        choose(0,0);

        System.out.println(ans);

    }
}
