package stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.LocalDateTime.*;
import static stream.OrderStatus.*;

public class StreamTest02 {
    public static void main(String[] args) {
        /**
         * skip()
         * limit()
         */
        int[] numbers = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000};
        Arrays.stream(numbers).skip(3).limit(5).forEach(System.out::println);

        /**
         * distinct()
         */
        Stream<String> alphabet = Stream.of("a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g");
        alphabet.distinct().forEach(System.out::println);

        /**
         * filter()
         */
        Stream<String> status1 = Stream.of("배송준비", "배송중", "배송완료");
        Stream<String> status2 = Stream.of("결제진행", "결제실패", "결제완료", "배송준비", "배송중", "배송완료");

        status1.filter(n -> n.equals("배송완료")).forEach(System.out::println);
        status2.filter(n -> n != "결제진행").filter(n -> n != "배송완료").forEach(System.out::println);

        /**
         *-기본 정렬 sort()
         *Comparator.naturalOrder()
         * (s1,s2)->s1.compareTo(s2)
         * String::compareTo
         *
         * -역순 정렬
         * sorted(Comparator.reverseOrder())
         *
         * -  대소문자 구분 안함
         *  sorted(String.CASE_INSENSITIVE_ORDER)
         *
         *  - 길이 순 정렬
         *sorted(Comparator.comparing(String::length))
         */
        Stream<String> words = Stream.of("Hide", "glory", "zoo", "Food", "King", "tiger", "sky", "oh!", "Love", "Money");
        words.sorted().forEach(System.out::println);

        Stream<String> words2 = Stream.of("Hide", "glory", "zoo", "Food", "King", "tiger", "sky", "oh!", "Love", "Money");
        words2.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Stream<String> words3 = Stream.of("Hide", "glory", "zoo", "Food", "King", "tiger", "sky", "oh!", "Love", "Money");
        words3.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);

        Stream<String> words4 = Stream.of("Hide", "glory", "zoo", "Food", "King", "tiger", "sky", "oh!", "Love", "Money");
        words4.sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        Stream<Member> members = Stream.of(
                new Member(1L, "member1", now()),
                new Member(2L, "member2", now()),
                new Member(3L, "member3", now()),
                new Member(4L, "member4", now()),
                new Member(5L, "member5", now()),
                new Member(6L, "member6", now())
        );

        members.sorted(Comparator.comparing(Member::getSignUpDate)
                        .thenComparing(Member::getId))
                .forEach(System.out::println);


        /**
         * 변환 - map()
         */
        Stream.of(
                        new Order(1L, "남성옷", 1000, now(), PREPARING),
                        new Order(2L, "남성옷", 2000, now(), SHIPPING),
                        new Order(3L, "여성옷", 4000, now(), PREPARING),
                        new Order(4L, "유아옷", 1000, now(), PREPARING),
                        new Order(5L, "가전제품", 10000, now(), DELIVERY_COMPLETED),
                        new Order(6L, "신선식품", 2000, now(), SHIPPING)
                ).map(Order::getOrderStatus)
                .filter(n -> n == PREPARING)
                .map(n -> n + ", 배송이 완료되었습니다.")
                .sorted()
                .forEach(System.out::println);


        /**
         * mapToInt(),
         * mapToLong(),
         * mapToDouble()
         */
        Stream<Order> Orders = Stream.of(
                new Order(1L, "남성옷", 1000, now(), PREPARING),
                new Order(2L, "남성옷", 2000, now(), SHIPPING),
                new Order(3L, "여성옷", 4000, now(), PREPARING),
                new Order(4L, "유아옷", 1000, now(), PREPARING),
                new Order(5L, "가전제품", 10000, now(), DELIVERY_COMPLETED),
                new Order(6L, "신선식품", 2000, now(), SHIPPING)
        );
        /**
         *int result = sum()
         *OptionalDouble result = average()
         *OptionalInt result =  max()
         *OptionalInt result =  min()
         */


//        IntStream sum = Orders.mapToInt(Order::getPrice);
//        IntStream average = Orders.mapToInt(Order::getPrice); //스트림을 다시 생성해야 한다.
//        IntStream max = Orders.mapToInt(Order::getPrice);
//        IntStream min = Orders.mapToInt(Order::getPrice);

//        System.out.println("price sum = " + sum.sum());

        /**
         * summaryStatistics()
         * double result = getAverage()
         * long result = getCount()
         * int result = getMin()
         * int result = getMax()
         * long result = getSum()
         */
//        IntStream intStream = Orders.mapToInt(Order::getPrice);
//        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
//        double average = intSummaryStatistics.getAverage();
//        long count = intSummaryStatistics.getCount();
//        int min = intSummaryStatistics.getMin();

        /**
         * flatMap()
         */
        Stream<String[]> quantityList = Stream.of(
                new String[]{"여성의류", "남성의류", "유아의류"},
                new String[]{"냉장식품", "냉동식품", "가공식품"},
                new String[]{"가구", "가전", "잡화"}
        );
        Stream<String> streamList = quantityList.flatMap(Arrays::stream);
        streamList.forEach(System.out::print);

        System.out.println();

    }

}

