package lambda;

import java.util.function.Function;

public class LambdaTest   {

    /**
     * int max(int a, int b){
     *     return a > b? a:b;
     * }
     * ->
     * ( a,  b) -> a > b a:b
     */

    /**
     * int printVar(String name, int i){
     *     System.out.println(name+"="+i");
     *}
     *  ->
     *
     *  ( name,  i) -> System.out.println(name+"="+i")
     */

    /**
     * int square(int x){
     *     return x * x;
     * }
     * ->
     *
     *  x -> x * x
     */

    /**
     * int roll() {
     *     return (int)(Math.random()*6);
     * }
     *
     * ()-> (int)(int)(Math.random()*6)
     */



}

