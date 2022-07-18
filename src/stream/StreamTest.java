package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

public class StreamTest {
    public static void main(String[] args) {
        String[] animals = {"고양이", "개", "코끼리", "사슴","기린","토끼","곰","낙타","구관조"};
        List<String> strList = Arrays.asList(animals);

        Stream<String> strStream1 = strList.stream();
        Stream<String> strStream2 = Arrays.stream(animals);

//        strStream1.sorted().forEach(System.out::print);
//        strStream2.sorted().forEach(System.out::print);

        List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
//        sortedList.forEach(System.out::println);

        int sum = strStream1.parallel()
                .mapToInt(s -> s.length())
                .sum();

        /**
         * List 로 부터 스트림 생성
         */
        List<Integer> scores = Arrays.asList(100, 90, 80, 70, 60, 50, 40, 30, 20, 10);
        Stream<Integer> scoreStream = scores.stream();

        /**
         * String 배열
         */
        Stream<String> fish = Stream.of("광어", "우럭", "민어");
        Stream<String> snack = Stream.of(new String[]{"계란과자", "달고나", "소라과자", "새우깡"});
        Stream<String> nation = Arrays.stream(new String[]{"한국", "미국", "일본", "영국", "프랑스", "호주"});

        /**
         * int,long,double 타입 배열
         */
        IntStream year = IntStream.of(2000, 2001, 2002, 2003, 2004, 2005);
        LongStream justLongTypes = LongStream.of(1L, 2L, 3L, 4L);
        DoubleStream justDoubleTypes = DoubleStream.of(1d, 2d, 3d, 4d, 5d);

        IntStream range = IntStream.range(1, 10);
        IntStream rangeClosed = IntStream.rangeClosed(10, 20);


        /**
         * n * 2
         */
        IntStream ints = new Random().ints(1,10);
        ints.limit(10).sorted().forEach(System.out::print);

        System.out.println("================================");

        Stream<Integer> iterate = Stream.iterate(1, n -> n*2);
        iterate.limit(10).forEach(System.out::println);

        /**
         * Math::random
         */
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(5).forEach(System.out::println);

        /**
         * 비어있는 스트림
         */
        Stream<Object> empty = Stream.empty();
        long count = empty.count();
        System.out.println("count = " + count);

        String[] number1 = {"하나", "둘", "셋"};
        String[] number2 = {"넷", "다섯", "여섯"};
        Stream<String> numbers1 = Stream.of(number1);
        Stream<String> numbers2 = Stream.of(number2);
        Stream<String> concat = Stream.concat(numbers1, numbers2);
        concat.forEach(System.out::println);


    }
}
