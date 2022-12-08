package Test14;

public class Problem01 {

    public static int gcd(int n,int m){


        while (m != 0)
        {
            int r = n % m;

            n = m;
            m = r;
        }

        return n;

    }


    public static int solution(int n, int m){

        int ref = gcd(n,m);

//        return ( n * m) - (((n / ref) + (m / ref) - 1) * ref);
        return n + m - 1;

    }


    public static void main(String[] args) {
        int n = 4;
        int m = 9;

        System.out.println(solution(n,m));
    }
}
