package Test15;

import java.util.Arrays;

public class Problem05 {
    public static final int MAX = 100;
    public static final int STANDARD = 3;
    static int[] count = new int[4];
    // 0: 소문자 , 1: 대문자 , 2: 숫자 , 3: 특수문자

    public static boolean count(String str) {

        char[] charArr = str.toCharArray();

        for (char c : charArr) {
            if (c >= 97 && c <= 122) {
                count[0]++;
            } else if (c >= 65 && c <= 90) {
                count[1]++;
            } else if (c >= 48 && c <= 57) {
                count[2]++;
            } else{
                count[3] ++;
            }
        }
        for(int ele : count){
            if(ele == 0) {
                return false;
            }
        }

        return true;

    }
    public static boolean checkTriple(String str){

        for (int i = 0; i <= str.length() - STANDARD ; i++) {

            int cnt = 0;
            char c = str.charAt(i);

            for (int j = i; j < i + STANDARD ; j++) {
                if(c == str.charAt(j)){
                    cnt ++;
                }
            }

            if(cnt == STANDARD){
                return false;
            }
        }
        return true;
    }
    public static boolean checkConsequence(String str){

        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) >= 97 && str.charAt(i) <= 122
            || str.charAt(i) >= 48 && str.charAt(i) <= 57){

                if(i + 2 < str.length() && (str.charAt(i) + str.charAt(i + 2)) / 2 == str.charAt(i + 1)){
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean solution(String str) {


        // 길이 체크
        if (str.length() < 6 || str.length() > 20) {
            return false;
        }

        // 겟수 체크 (하나씩 있는지)
        if(!count(str)){
            return false;
        }


        // 동일한 세개의 문자 있는지 확인
        if(!checkTriple(str)){
            return false;
        }

        str = str.toLowerCase();


        if(!checkConsequence(str)){
            return false;
        }

        return true;

    }

    public static void main(String[] args) {

//        String s = "zeRobAsE!2#4";
//        String s = "aaabbbb";
        String s = "aacc!";
        System.out.println(solution(s));
    }
}
