package lambda;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;
        
        Integer f1_result = f1.apply("1");
        System.out.println("f1_result = " + f1_result);
        System.out.println("f2.apply().intValue() = " + f2.apply("2").intValue());

        BiFunction<String, String, Boolean> f3 = (s1, s2) -> s1.equals(s2);
        BiFunction<String, String, Boolean> f4 = String::equals;

        System.out.println("f = " + f3.apply("key", "key").booleanValue());
        System.out.println("f = " + f4.apply("key", "key").booleanValue());

        MyClass obj = new MyClass();
        Function<String, Boolean> f5 = (x) -> obj.equals(x);
        Function<String, Boolean> f6 = obj::equals;
        UnaryOperator<String> f7 = obj::function;

        System.out.println("f5.apply().booleanValue() = " + f5.apply("isSame").booleanValue());
        System.out.println("f6.apply().booleanValue() = " + f6.apply("isSame").booleanValue());
        System.out.println("f7 = " + f7.apply("더하기해봐요"));

        BiFunction<Integer,Integer,Integer> plus = obj::plus;
        BiFunction<Integer,Integer,Integer> minus = obj::minus;
        BiFunction<Integer,Integer,Integer> multiply = obj::multiply;
        BiFunction<Integer,Integer,Integer> divide = obj::divide;

        System.out.println("plus = " + plus.apply(10, 10).intValue());
        System.out.println("minus = " + minus.apply(10, 10).intValue());
        System.out.println("multiply = " + multiply.apply(10, 10).intValue());
        System.out.println("divide = " + divide.apply(10, 10).intValue());

        /**
         *  기본생성자 메서드 참조
         */
        Supplier<MyClass2> mc1 = MyClass2::new;

        /**
         * 매개변수가 있는 생성자 참조
         */
        BiFunction<String,Integer,MyClass2> mc2 = MyClass2::new;

        /**
         * 배열 생성
         */
        Function<Integer,int[]> test = int[]::new;
    }
}
class MyClass{

    int plus(int a,int b){
        return a+b;
    }

    int minus(int a,int b){
        return a-b;
    }

    int multiply(int a,int b){
        return a*b;
    }
    int divide(int a,int b){
        return a/b;
    }

    String function(String a){
        return a + a;
    }
}

class MyClass2{

    private String name;
    private int age;

    public MyClass2() {}

    public MyClass2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
