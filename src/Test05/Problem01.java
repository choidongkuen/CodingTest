// 날짜 : 2022/09/22
// 문제 : 5주차 코딩테스트 1번 문제

// 문자열 s가 있을 때, 이 문자열을 재배치하여 만든 문자열을 '애너그램'이라고 한다.
// 예를 들어, "fine"은 "infe" 의 애너그램이라고 할 수 있다.
// s가 영문 소문자로만 이루어져 있다고 할 때, 문자열 t가 문자열 s의 애너그램인지 판단하는 프로그램을 작성하시오.

// 입력설명
// 0 <= s.length <= 10000
// 0 <= t.length <= 10000

// 출력설명
// 애너그램 여부를 논리값으로 반환

// 매개변수 형식
// s = "imfinethankyou"
// t = "atfhinemnoyuki"

// 반환값 형식
// true

// 아이디어 :
// 1. 범위를 보면 길이가 0인 문자열도 가능하기 때문에, 이 상황도 고려해준다.
// 2. 두 문자열의 길이가 다른 경우도 존재하기에, 두 문자열이 다른 경우도 고려해준다.
// 3. 문자열의 길이를 보면 10000 의 길이를 가짐으로, 일일히 하나씩 비교하는 건 아니다.(10의 8승)

package Test05;

import java.util.Arrays;

class Solution01{
    public boolean solution(String s, String t){

        if(s.length() != t.length()){
            return false;
        }  // 두개의 문자열의 길이가 다른 경우

        // 두개의 문자열의 길이가 같은 경우
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length ; i++) {
            if(sChars[i] != tChars[i])
                return false;
        }
        return true;
    }
}

public class Problem01 {

    public static void main(String[] args) {

        String s = "imfinethankyou";
        String t = "atfhinemnoyuki";

        Solution01 ans = new Solution01();
        System.out.println(ans.solution(s,t));
    }
}
