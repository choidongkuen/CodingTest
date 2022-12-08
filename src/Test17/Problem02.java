package Test17;//package Test16;
//
//public class Problem02 {
//
//    public static int solution(int[] nums){
//
//        // 누적합을 구해야 한다.
//        int n = nums.length / 3;
//
//
//        // s[i] = s[i-1] + a[i]
//        // prefix 배열 구하기
//        int[] prefix = new int[nums.length];
//        prefix[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            prefix[i] = prefix[i - 1] + nums[i];
//        }
//
//        int minDiff = Integer.MAX_VALUE;
//        int sumFirst,sumSecond;
//
//
//
//
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {7,9,5,8,1,3};
//        System.out.println(solution(nums));
//    }
//}
