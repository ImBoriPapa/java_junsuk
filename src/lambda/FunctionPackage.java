package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import java.util.function.Function;

/**
 *  java.util.function 패키지
 */
public class FunctionPackage {
    /**
     * Runnable
     * 매개변수도 없고, 반환값도 없음
     *
     */
    static Runnable runnable = () -> System.out.println("runnable = runnable");

    /**
     * Supplier<T>
     * 매개변수도 없고, 반환만 있음
     *
     */
    static Supplier<String> supplier = ()-> "String";

    /**
     * Consumer<T>
     * 매개변수만 있고 , 반환값도 없음
     *
     */
    static Consumer<String> consumer = (String a) -> System.out.println(a);

    /**
     * Predicate<T,Boolean(생략됨)>
     * 매개변수를 받아, 결과를 반환
     *
     */
    static Function<String,String> function = s -> "it is String ="+s;

    /**
     * Predicate<T,Boolean(생략됨)>
     * 조건식 매개변수를 하나 받아서 boolean 을 반환
     *
     */
    static Predicate<String> predicate = s -> s.equals("key");

    /**
     * BiConsumer<T,U>
     * 두 개의 매개변수만 있고, 반환 값이 없음
     */
    static BiConsumer<String,String> biConsumer = (a,b)-> System.out.println("String a : "+a+", String b : "+b);

    /**
     * BiPredicate<T,U>
     * 조건식 매개변수는 둘, 반환 값은 boolean
     */
    static BiPredicate<Integer,Integer> biPredicate = (a,b)-> a == b ;

    /**
     * BiFunction<T,U,R>
     * 두 개의 매개변수를 받아 하나의 결과를 반환
     */
    static BiFunction<Integer,Integer,String> biFunction = (a,b)-> a +String.valueOf(b) ;

    /**
     * UnaryOperator<T>
     * Function 의 자손 Function 과  다르게 매개변수와 결과의 타입이 같다.
     */
    static UnaryOperator<String> unaryOperator = (s) -> "String s = "+s;

    /**
     * BinaryOperator<T>
     * BiFunction 의 자손 Function 과  다르게 매개변수와 결과의 타입이 같다.
     */
    static BinaryOperator<String> binaryOperator = (a,b) -> "String a + b = "+(a+b);


    static Predicate<Integer> multiplesOf3 = s -> s%3 == 0;

    static UnaryOperator<Integer> add10 = s -> s + 10;

    static DoubleToIntFunction doubleToIntFunction = d -> (int) (d * 10);


    public static void main(String[] args) {
        runnable.run();

        System.out.println("supplier.get() = " +supplier.get());

        consumer.accept("accept = accept");

        System.out.println(function.apply("String"));

        System.out.println("is the correct password key? = "+predicate.test("key"));

        biConsumer.accept("A","B");

        System.out.println("100 == 100? ="+biPredicate.test(100, 100));

        System.out.println("Integer a -> String a + Integer b -> String b, 1000 + 100 ="+biFunction.apply(1000, 100));

        System.out.println("unaryOperator = " + unaryOperator.apply("loco"));

        System.out.println("binaryOperator = " + binaryOperator.apply("123","123"));

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<10; i++){
            arrayList.add(i);
        }
        /**
         * 2의 배수를 삭제
         */
        arrayList.removeIf(s-> s%2 == 0);
        /**
         * removeIf()
         * 3의 배수를 삭제
         */
        arrayList.removeIf(multiplesOf3);

        for (Integer integer : arrayList) {
            System.out.println("num = " + integer);
        }

        /**
         * replaceAll()
         * 모든 요소에 10을 더하기
         */
        arrayList.replaceAll(s-> s + 10);

        for (Integer integer : arrayList) {
            System.out.println(" Num add 10 = " + integer);
        }
        /**
         * forEach()
         * 요소 뒤에 ", " 붙히기
         */
        arrayList.forEach(i-> System.out.print(i+", "));

        Map<String, String> food = new HashMap<>();
        food.put("중식","짜장면");
        food.put("일식","초밥");
        food.put("한식","비빔밥");
        food.put("양식","피자");
        System.out.println();

        /**
         *compute()
         */
        String menu1 = food.compute("중식", (a, b) -> a +"의 추천 메뉴는 : "+ b+"가격은 5000원 입니다.");
        System.out.println("menu1 = " + menu1);

        /**
         *computeAbsent()
         */
        String menu2 = food.computeIfAbsent("태국식", (a) -> a +"은 없는 메뉴입니다.");
        System.out.println("menu2 = " + menu2);

        /**
         *computeIfPresent()
         */
        String menu3 = food.computeIfPresent("일식", (a,b) -> a +"의 추천 메뉴는 "+b+" 입니다.");
        System.out.println("menu3 = " + menu3);

        /**
         *merge()
         */
        String menu4 = food.merge("일식","초밥" ,(a,b) -> a +" 변경을 원하시면  "+b+"은 고등어 초밥으로 변경가능 합니다.");
        System.out.println("menu4 = " + menu4);

        System.out.println("==============");

        /**
         *forEach()
         */
        food.forEach((a,b)-> System.out.println(a+"은 "+b+", "));


        System.out.println("==============");


        /**
         *forEach()
         */
        food.replaceAll((a,b)-> "취소");
        food.forEach((a,b)-> System.out.println(a+"은 "+b+", "));


    }

}
