package Test12;

import java.util.Arrays;
import java.util.Stack;

public class Problem02 {


    public static int ans = 0;
    public static final int MAX = 10000;

    public static int solution(int[] h){

        Stack<Integer> s = new Stack<>();
        int[] newH = new int[h.length + 2];

        for (int i = 1; i <= h.length ; i++) {
            newH[i] = h[i - 1];
        }
//        System.out.println(Arrays.toString(newH));
//        System.exit(0);

        int n = h.length;

        s.push(0);
        for (int i = 1; i <= n + 1  ; i++) {

            while(!s.isEmpty() && newH[s.peek()] > newH[i]){
                int check = s.peek();
                s.pop();
                ans = Math.max(ans, newH[check] * (i - s.peek() - 1));
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{5,2,1,3,4,2,5};
        System.out.println(solution(heights));
    }
}
