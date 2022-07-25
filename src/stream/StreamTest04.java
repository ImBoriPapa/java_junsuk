package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        Employee[] employees = {

        };
        /**
         * counting()
         * summingInt()
         * averagingInt()
         * maxBy()
         * minBy()
         */
        Stream<Employee> employeeStream1 = Stream.of(employees);
        long count = employeeStream1.count();
        System.out.println("count = " + count);

        Stream<Employee> employeeStream2 = Stream.of(employees);
        Long collect_counting = employeeStream2.collect(Collectors.counting());
        System.out.println("collect_counting = " + collect_counting);

        Stream<Employee> employeeStream3 = Stream.of(employees);
        Integer sumSalary = employeeStream3.collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("sumSalary = " + sumSalary);

        Stream<Employee> employeeStream4 = Stream.of(employees);
        Double average = employeeStream4.collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println("average = " + average);

        Stream<Employee> employeeStream5 = Stream.of(employees);
        Optional<Employee> max = employeeStream5.collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println("max.get() = " + max.get().getSalary());

        Stream<Employee> employeeStream6 = Stream.of(employees);
        Optional<Employee> min = employeeStream6.collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println("minx.get() = " + min.get().getSalary());

        /**
         * reducing()
         */

        Stream<Employee> employeeStream7 =Stream.of(employees);
        IntStream intStream = employeeStream7.mapToInt(Employee::getSalary);
        OptionalInt reduceMax = intStream.reduce(Integer::max);
        System.out.println("reduceMax = " + reduceMax.getAsInt());

        /**
         * joining()
         */
        Stream<Employee> employeeStream8 = Stream.of(employees);
        String joining1 = employeeStream8.map(Employee::getName).collect(Collectors.joining());
        System.out.println("joining1 = " + joining1);

        Stream<Employee> employeeStream9 = Stream.of(employees);
        String joining2 = employeeStream9.map(Employee::getName).collect(Collectors.joining(","));
        System.out.println("joining2 = " + joining2);

        Stream<Employee> employeeStream10 = Stream.of(employees);
        String joining3 = employeeStream10.map(Employee::getName).collect(Collectors.joining(",","우리 회사 사원들의 이름은 ","입니다."));
        System.out.println("joining3 = " + joining3);




    }
}
