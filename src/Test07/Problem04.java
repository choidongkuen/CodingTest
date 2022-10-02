package Test07;

import java.util.Arrays;

public class Problem04 {
    // 최소 부분배열은 2 크기
    public static int ans = -1;


    public static int findArray(int[] arr, int left, int right){

        if(right == left)
            return arr[left] * arr[left];

        int mid = (left + right) / 2;

        int leftAns = findArray(arr,left,mid);
        int rightAns = findArray(arr,mid + 1,right);

        int r = mid, l = mid;
        int sum = arr[mid];
        int minVal = arr[mid];

        int ans = sum * sum;

        while(r < right || l > left){
            if(r == right){
                sum += arr[--l];
                if(minVal > arr[l])
                    minVal = arr[l];
            }else if(l == left){
                sum += arr[++r];
                if(minVal > arr[r])
                    minVal = arr[r];
            }else if(r != right && arr[r + 1] >= arr[l - 1]){
                sum += arr[++r];
                if(minVal > arr[r])minVal = arr[r];
            }else if(l != left && arr[l - 1] >= arr[r + 1]){
                sum += arr[--l];
                if(minVal > arr[l])
                    minVal = arr[l];
            }
            ans = Math.max(ans,(minVal) * sum);
        }

        if(leftAns > ans)
            ans = leftAns;
        if(right > ans)
            ans = rightAns;

        return ans;

    }

    public static int solution(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;

        return findArray(arr,0,arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2,5,10,9,8,5};
        System.out.println(solution(arr));
    }
}
