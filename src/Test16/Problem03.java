package Test16;

import java.util.Arrays;

public class Problem03 {

    public static int ans = -1;

    public static int getDigitSum(int x){

        int res = 0;

        while(x > 0){
            res += x % 10;
            x = x / 10;
        }

        return res;

    }
    public static int solution(int[] nums){

        if(nums.length == 0){
            return ans;
        }
        int n = nums.length;
//        Arrays.sort(nums); // O(Nlog N)

        int j = n - 1;

        for (int i = 0; i < n ; i++) {

            while(j != 0 && getDigitSum(nums[j]) != getDigitSum(nums[i])){
                j --;
            }

            if(j <= i)
                break;

            ans = Math.max(nums[j] + nums[i], ans);
//            System.out.println(nums[i] + " " + nums[j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {18,36,72,16,52};
        System.out.println(solution(nums));
    }
}
