// 유미는 소설 작가로, 최근 작품이 베스트셀러가 되어 큰 부를 거머쥐었다.
// 유미는 마트에서 저녁에 쓸 요리 재료를 구매하려고 한다. 필요한 요리 재료는 ingredients 배열에 정리해 두었다.
// 평소에는 무척 검소한 유미는, 처음으로 "여기서부터 저기까지 다 주세요!"라고 외치고 싶어졌다.
// 마트에 진열된 품목은 items[i]로 주어지며, 유미는 필요한 요리 재료가 모두 포함되는 가장 최소한의 구간을 선택하려고 한다.
// 이 때 유미가 구매할 구간의 길이를 출력하시오.

// 0 < ingredients.length <= 1000
// 0 < items.length <= 10000

// 출력 설명
// 조건에 맞는 가장 짧은 구간의 길이를 정수로 출력

// 매개변수 형식
// ingredients = {"생닭", "인삼", "소주", "대추"}
// items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"}

// 반환값 형식
// 7

// 아이디어 :
// ingredients,items의 영역이 매우 큼으로, 최적화 부분을 잘 고려해야 한다.
// 모든 사야할 품목이 지정한 영역에 다 들어가있나 확인하는 방법?...
// set,map 과 관련된 메소드를 이용하자!

// 알고리즘 :
// TwoPointer

package Test06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution03{

    public int solution(String[] ingredients, String[] items){

        Map<String,Integer> map = new HashMap<>();
        Set<String> ingredientsSet = Arrays.stream(ingredients).collect(Collectors.toSet());
        // 문자열 배열(ingredients)를 set으로 변경

        int left = 0, right = 0; // 시작 - 끝
        map.put(items[left],1); // item - 갯수

        int result = items.length; // 아무리 커져도 items의 길이(모든 item을 구매하는 경우)
        if(map.keySet().containsAll(ingredientsSet)) { // 잡은 구간에 구매해야 할 모든 ingredient가 들어간다면
            result = 1;
        }

        while(left <= right) {

            if (result == 1) {
                return result;
            } // 최적화

            if (map.keySet().containsAll(ingredientsSet)) {
                if (result > right - left + 1) {
                    result = right - left + 1;
                } // 최소 영역 업데이트
                // left 이동시키기 전 처리
                if (map.get(items[left]) == 1) {
                    map.remove(items[left]);
                } else { // 하나라면 제거
//                map.replace(items[left],map.get(items[left]) - 1);
                    map.put(items[left], map.get(items[left]) - 1);
                }
                left++;
            } else {
                right++; // 아직 구매할 모든 품목이 없음으로, right++

                if(right == items.length) {
                    break;
                }

                if(map.containsKey(items[right])) // right 이동 후, 해당하는 물품이 이미 있는 경우
                    map.put(items[right],map.get(items[right]) + 1);
                else{
                    map.put(items[right],1); // 해당하는 물품이 없는 경우 추가
                }
            }
        }

        return result;
    }
}

public class Problem03 {
    public static void main(String[] args) {

        String[] items = {"물","인삼","커피","생닭","소주","사탕","생닭","대추","쌀"};
        String[] ingredients = {"생닭","인삼","소주","대추"};

        Solution03 s = new Solution03();
        System.out.println(s.solution(ingredients, items));
    }
}
