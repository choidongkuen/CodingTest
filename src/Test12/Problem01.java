// 문제 : 문자열 구현하기 문제

// 문제 설명 :
// 문자열에 적용할 수 있는 연산을 아래와 같이 정의하자.
// 문자열에서 모든 'a' 문자의 위치를 찾는다.
// 'a' 문자가 연속으로 나타날 경우, 'a'를 한 개로 바꾼다.
// 'a' 문자가 단독으로 나타날 경우, 왼쪽 문자와 오른쪽 문자를 'a'로 바꾼다.
// 예를 들면, "abcabcaaa"에 위 연산을 적용하면 "aaaaaca"가 된다.
// 문자열 s가 주어졌을 때, 이 문자열이 "a"가 될 때 까지 위 연산을 몇 번 적용해야 하는지 계산하는 함수를 구현하시오.

// 입력설명
// 0 < s.length <= 10000

// 매개변수 형식
// s = "azbacefbaaaa"

// 반환값 형식
// 5

// 예시 입출력 설명
// 아래와 같은 과정을 거쳐서 "a"가 된다.
// "azbacefbaaaa" -> "aaaaaefba" -> "aefaa" -> "aafa" -> "aaa" -> "a"

package Test12;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 이 문제는, 기능의 구현을 정확하고 빠르게 할 수 있는지를 묻는 문제입니다.
 * a가 연속으로 나타날 때와 a가 하나씩 나타날 때를 인식하고, 경우에 따라 정확한 기능을 구현합니다.
 * a가 연속으로 나타난 것을 처리하면 계속해서 길이가 달라지므로, a가 하나씩 나온 것을 먼저 처리하는 것이 좋습니다.
 * 단, a가 하나씩 나온 것을 처리한 후에 연속된 a를 찾으려 하면 답이 틀린다는 점을 꼭 이해해 주세요.
 */

class Solution {
    public int solution(String s) {
        int count = 0;
        List<Character> chars = s.chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toList());

        // 'a'일 떄 까지 반복합니다.
        while (!(chars.size() == 1 && chars.get(0) == 'a')) {
            count++;

            // a가 연속해서 나오면 시작/끝 인덱스를 기록
            // a가 하나씩 나오면 a의 위치를 기록
            List<int[]> multiA = new ArrayList<>();
            List<Integer> singleA = new ArrayList<>();

            int start = -1;
            int end = -1;
            boolean aFound = false;
            for (int i = 0; i < chars.size(); i++) {
                if (!aFound) { // a를 찾으면 시작점으로 여깁니다.
                    if (chars.get(i) == 'a') {
                        aFound = true;
                        start = i;
                        if (i == chars.size() - 1) { // 단, 마지막 자리에서 시작하면 단일 a입니다.
                            singleA.add(start);
                            aFound = false;
                        }
                    }
                } else { // aFound == true

                    if (chars.get(i) != 'a') {
                        end = i - 1;
                        if (start == end) { // 시작과 끝이 같으면 단일 a로 취급
                            singleA.add(start);
                        } else { // 시작과 끝이 다르면 연속된 a로 취급
                            multiA.add(new int[]{start, end});
                        }
                        aFound = false;
                    } else if (i == chars.size() - 1) { // 마지막까지 a가 있는 경우에도 꼼꼼하게 처리
                        end = i;
                        multiA.add(new int[]{start, end});
                        aFound = false;
                    }
                }
            }

            // 단일 a 양옆을 a로 바꿔줍니다.
            for (int i: singleA) {
                if ((i+1) < chars.size()) {
                    chars.set(i+1, 'a');
                }
                if (i-1 >= 0) {
                    chars.set(i-1, 'a');
                }
            }

            List<Character> newChars = new ArrayList<>();
            int lastEnd = -1;
            for (int[] ints: multiA) {
                start = ints[0];
                end = ints[1];

                newChars.addAll(chars.subList(lastEnd+1, start)); // 연속된 a가 나타나기 전까지 문자열 삽입
                newChars.add('a'); // 여러개의 a를 (start ~ end 구간) 하나의 a로 변경
                lastEnd = end;
            }
            newChars.addAll(chars.subList(lastEnd+1, chars.size()));
            chars = newChars;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        String s = "azbacefbaaaa";
        System.out.println(new Solution().solution(s));
    }
}




//
//
//
//public class Problem01 {
//
//    public static final int MAX = 10000;
//
//    public static int cnt; // 결과
//
//    public static boolean allA(String s){
//        for (int i = 0; i < s.length() ; i++) {
//
//            if(s.charAt(i) != 'a')
//                return false;
//        }
//        return true;
//    }
//
//    public static String makeConvertedString(String s){
//
//        s = s.replaceAll("a{2,}","a");
//
//        char[] charArr = s.toCharArray();
//
//        for (int i = 0; i < charArr.length ; i++) {
//
//            if(charArr[i] == 'a'){
//                if(i == 0){
//                    charArr[i + 1] = 'a';
//                     i += 2;
//                }else if(i == charArr.length - 1){
//                    charArr[i - 1] = 'a';
//                }else{
//                    charArr[i - 1] = 'a';
//                    charArr[i + 1] = 'a';
//                    i += 2;
//                }
//            }
//        }
//
//        return charArr.toString();
//    }
//
//    public static int solution(String s) {
//
//        String str = s;
//
//        while(true){
//
//            String convertedString = makeConvertedString(s);
//            str = convertedString;
//            if(str.length() == 0)
//                break;
//            cnt++;
//        }
//
//        return cnt;
//    }
//
//    public static void main(String[] args) {
//        String s = "azbacefbaaaa";
//        System.out.println(solution(s));
//    }
//}

