package Test07;

import java.util.HashMap;
import java.util.Set;

public class Problem02 {

    public static int getMax(int[] votes, int left, int right){

        if(right == left){
            return votes[left];
        }

        int mid = (left + right) / 2;

        left = getMax(votes,left,mid);
        right = getMax(votes,mid + 1,right);

        return left > right ? left : right;
    }


    public static int solution(int[] votes) {

        int max = getMax(votes,0,votes.length - 1);

        return max;
    }


    public static void main(String[] args) {

        int[] votes = {4,3,2,3,3,3,3,1,2,2,3};
        System.out.println(solution(votes));

        votes = new int[]{1,4,2,2,2,3,2,2,1};
        System.out.println(solution(votes));
    }
}
