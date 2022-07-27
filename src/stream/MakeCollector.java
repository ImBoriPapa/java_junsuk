package stream;


import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class MakeCollector {
    public static void main(String[] args) {
        String[] word = {"안", "녕", "하", "세", "요"};
        Stream<String> wordStream = Stream.of(word);
        String result = wordStream.collect(new MyCollector());

        System.out.println("Arrays.toString(word) = " + Arrays.toString(word));
        System.out.println("result = " + result);
    }

}

class MyCollector implements Collector<String,StringBuilder,String> {

    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return StringBuilder::append;
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return StringBuilder::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
