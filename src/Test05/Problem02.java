// 당신은 천재적인 두뇌를 가진 개발자끼리 겨루는 '제로 지니어스' 프로그램에 참가하게 되었다.
// '제로 지니어스' 프로그램에서는 주어진 숫자를 이어붙여 가장 큰 수를 만드는 프로그램을 작성하는 미션이 주어졌다.
// 문제의 조건은 아래와 같다.

// 0 또는 양의 정수가 numbers 배열로 주어진다.
// numbers 배열에 주어진 정수를 이어붙여 만들 수 있는 가장 큰 수를 출력한다.
// 예를 들어 주어진 정수가 {6, 10, 2}라면 {6102, 6210, 1062, 1026, 2610, 2106}를 만들 수 있고, 이중 가장 큰 수는 6210이다.

// 위 미션을 수행하여 프로그램을 작성하시오. 단, 출력 정수 값이 너무 클 것을 대비하여 문자열로 출력하시오.

// 입력설명
// 0 < numbers <= 10000
// 0 <= numbers[i] <= 10000
// 출력설명
// 구성 가능한 최대값을 문자열로 출력

// 매개변수 형식
// numbers = {3, 30, 34, 5, 9}

// 반환값 형식
// "9534330"

// 아이디어 :
// 1. 범위가 10000개 이기에, 10000개의 숫자를 순서를 바꿔가면서 배치하는 경우의 수는 10000! 이다.
// 2. 정렬을 이용하자

package Test05;

import java.util.Arrays;

class Solution03{

    public String solution(int[] numbers) { // 기본 자료형 배열
        StringBuffer sb = new StringBuffer(); // 문자열을 이어붙어야 하기 때문

        Arrays.stream(numbers)
                .boxed()
                .sorted((x,y) -> {
                    int a = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
                    int b = Integer.parseInt(String.valueOf(y) + String.valueOf(x));

                    return b - a;
                }).forEach(sb::append);


        String result = sb.toString();
        return result.charAt(0) == '0'? "0" : result;
    }
}

public class Problem02 {

    public static void main(String[] args) {
        int[] numbers1 = {3,30,34,5,9};
        int[] numbers2 = {0,0,0,0,0};
        System.out.println(new Solution03().solution(numbers1));
        System.out.println(new Solution03().solution(numbers2));
    }
}
