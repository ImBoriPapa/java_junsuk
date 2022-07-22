package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest03 {
    public static void main(String[] args) {
        /**
         * forEach()
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integerStream.forEach(System.out::print);

        System.out.println();

        /**
         * allMatch()
         * anyMatch()
         * noneMatch()
         * findFirst()
         * findAny()
         */
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean allMatch = integerStream1.allMatch(s -> s.intValue() < 11);
        System.out.println("allMatch = " + allMatch);

        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean anyMatch = integerStream2.anyMatch(s -> s.intValue() == 5);
        System.out.println("anyMatch = " + anyMatch);

        Stream<Integer> integerStream3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean noneMatch = integerStream3.noneMatch(s -> s.intValue() == 100);
        System.out.println("noneMatch = " + noneMatch);

        Stream<Integer> integerStream4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> first = integerStream4.filter(s -> s.intValue() <= 10).findFirst();
        System.out.println("first = " + first.orElse(0));

        Stream<Integer> integerStream5 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> any = integerStream5.parallel().filter(s -> s.intValue() <= 10).findAny();
        System.out.println("any.orElse(0) = " + any.orElse(0));

        /**
         * count()
         * sum()
         * average()
         * max()
         * min()
         */
        Stream<Integer> integerStream6 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("integerStream6.count() = " + integerStream6.count());

        Stream<Integer> integerStream7 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = integerStream7.mapToInt(Integer::intValue).sum();
        System.out.println("sum = " + sum);

        Stream<Integer> integerStream8 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalDouble average = integerStream8.mapToDouble(Integer::shortValue).average();
        System.out.println("average = " + average);

        Stream<Integer> integerStream9 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> max = integerStream9.max(Comparator.comparing(Integer::shortValue));
        System.out.println("max = " + max.orElse(0));

        Stream<Integer> integerStream10 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> min = integerStream10.min(Comparator.comparing(Integer::shortValue));
        System.out.println("min = " + min.orElse(0));

        /**
         * reduce()
         */
        Stream<Integer> integerStream11 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int reduce_count = integerStream11.reduce(0, (a, b) -> a + 1);
        System.out.println("reduce_count = " + reduce_count);

        Stream<Integer> integerStream12 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int reduce_sum = integerStream12.reduce(0, (a, b) -> a + b);
        System.out.println("reduce_sum = " + reduce_sum);

        Stream<Integer> integerStream13 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int reduce_max = integerStream13.reduce(Integer.MIN_VALUE, (a, b) -> a>b ? a:b);
        System.out.println("reduce_max = " + reduce_max);

        Stream<Integer> integerStream14 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int reduce_min = integerStream14.reduce(Integer.MAX_VALUE, (a, b) -> a<b ? a:b);
        System.out.println("reduce_min = " + reduce_min);

        /**
         * collect()
         * toList(),toSet().toCollection(),toArray()
         */
        Employee[] employees = {
                new Employee("이인턴",Rank.INTERN,Department.SALES_TEAM,"S-M-2022-1234",3000000),
                new Employee("심사원",Rank.STAFF,Department.PLANNING_DEPT,"P-F-2020-1234",4000000),
                new Employee("김사원",Rank.STAFF,Department.SALES_TEAM,"S-M-2021-1234",4500000),
                new Employee("한사원",Rank.STAFF,Department.PURCHASING_DEPT,"PU-F-2019-1234",4000000),
                new Employee("홍매니저",Rank.MANAGER,Department.PLANNING_DEPT,"P-M-2016-1234",7000000),
                new Employee("강매니저",Rank.MANAGER,Department.OVERSEAS_BUSINESS_DEPT,"S-F-2017-1234",8000000),
                new Employee("이사원",Rank.STAFF,Department.SALES_TEAM,"S-M-2021-1234",4000000),
                new Employee("김인턴",Rank.INTERN,Department.PURCHASING_DEPT,"PU-F-2021-1234",3000000),
        };

        //toList
        List<String> employeesName = Stream.of(employees).map(Employee::getName).collect(Collectors.toList());
        employeesName.forEach(System.out::println);
        //toMap
        Map<String, Rank> employeesRank = Stream.of(employees)
                .collect(Collectors.toMap(e->e.getName(),Employee::getRank));
        for (String name : employeesRank.keySet()) {
            System.out.println(name+" Rank ="+employeesRank.get(name));
        }
        //toSet
        Set<Integer> employeeSalary = Stream.of(employees).map(Employee::getSalary).collect(Collectors.toSet());
        OptionalDouble salaryAverage = employeeSalary.stream().mapToInt(Integer::intValue).average();
        System.out.println(salaryAverage.orElse(0));
        //toCollection()
        ArrayList<Employee> employeeArrayList = Stream.of(employees).collect(Collectors.toCollection(ArrayList::new));
        for (Employee employee : employeeArrayList) {
            System.out.println("employeeArrayList.getName() = " + employee.getName());
        }
        //toArray
        Employee[] employees2 = Stream.of(employees).toArray(Employee[]::new);
        for (Employee employee : employees2) {
            System.out.println("name ="+employee.getName()+" employeeNumber = " + employee.getEmployeeNumber());
        }


    }
}
class Employee{
    private String name;
    private Rank rank;
    private Department department;
    private String employeeNumber;
    private int salary;

    public Employee() {
    }

    public Employee(String name, Rank rank, Department department, String employeeNumber, int salary) {
        this.name = name;
        this.rank = rank;
        this.department = department;
        this.employeeNumber = employeeNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}