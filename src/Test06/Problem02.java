// 당신은 숯불구이 전문점의 단골 손님이다. 오늘은 가게에서 특별한 이벤트를 한다고 하여, 여러 명의 친구들이 모여 방문하기로 하였다.
// 가게에서는 고기의 부위 별로 amount[i] 만큼의 분량을 준비해 두었으며, 각 부위의 가격은 단위 분량 당 value[i]원이라고 한다.
// 이벤트에 참가한 친구들이 먹을 수 있는 고기의 분량을 stomach[j]라고 하자.
// 이 때, 친구들과 섭취한 고기의 가치가 최대가 되게 했을 때 그 가치(원)을 구하시오.

// 단, 가장 가치가 높은 고기는 친구들끼리 공평하게 같은 양을 먹어야 하며, 고기의 양은 정수 단위로만 나뉘어진다.
// (정수 단위로 나누어 먹을 수 없으면, 의리를 중시하여 아무도 먹지 않는다. 즉, 1개씩 먹어도 못먹는 친구가 생긴다면 아무도 먹지 않는다.)

// 입력설명
// 0 < amount.length = value.length <= 100000
// 0 < amount[i] <= 10000
// 0 < value[i] <= 10000
// 0 < stomach.length <= 100000
// 0 < stomach[j] <= 10000

// 섭취 가능한 고기의 최대 가치를 정수로 반환

// 매개변수 형식
// amount = {7, 10, 4, 5}
// value = {5, 4, 3, 1}
// stomach = {4, 6, 2, 8}

// 반환값 형식
// 74

// 알고리즘 :
// Greedy

package Test06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Meat implements Comparable<Meat>{
    int amount;
    int value;
    Meat(int value, int amount){
        this.amount = amount;
        this.value = value;
    }
    @Override
    public int compareTo(Meat o){return this.value - o.value;} // 오름차순 정렬
}
class Solution02{
    public int solution(int[] amount, int[] values, int[] stomach){
     List<Meat> meats = IntStream.range(0,amount.length)
             .boxed()
             .map(i -> new Meat(values[i],amount[i]))
             .sorted(Comparator.reverseOrder()) // 내림차순 정렬
             .collect(Collectors.toList());

         int bestMeatComsumption =
                 Math.min(meats.get(0).amount / stomach.length,
                            Arrays.stream(stomach).min().getAsInt()) * stomach.length; // 최대 가치의 고기의 먹을 수 있는 양(인원 수 대로 나눈 양보다 못먹는 사람이 있을 수 있음)


         int totalStomach = Arrays.stream(stomach).sum() - bestMeatComsumption; // 총 먹을 수 있는 위의 크기 - 최고 가치 고기를 먹을 수 있는 크기
         int result = bestMeatComsumption * meats.get(0).value; // 먹은 고기의 가치

         for(int i = 1; i < meats.size(); i ++){

             int v = meats.get(i).value; // 해당 고기의 가치
             int a = meats.get(i).amount; // 해당 고기의 양

             int comsumption = Math.min(totalStomach, a); // 먹는 양(작은 것 기준)
             result += v * comsumption; // 먹은 가치 업데이트
             totalStomach -= comsumption; // 먹을 수 있는 양 업데이트

             if(totalStomach == 0)
                 break;
         }
         return result;
     }
}
public class Problem02 {
    public static void main(String[] args) {

        int[] amounts = {7,10,4,5};
        int[] values = {5,4,3,1};
        int[] stomach = {4,6,2,8};

        Solution02 s = new Solution02();
        System.out.println(s.solution(amounts,values,stomach));
    }
}
