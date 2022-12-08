package Test15;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Problem04 {

    public static int ans = 0;

    public static int solution(int[] numsDivide, int[] numsDivided){

        if (numsDivide == null || numsDivided == null) {
            return -1;
        }

        Integer[] newNumsDivide = Arrays.stream(numsDivide).boxed().toArray(Integer[]::new);

        // treeSet으로 항상 작은 값을 유지 -> O(log N)
        // 하나 제거 후, numsDivied에 모든 수를 나누어본다. -> O(n)
        TreeSet<Integer> numsTreeSet = new TreeSet<>(Arrays.asList(newNumsDivide));


        int loop = numsTreeSet.size();
        while(loop > 0){

            int min = numsTreeSet.first();
            int cnt = 0;

            for (int i = 0; i < numsDivided.length ; i++) {

                if(numsDivided[i] % min == 0){
                    cnt++;

                }else{
                    ans += Collections.frequency(Arrays.asList(newNumsDivide),min) ;
                    numsTreeSet.pollFirst();
                    break;
                }
            }

            if(cnt == numsDivided.length){
                return ans;
            }
            loop -= 1;

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr1=  {2,9,3,6,2,4,3};
        int[] arr2=  {9,18,27,9,15};

        System.out.println(solution(arr1,arr2));
    }
}
