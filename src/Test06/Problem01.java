// 일원이는 큰 뜻을 품고, 주식 자동 트레이딩 프로그램을 만들어 대박을 내려고 한다.
// 자동 트레이딩을 하기 위해, 수집한 방대한 양의 주가 데이터를 분석해 가장 오랫동안 '우상향'하는 부분을 찾아내고자 한다.
// 시간순으로 나열된 주가 데이터 values 배열에서 가장 오랫동안 단조 증가가 이루어진 구간을 찾아 {시작인덱스, 끝인덱스}의 형식으로 출력하시오.
// 단, 단조 증가란 시작인덱스 <= i < 끝인덱스에서 values[i] < values[i + 1]인 경우를 말한다.
// 동일 길이의 구간이 여러번 나타날 경우, 가장 먼저 나온 구간으로 출력하시오.
// 또한, 전체 구간에서 단조 증가하는 구간이 없는 경우 {0, 0}으로 출력하시오.

// 입력설명
// 0 < values.length <= 100000

// 출력설명
// 단조 증가 구간을 길이가 2인 정수 배열로 반환

// 매개변수 형식
// values = {103, 152, 124, 165, 152, 154, 159, 160, 200, 195, 205, 206, 204, 189, 156}

// 반환값 형식
// {4, 8}

// 아이디어 :
// 1. 잡은 left ~ right 가 단조증가이면, right를 증가시킨다.(result값 업데이트)
// 2. 잡은 left ~ right 가 단조증가가 아니라면, left를 right자리로 이동시킨다.(left를 1씩 증가시켜봤자, 단조증가 아니다.)
// 3. 전형적인 투포인터 문제

// 알고리즘 :
// Two-Pointer

package Test06;

import java.util.Arrays;

class Solution01{

    // 답안
    public int[] solution01(int[] values){
        int left = 0, right = 0; // 투 포인터 잡기
        int[] result = {left,right};

        while(left <= right){
            boolean increasing = true;
            for(int i = left; i < right; i++){ // 해당 구간이 단조증가인지 확인하기
                if(values[i] >= values[i + 1]){
                    increasing = false;
                    break;
                }
            }
            if(increasing){
                if(result[1] - result[0] < right - left)
                    result = new int[]{left,right};
                right++; // 한칸 증가시켜보기
                if(right == values.length)
                    break; // 끝점이 도달한 경우 종료
            }else{ // 해당 left ~ right 가 단조증가 구간이 아닌 경우
                left = right ;
            }
        }
        return result;
    }
    // 내가 푼 방식
    public int[] solution02(int[] values){
        int maxLen = 0;
        int[] result = {0,0};

        for(int i = 0; i < values.length - 1; i ++){
            int left = i;
            int right = i + 1;

            int length = 1;
            while(right < values.length && values[right] > values[right - 1]){
                right ++;
                length ++;
            }

            if(length > maxLen){

                maxLen = length;
                result[0] = left;
                result[1] = right - 1;
            }
        }
        return result;
    }
}

public class Problem01 {
    public static void main(String[] args) {

        int[] arr = new int[]{103,152,124,165,152,154,159,160,200,195,205,206,204,189,156};
        Solution01 s = new Solution01();

        System.out.println(Arrays.toString(s.solution01(arr)));

        System.out.println(Arrays.toString(s.solution02(arr)));
    }
}
