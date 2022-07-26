package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        /**
         * groupingBy()
         * partitioningBy()
         */
        Dog[] dogs = {
                new Dog("뽀삐", true, 3, 8),
                new Dog("규삐", false, 5, 2),
                new Dog("구삐", true, 1, 1),
                new Dog("김삐", false, 13, 8),
                new Dog("이삐", true, 2, 6),
                new Dog("쭈삐", true, 1, 7),
                new Dog("큥삐", false, 3, 8),
                new Dog("유삐", true, 7, 9),
                new Dog("삐삐", false, 7, 10),
                new Dog("큐삐", true, 10, 8)
        };
        Stream<Dog> dogs1 = Stream.of(dogs);
        Map<Boolean, List<Dog>> dogBySex = dogs1.collect(Collectors.partitioningBy(Dog::isMale));
        List<Dog> maleDogs = dogBySex.get(true);
        List<Dog> femaleDogs = dogBySex.get(false);

        maleDogs.forEach(n -> System.out.println("maleDogs.name = " + n.name));
        femaleDogs.forEach(n -> System.out.println("femaleDogs.name = " + n.name));

        Stream<Dog> dogs2 = Stream.of(dogs);
        Map<Boolean, Long> dogsNumBySex = dogs2.collect(Collectors.partitioningBy(Dog::isMale, Collectors.counting()));
        System.out.println("수컷 개의 마리수 = " + dogsNumBySex.get(true));
        System.out.println("암컷 개의 마리수 = " + dogsNumBySex.get(false));

        Stream<Dog> dogs3 = Stream.of(dogs);
        Map<Boolean, Map<Boolean, List<Dog>>> dogsNameOverThen7Years = dogs3.collect(Collectors.partitioningBy(Dog::isMale, Collectors.partitioningBy(a -> a.age > 7)));

        for (Dog d : dogsNameOverThen7Years.get(true).get(true))
            System.out.println(" maleDogsNameOverThen7Years= " + d);
        for (Dog d : dogsNameOverThen7Years.get(true).get(true))
            System.out.println(" femaleDogsNameOverThen7Years= " + d);

        /**
         * groupingBy()
         */
        Stream<Dog> dog4 = Stream.of(dogs);
        Map<String, List<Dog>> dogList = dog4.collect(Collectors.groupingBy(Dog::getName));
        for (String names : dogList.keySet()) {
            System.out.println("dog name = " + names);
        }

        Stream<Dog> dog5 = Stream.of(dogs);
        Map<Integer, Map<Integer, List<Dog>>> dogByAgeAndWeight = dog5.collect(
                Collectors.groupingBy(Dog::getAge,
                        Collectors.groupingBy(Dog::getWeight)
                ));
        for (Integer integer : dogByAgeAndWeight.keySet()) {
            System.out.println("integer = " + integer);
        }


    }
}

class Dog {
    String name;
    boolean isMale;
    int age;
    int weight;

    public Dog(String name, boolean isMale, int age, int weight) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
