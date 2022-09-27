import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// 완전 탐색으로 풀기에는 O(N^2) 걸린다.
// 투포인터로 풀자!

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,23,4,1};
        int[] arr2 = {1,2};

        Integer[] refArr = Arrays.stream(arr1).boxed().toArray(Integer[] :: new); // 기본형 배열 - > 참조형 배열

    }
}

