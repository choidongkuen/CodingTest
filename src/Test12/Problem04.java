package Test12;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem04 {

    public static final int MAX = 10000;
    public static ArrayList<Integer> result = new ArrayList<>();


    public static void insert(int[] window, int val){

        int i = 0;

        while(i < window.length - 1 && val > window[i]){
            ++i;
        }
        int j = window.length - 1;

        while(j > i) {
            window[j] = window[--j];
        }
        window[j] = val;
    }

    public static void remove(int[] window, int val){


        int i = 0;

        while(i < window.length && val != window[i]){
            ++i;
        }
        while(i < window.length - 1){
            window[i] = window[ ++ i];
        }
    }



    public static int[] solution(int[] arr, int k){

        if(k == 0)
            return null;
        int[] ans = new int[arr.length - k + 1];
        int[] window = new int[k];

        for (int i = 0; i < k ; i++) {
            window[i] = arr[i];
        }

        Arrays.sort(window);

        for (int i = k; i <= arr.length ; ++i) {
            ans[i - k] = (window[k / 2] + window[(k - 1) / 2]) / 2;
            if(i == arr.length)
                break;
            remove(window,arr[i - k]);
            insert(window,arr[i]);
        }

        return ans;

    }

    public static void main(String[] args) {

        int[] arr = {4,2,6,4,2,3};
        int k = 3;
        System.out.println(Arrays.toString(solution(arr,k)));
    }
}
