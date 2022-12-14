// 정수로 이루어진 리스트 arr에서 피크의 인덱스 peak를 다음과 같이 정의하자.
// 0 < peak < arr.length - 1
// x[peak - 1] < x[peak]
// x[peak + 1] < x[peak]

// 주어진 리스트 arr 에서 피크가 최대 한 개 존재할 때, 피크의 인덱스 peak를 출력하시오.
// 단, 배열에 피크가 존재하지 않을 경우 -1을 출력하시오.

// 입력설명
// 3 < arr.length < 1000000
// i <= peak 일 경우, arr[i - 1] < arr[i]
// i >= peak 일 경우, arr[i + 1] < arr[i]
// 피크가 존재하지 않을 경우, arr 는 단조증가 또는 단조감소. 즉, 모든 i에 대해 arr[i - 1] < arr[i] 또는 모든 i에 대해 arr[i + 1] < arr[i]

// 출력 설명
// 배열의 유일한 피크값의 인덱스를 정수로 반환

// 매개변수 형식
// arr = [-3, 0, 3, 4, 5, 12, 15, 14, 12, 11]

// 반환값 형식
// 6

// 아이디어
// 1. 리스트의 길이가 광징히 크므로, 알고리즘 측면에서 설계를 잘해줘야 한다.
// 2. peak 기준 왼쪽 인덱스의 값들은 단조 증가해야 하며, peak 기준 오른쪽 인덱스의 값들은 단조 감소해야 한다.

package Test05;

import org.w3c.dom.ls.LSOutput;

class Solution02{

    public int solution(int[] arr){

        int left = 0;
        int right = arr.length - 1;

        while(left + 1 < right){ // while(left < right) 로 계산한 경우 무한 루프 발생 !

            int mid = left + (right - left) / 2; // (right + left) / 2 -> right 가 매우 크고, left 가 매우 작은 경우 오버플로 발생할 수 있으므로

            if(arr[mid + 1] < arr[mid]){
                if(arr[mid - 1] < arr[mid]){
                    return mid;
                }else{
                    right = mid;
                }
            }else{
                left = mid;
            }
        }
        return -1;
    }

}
public class Problem03 {

    public static void main(String[] args) {

        int[] arr1 = {-3, 0, 3, 4, 5, 12, 15, 14, 12, 11};
        System.out.println(new Solution02().solution(arr1));

    }
}
