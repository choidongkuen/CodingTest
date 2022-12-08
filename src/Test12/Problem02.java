package Test12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Problem02 {

    static class Product{
        int num;
        String name;

        public Product(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    // 자바의 Stream 구현해보기
    public static void main(String[] args) {

        // step 01 : Stream 객체 생성
        // step 02 : 가공하기(filter,map..)
        // step 03 : 결과 만들기


        long count = IntStream.of(1,3,5,7,9).count(); // 5;
//        System.out.print(count);
        long sum = IntStream.of(20,30,40,10,20).sum(); // 120
//        System.out.print(sum);

        OptionalInt min = IntStream.of(1,3,5,7,9).min(); // Optional 클래스란 NPE 를 방지하기 위한 클래스
                                                                 // NPE 가 뜰 가능성이 있는 부분을 Optionl 클래스의 객체로 생성
        DoubleStream.of(1.1,1.2,1.3,1.4)
                .average()
                .ifPresent(System.out :: println); // Optional 처리 가능 by ifPresent

        // reduce 메소드
        // Python의 reduce 랑 동일 인자로 메소드를 전달
        OptionalInt reduced = IntStream.range(10,100) // 10 ~ 99
                .reduce((a,b) -> {
                    return Integer.sum(a,b);
                });

        Scanner sc = new Scanner(System.in);
        int reducedTwoPrarams =
                IntStream.range(1,4) // [1,2,3]
                        .reduce(10,Integer :: sum); //  :: -> method reference(ex a :: b => a객체의 b메소드 호출)
//        System.out.print(reducedTwoPrarams);



        List<Product> productList =
                Arrays.asList(new Product(23, "potatoes"),
                        new Product(14, "orange"),
                        new Product(13, "lemon"),
                        new Product(23, "bread"),
                        new Product(13, "sugar"));

        // collect 메소드(feat collectors)

        // 1. collect 기본
        System.out.print(" == collect 메소드 == ");
        List<String> collectedList = productList.stream() // 스트림 생성
                .map(Product::getName) // 가공
                .collect(Collectors.toList()); // 결과 처리

        System.out.println(collectedList);
        // 2. collect.joining()
        // 작업 결과를 하나의 String으로 이어붙이기

        String listToString =
                productList.stream().map(Product::getName).collect(Collectors.joining());
        System.out.println(listToString);
        


    }
}
