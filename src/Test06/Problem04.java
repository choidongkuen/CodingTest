// 문제

// 당신은 신호처리 전문가로, 임베디드 머신에 들어갈 알고리즘을 의뢰받았다.
// 의뢰받은 알고리즘은 '슬라이딩 윈도우 최댓값'으로, 연속된 k개의 값의 최댓값을 한칸씩 이동하면서 구하는 기법이다.
// 예를 들어, 주어진 입력이 아래와 같다고 하자.

// arr = [4, 2, 6, 4, 2, 3]

// 이 때, k=3인 슬라이딩 윈도우와 그 최댓값은 아래와 같이 계산된다.

// [4, 2, 6, 4, 2, 3]
// [4, 2, 6]           -> 6
//    [2, 6, 4]        -> 6
//       [6, 4, 2]     -> 6
//          [4, 2, 3]  -> 4

// 따라서, 주어진 입력 arr에 대한 슬라이딩 윈도우 최댓값은 아래와 같다.

// [6, 6, 6, 4]
// 이 때, 슬라이딩 윈도우 최댓값 알고리즘을 구현하시오.

// 입력설명
// 0 < len(arr) <= 100000
// 0 < k <= 10000

// 출력설명
// 슬라이딩 윈도우 최댓값이 담긴 정수 배열

// 아이디어 :
// 힙을 이용하자

// 알고리즘 :
// TwoPointer


package Test06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution04{

    public int[] solution(int[] arr, int k){

        int[] result = new int[arr.length - k + 1];
        PriorityQueue<Integer> window = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < k; i ++ ){
            window.offer(arr[i]);
        }
        result[0] = window.peek();

        for(int i = 1; i < result.length; i ++){

            window.remove(arr[i - 1]);
            window.offer(arr[i + k - 1]);
            result[i] = window.peek();
        }
        return result;
    }
}
public class Problem04 {
    public static void main(String[] args) {

        int[] arr = {4,2,6,4,2,3};
        int k = 3;
        System.out.println(Arrays.toString(new Solution04().solution(arr,k)));
    }
}
