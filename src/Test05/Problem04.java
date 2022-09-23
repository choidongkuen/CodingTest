// 호그와트에서 교수로 재직중인 헤르미온느는, 항상 극한의 효율을 추구하여 수업에 쓰일 교보재를 준비한다.
// 이번 수업에 필요한 물건은 총 N개의 나뭇가지로, 헤르미온느는 이미 가지고 있는 나뭇가지를 이용해서 교보재를 준비하려 한다.
// 이미 가지고 있는 나뭇가지의 길이는 branches 배열에 각각 저장되어 있으며, 이것을 잘라서 교보재용 나뭇가지로 만들 수 있다.
// 예를 들어, 길이가 120인 나뭇가지로 길이가 50인 교보재용 나뭇가지는 총 2개 만들 수 있다.
// 모든 교보재용 나뭇가지를 동일한 길이로 만들고자 할 때, 교보재용 나뭇가지의 최대 길이를 구하시오.
// 단, N개의 나뭇가지를 만들 수 없는 경우 -1을 출력하시오.

// 입력설명
// 0 < N <= 10000000
// 0 < branches.length <= 10000
// 0 < branches[i] <= 1000000

// 출력설명
// 교보재용 나뭇가지의 최대 길이를 정수로 반환

// 매개변수 형식
// N = 10
// branches = [6, 7, 10, 16, 12]

// 반환값 형식
// 4


// 아이디어
// 1. branch 의 길이의 범위가 매우 넒음
// 2. 특정 길이로 몇개 나오는지 비교해볼까? (n개 이상이 나와야 함)
// ex) 10으로 되면 11확인하고 11되면 12확인하고... but 1000000개를 다 체크하는 것은 너무 오래걸림
// 3. 결론 : 이분 탐색
// ex) 길이가 x 일때, n개를 만들 수 있다는 것은 x보다 짧은 길이들로 무조건 n개 이상 만들 수 있다. x 보다 큰 길이를 확인해보자!! left = x + 1
// ex) 반대로 x 일때, n개를 만들 수 없다는 것은 x보다 큰 길이들로 만들 수 없다. right = x - 1

package Test05;

import java.util.Arrays;

class Solution04{

    public int solution(int N, int[] branches){

        int left = 1;
        int right = Arrays.stream(branches).max().getAsInt();
        int best = -1; // 없으면 best 값 업데이트 x

        while(left <= right){

            int mid = left + (right - left) / 2;

            int total = 0;

            for(int i = branches.length - 1; i >= 0; i--){
                total += branches[i] / mid;
                if(total >= N)
                    break;
            }

            if(total >= N){ // 이것이 최대길이
                best = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return best;
    }
}

public class Problem04 {
    public static void main(String[] args) {


    }
}
