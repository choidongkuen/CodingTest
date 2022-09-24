import java.util.*;
// 완전 탐색으로 풀기에는 O(N^2) 걸린다.
// 투포인터로 풀자!

public class Main {
    public static final int MAX_N = 100000; // 10의 5승
    public static final int MAX_S = 100000000; // 10의 8승
    public static int[] arr = new int[MAX_N];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 원소 갯수
        int s = sc.nextInt(); // 기준이 되는 값

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int p1 = 0;
        int p2 = 0;
        int sum = arr[0];
        int maxLen = n;

        boolean canMake = false;

        while(p1 <= p2 && p2 < n){

            if(sum >= s){
                maxLen = Math.min(maxLen,p2 - p1 + 1);
                sum -= arr[p1 ++];
                canMake = true;
            }else{
                p2++;
                sum += arr[p2];
            }
        }
        if(!canMake)
            System.out.println(0);
        else
            System.out.println(maxLen);
    }
}

