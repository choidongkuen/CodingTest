// 문제
// 개발자로 이름을 날리던 당신은, 제로초등학교의 일일 직업 체험 강사로 섭외되었다.
// 일일 수업을 무사히 마치고, 학생들에게 퀴즈를 풀게 하여 각 학생의 점수를 scores[i]에 기록하였다.
// 학생들을 인덱스 순서대로 일렬로 세워둔 후, 학생의 점수에 따라 초코렛을 나눠주려 한다.
// 예산이 부족한 바람에 초코렛을 최대한 아껴야 하지만, 아래 조건을 만족하게끔 초코렛을 나눠주어야 한다.

// 최소 1개 이상의 초코렛은 각 학생에게 나누어 주어야 한다.
// 바로 인접한 친구보다 점수가 높다면, 더 많은 초코렛을 받아야 한다.
// 위 조건을 만족하면서 최소로 초코렛을 나누어 줄 때, 각 학생이 받는 초코렛의 개수를 출력하시오.

// 입력설명
// 0 < scores.length <= 1000000
// 출력설명
// 각 학생이 받게 되는 초코렛의 개수를 정수 배열로 반환

// 매개변수 형식
// scores = {1, 3, 5, 4, 5, 5, 5, 1}

// 반환값 형식
// {1, 2, 3, 1, 2, 1, 2, 1}

// 아이디어 :
// 왼쪽에서 한번, 오른쪽에서 한번

// 알고리즘 :
// Greedy


package Test06;
import java.util.Arrays;

class Solution05 {

    public int[] solution(int[] scores){
        int[] chocos = new int[scores.length];
        Arrays.fill(chocos,1);

        for(int i = 0; i < scores.length - 1; i++){
            if(scores[i + 1] > scores[i])
                chocos[i + 1] = chocos[i] + 1;
        } // 왼쪽 원소랑 비교


        for(int i = scores.length - 2; i >= 0 ; i --){
            if(scores[i + 1] < scores[i])
                chocos[i] = Math.max(chocos[i + 1] + 1, chocos[i]);
        } // 오른쪽 원소랑 비교

        return chocos;
    }
}
public class Problem05{
    public static void main(String[] args) {

        int[] scores = {1,3,5,4,5,5,5,1};
        System.out.println(Arrays.toString(new Solution05().solution(scores)));
    }
}