import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// 완전 탐색으로 풀기에는 O(N^2) 걸린다.
// 투포인터로 풀자!
/*
public static HashMap<Integer,Integer> hashMap = new HashMap<>();

public int solution(int[] votes) {

        if(votes == null || votes.length == 0)
        return -1;

        int standard = votes.length / 2; // 과반수 기준
        int result = -1;

        for (int i = 0; i < votes.length; i++) {
        hashMap.put(votes[i], hashMap.getOrDefault(votes[i], 0) + 1);
        }

        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {
        if (hashMap.get(key) > standard) {
        result = key;
        break;
        }
        }
        return result;
        }

 */