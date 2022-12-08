package Test16;


import java.util.*;

public class Problem01{

    public static int[] solution(int[] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            int count = map.get(key);

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(key);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) {
            if (bucket[i] == null) continue;
            list.addAll(bucket[i]);
        }

        // list to array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }

        return res;

    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,3,3,3,4,4,4,4};
        int k = 3;
        int[] result = solution(nums,k);
        System.out.println(Arrays.toString(result));
    }
}