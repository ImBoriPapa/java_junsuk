package lambda;

import java.util.function.Function;

public class LambdaExample {

    public static void main(String[] args) {
        Function<String,Integer> f  =(s) -> Integer.parseInt(s,16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
        Function<String, String> h = f.andThen(g);

        int ff = Integer.parseInt("true", 16);
        System.out.println("ff = " + ff);


        String input = "ff";

        System.out.println("h.apply("+input+") = " + h.apply(input));
    }

}

